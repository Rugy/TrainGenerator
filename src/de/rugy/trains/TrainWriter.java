package de.rugy.trains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Deque;

public class TrainWriter {

	public static void writeToFile(String fileName, Deque<Train> trains) {
		Path target = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".pl");
		String[] modes = getModes();
		String[] determinations = getDeterminations();
		String[] typeDefs = getTypeDefs(trains);
		String[] trainDescription = getTrainDescription(trains);

		try {
			if (Files.exists(target)) {
				Files.delete(target);
			}
			target = Files.createFile(target);
			write(modes, target);
			write(determinations, target);
			write(typeDefs, target);
			write(trainDescription, target);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String[] getModes() {
		String[] modes = new String[Attribute.values().length];
		modes[0] = ":- modeh(1,eastbound(+train)).";
		modes[1] = ":- modeb(1,small(+car)).";
		modes[2] = ":- modeb(1,large(+car)).";
		modes[3] = ":- modeb(*,has_car(+train,-car)).";

		return modes;
	}

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

	private static String[] getTrainDescription(Deque<Train> trains) {
		String[] trainDescr = new String[trains.size()];

		for (int i = 0; i < trainDescr.length; i++) {
			trainDescr[i] = trains.poll().toString();
		}

		return trainDescr;
	}

	private static void write(String[] text, Path target) throws IOException {
		for (int i = 0; i < text.length; i++) {
			Files.write(target, (text[i] + "\n").getBytes(),
					StandardOpenOption.APPEND);
		}
		Files.write(target, "\n".getBytes(), StandardOpenOption.APPEND);
	}

}
