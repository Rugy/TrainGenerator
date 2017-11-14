package de.rugy.trains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import de.rugy.trains.enums.CarShape;
import de.rugy.trains.enums.Feature;
import de.rugy.trains.model.Train;
import de.rugy.trains.model.Wagon;

public class TrainWriter {

	public static void writeAlephFile(String fileName, Deque<Train> trains) {
		// Background Knolwedge
		Path targetB = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".b");

		String[] modes = getModes();
		String[] determinations = getDeterminations();
		String[] typeDefs = getTypeDefs(trains);
		List<String[]> trainDescription = getTrainDescription(trains);

		try {
			if (Files.exists(targetB)) {
				Files.delete(targetB);
			}
			targetB = Files.createFile(targetB);
			write(modes, targetB);
			write(determinations, targetB);
			write(typeDefs, targetB);
			for (String[] aDescription : trainDescription) {
				write(aDescription, targetB);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Positive Examples
		Path targetF = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".f");
		List<String> positives = getPositives(trains);

		try {
			if (Files.exists(targetF)) {
				Files.delete(targetF);
			}
			targetF = Files.createFile(targetF);
			writeList(positives, targetF);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Negative Examples
		Path targetN = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".n");
		List<String> negatives = getNegatives(trains);

		try {
			if (Files.exists(targetN)) {
				Files.delete(targetN);
			}
			targetN = Files.createFile(targetN);
			writeList(negatives, targetN);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// update manually
	private static String[] getModes() {
		String[] modes = new String[8];
		modes[0] = ":- modeh(1,eastbound(+train)).";
		modes[1] = ":- modeb(1,small(+car)).";
		modes[2] = ":- modeb(1,large(+car)).";
		modes[3] = ":- modeb(1,shape(+car,#shape)).";
		modes[4] = ":- modeb(1,wheels(+car,#int)).";
		modes[5] = ":- modeb(*,has_car(+train,-car)).";
		modes[6] = ":- modeb(*,infront(+car,-car)).";
		modes[7] = ":- modeb(1,medium(+car)).";

		return modes;
	}

	// update manually
	private static String[] getDeterminations() {
		String[] determinations = new String[9];
		determinations[0] = ":- determination(eastbound/1,small/1).";
		determinations[1] = ":- determination(eastbound/1,large/1).";
		determinations[2] = ":- determination(eastbound/1,shape/2).";
		determinations[3] = ":- determination(eastbound/1,wheels/2).";
		determinations[4] = ":- determination(eastbound/1,has_car/2).";
		determinations[5] = ":- determination(eastbound/1,infront/2).";
		determinations[6] = ":- determination(eastbound/1,medium/1).";
		determinations[7] = "";
		determinations[8] = "infront(A,C) :- infront(A,B), infront(B,C).";

		return determinations;
	}

	private static String[] getTypeDefs(Deque<Train> trains) {
		String[] typeDefs = new String[trains.size() * 2 + 2
				+ CarShape.values().length];
		int i = 0;

		// Car typedefs
		for (Train aTrain : trains) {
			StringBuilder cars = new StringBuilder();

			for (int j = 0; j < aTrain.getMaxWagons(); j++) {
				cars.append("car(" + aTrain.getWagons().get(j).toString()
						+ "). ");
			}

			typeDefs[i] = cars.toString();
			i++;
		}

		// Train typedefs
		typeDefs[trains.size()] = "";
		int k = trains.size() + 1;

		for (Train aTrain : trains) {
			typeDefs[k] = "train(" + aTrain.getDirection()
					+ aTrain.getTrainNumber() + ").";
			k++;
		}

		typeDefs[k] = "";
		k++;
		// Shape typedefs
		for (int j = 0; j < CarShape.values().length; j++) {
			typeDefs[k] = "shape("
					+ CarShape.values()[j].toString().toLowerCase() + ").";
			k++;
		}

		return typeDefs;
	}

	private static List<String[]> getTrainDescription(Deque<Train> trains) {
		List<String[]> trainDescr = new ArrayList<>();
		int featureCount = Feature.values().length;

		for (Train aTrain : trains) {
			String[] featureDef = new String[aTrain.getMaxWagons()
					* featureCount + aTrain.getMaxWagons() - 1];
			int k = 0;

			// Size
			for (int i = 0; i < aTrain.getMaxWagons(); i++) {
				Wagon wagon = aTrain.getWagons().get(i);
				featureDef[k] = wagon.getSize().toString().toLowerCase() + "("
						+ wagon.toString() + ").";
				k++;
			}

			// Wheels
			for (int i = 0; i < aTrain.getMaxWagons(); i++) {
				Wagon wagon = aTrain.getWagons().get(i);
				featureDef[k] = "wheels(" + wagon.toString() + ","
						+ wagon.getWheelNumber() + ").";
				k++;
			}

			// CarShape
			for (int i = 0; i < aTrain.getMaxWagons(); i++) {
				Wagon wagon = aTrain.getWagons().get(i);
				featureDef[k] = "shape(" + wagon.toString() + ","
						+ wagon.getCarShape().toString().toLowerCase() + ").";
				k++;
			}

			// Has_Car
			for (int i = 0; i < aTrain.getMaxWagons(); i++) {
				featureDef[k] = "has_car(" + aTrain.getDirection()
						+ aTrain.getTrainNumber() + ","
						+ aTrain.getWagons().get(i).toString() + ").";
				k++;
			}

			// InFront
			for (int i = 0; i < aTrain.getMaxWagons() - 1; i++) {
				featureDef[k] = "infront("
						+ aTrain.getWagons().get(i).toString() + ","
						+ aTrain.getWagons().get(i + 1).toString() + ").";
				k++;
			}

			trainDescr.add(featureDef);
		}

		return trainDescr;
	}

	private static List<String> getPositives(Deque<Train> trains) {
		List<String> positives = new ArrayList<>();

		for (Train aTrain : trains) {
			if (aTrain.isEastBound()) {
				positives.add("eastbound(" + aTrain.getDirection()
						+ aTrain.getTrainNumber() + ").");
			}
		}

		return positives;
	}

	private static List<String> getNegatives(Deque<Train> trains) {
		List<String> negatives = new ArrayList<>();

		for (Train aTrain : trains) {
			if (!aTrain.isEastBound()) {
				negatives.add("eastbound(" + aTrain.getDirection()
						+ aTrain.getTrainNumber() + ").");
			}
		}

		return negatives;
	}

	public static void writeCSVFile(String fileName, Deque<Train> trains,
			boolean allowStrings) {
		Path targetTable = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".csv");

		StringBuilder headerB = new StringBuilder();
		headerB.append("Direction");
		for (int i = 0; i < TrainMain.MAX_TRAINS; i++) {
			headerB.append(",Size" + (i + 1) + ",Wheels" + (i + 1) + ",Shape"
					+ (i + 1));
		}

		StringBuilder[] trainDescrB = new StringBuilder[TrainMain.POSITIVE_EXAMPLES
				+ TrainMain.NEGATIVE_EXAMPLES];
		String[] trainDescr = new String[trainDescrB.length + 1];
		trainDescr[0] = headerB.toString();
		int i = 0;

		for (Train aTrain : trains) {
			int trainNumber = aTrain.getTrainNumber();
			if (trainNumber > TrainMain.POSITIVE_EXAMPLES) {
				trainNumber -= TrainMain.POSITIVE_EXAMPLES;
			}
			trainDescrB[i] = new StringBuilder();
			trainDescrB[i].append(aTrain.getDirection());

			for (Wagon aWagon : aTrain.getWagons()) {
				if (allowStrings) {
					trainDescrB[i].append("," + (aWagon.getSize()));
					trainDescrB[i].append("," + (aWagon.getWheelNumber()));
					trainDescrB[i].append("," + (aWagon.getCarShape()));
				} else {
					trainDescrB[i].append("," + (aWagon.getSize().ordinal()));
					trainDescrB[i].append("," + (aWagon.getWheelNumber()));
					trainDescrB[i].append(","
							+ (aWagon.getCarShape().ordinal()));
				}
			}

			trainDescr[i + 1] = trainDescrB[i].toString();

			i++;
		}

		try {
			if (Files.exists(targetTable)) {
				Files.delete(targetTable);
			}
			targetTable = Files.createFile(targetTable);
			write(trainDescr, targetTable);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void write(String[] text, Path target) throws IOException {
		for (int i = 0; i < text.length; i++) {
			Files.write(target, (text[i] + "\n").getBytes(),
					StandardOpenOption.APPEND);
		}
		Files.write(target, "\n".getBytes(), StandardOpenOption.APPEND);
	}

	private static void writeList(List<String> text, Path target)
			throws IOException {
		for (String aText : text) {
			Files.write(target, (aText + "\n").getBytes(),
					StandardOpenOption.APPEND);
		}
		Files.write(target, "\n".getBytes(), StandardOpenOption.APPEND);
	}

}
