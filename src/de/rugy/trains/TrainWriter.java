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

	public static void writeToFile(String fileName, Deque<Train> trains) {
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
		modes[3] = ":- modeb(*,has_car(+train,-car)).";

		return modes;
	}

	// update manually
	private static String[] getDeterminations() {
		String[] determinations = new String[Attribute.values().length - 1];
		determinations[0] = ":- determination(eastboud/1,small/1).";
		determinations[1] = ":- determination(eastboud/1,large/1).";
		determinations[2] = ":- determination(eastboud/1,has_car/2).";

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
			typeDefs[k] = "train(train" + aTrain.getTrainNumber() + ").";
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

			// Has_Car
			for (int i = 0; i < featureDef.length / featureCount; i++) {
				featureDef[k] = "has_car(train" + aTrain.getTrainNumber() + ","
						+ aTrain.getWagons().get(i).toString() + ").";
				k++;
			}

			trainDescr.add(featureDef);
		}

		return trainDescr;
	}

	private static List<String> getPositives(Deque<Train> trains) {
		List<String> positives = new ArrayList<>();
		boolean east = true;

		while (east) {
			if (trains.peek() != null && trains.peek().isEastBound()) {
				positives.add("eastbound(" + trains.poll().getTrainNumber()
						+ ").");
			} else {
				east = false;
			}
		}

		return positives;
	}

	private static List<String> getNegatives(Deque<Train> trains) {
		List<String> negatives = new ArrayList<>();

		while (trains.peek() != null) {
			negatives.add("eastbound(" + trains.poll().getTrainNumber() + ").");
		}

		return negatives;
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
