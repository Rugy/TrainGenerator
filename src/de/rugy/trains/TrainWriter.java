package de.rugy.trains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import de.rugy.trains.enums.Attribute;
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
		String[] modes = new String[Attribute.values().length];
		modes[0] = ":- modeh(1,eastbound(+train)).";
		modes[1] = ":- modeb(1,small(+car)).";
		modes[2] = ":- modeb(1,large(+car)).";
		modes[3] = ":- modeb(1,wheels(+car,#int)).";
		modes[4] = ":- modeb(*,has_car(+train,-car)).";

		return modes;
	}

	// update manually
	private static String[] getDeterminations() {
		String[] determinations = new String[Attribute.values().length - 1];
		determinations[0] = ":- determination(eastbound/1,small/1).";
		determinations[1] = ":- determination(eastbound/1,large/1).";
		determinations[2] = ":- determination(eastbound/1,wheels/2).";
		determinations[3] = ":- determination(eastbound/1,has_car/2).";

		return determinations;
	}

	private static String[] getTypeDefs(Deque<Train> trains) {
		String[] typeDefs = new String[trains.size() * 2 + 1];
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

		typeDefs[trains.size()] = "";

		// Train typedefs
		int k = trains.size() + 1;

		for (Train aTrain : trains) {
			typeDefs[k] = "train(" + aTrain.getDirection()
					+ aTrain.getTrainNumber() + ").";
			k++;
		}

		return typeDefs;
	}

	private static List<String[]> getTrainDescription(Deque<Train> trains) {
		List<String[]> trainDescr = new ArrayList<>();
		int featureCount = Feature.values().length;

		for (Train aTrain : trains) {
			String[] featureDef = new String[aTrain.getMaxWagons()
					* featureCount];
			int k = 0;

			// Size
			for (int i = 0; i < featureDef.length / featureCount; i++) {
				Wagon wagon = aTrain.getWagons().get(i);
				featureDef[k] = wagon.getSize().toString().toLowerCase() + "("
						+ wagon.toString() + ").";
				k++;
			}

			// Wheels
			for (int i = 0; i < featureDef.length / featureCount; i++) {
				Wagon wagon = aTrain.getWagons().get(i);
				featureDef[k] = "wheels(" + wagon.toString() + ","
						+ wagon.getWheelNumber() + ").";
				k++;
			}

			// Has_Car
			for (int i = 0; i < featureDef.length / featureCount; i++) {
				featureDef[k] = "has_car(" + aTrain.getDirection()
						+ aTrain.getTrainNumber() + ","
						+ aTrain.getWagons().get(i).toString() + ").";
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
			negatives.add("eastbound(" + aTrain.getDirection()
					+ aTrain.getTrainNumber() + ").");
		}

		return negatives;
	}

	public static void writeCSVFile(String fileName, Deque<Train> trains) {
		Path targetTable = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".csv");

		StringBuilder headerB = new StringBuilder();
		headerB.append("TrainName");
		for (int i = 0; i < TrainMain.MAX_TRAINS; i++) {
			headerB.append(",Size" + (i + 1) + ",Wheels" + (i + 1));
		}

		StringBuilder[] trainDescrB = new StringBuilder[1
				+ TrainMain.POSITIVE_EXAMPLES + TrainMain.NEGATIVE_EXAMPLES];
		String[] trainDescr = new String[trainDescrB.length];
		trainDescr[0] = headerB.toString();
		int i = 1;

		for (Train aTrain : trains) {
			trainDescrB[i] = new StringBuilder();
			trainDescrB[i].append(aTrain.getDirection()
					+ aTrain.getTrainNumber());

			for (Wagon aWagon : aTrain.getWagons()) {
				trainDescrB[i].append(","
						+ aWagon.getSize().toString().toLowerCase() + ","
						+ aWagon.getWheelNumber());
			}
			trainDescr[i] = trainDescrB[i].toString();

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
