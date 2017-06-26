package de.rugy.trains;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import de.rugy.trains.enums.Size;
import de.rugy.trains.model.Train;
import de.rugy.trains.model.Wagon;

public class TrainMain {

	public static final int POSITIVE_EXAMPLES = 5;
	public static final int NEGATIVE_EXAMPLES = 5;
	public static final int MAX_TRAINS = 3;

	public static void main(String[] args) {

		Deque<Train> trainsSorted = new LinkedList<>();
		int positiveCount = 0;
		int negativeCount = 0;

		while (positiveCount < POSITIVE_EXAMPLES
				|| negativeCount < NEGATIVE_EXAMPLES) {
			Train train = createTrain();

			if (train.isEastBound() && positiveCount < POSITIVE_EXAMPLES) {
				trainsSorted.addFirst(train);
				positiveCount++;
			} else if (!train.isEastBound()
					&& negativeCount < NEGATIVE_EXAMPLES) {
				trainsSorted.addLast(train);
				negativeCount++;
			}
		}

		int count = 1;
		for (Train aTrain : trainsSorted) {
			aTrain.setTrainNumber(count);
			count++;
		}

		TrainWriter.writeAlephFile("train", trainsSorted);
		TrainWriter.writeCSVFile("train", trainsSorted);
	}

	private static Train createTrain() {
		int maxWagons = (int) (Math.random() * MAX_TRAINS + 1);
		Train train = new Train(maxWagons);
		fillTrain(train);
		setEastBound(train);

		return train;
	}

	private static void fillTrain(Train train) {
		for (int i = 0; i < train.getMaxWagons(); i++) {
			int sizeType = (int) (Math.random() * 2);
			int wheels = (int) (Math.random() * 3 + 2);
			train.addWagon(new Wagon(i + 1, Size.values()[sizeType], wheels));
		}
	}

	// Filter for Eastbound
	private static void setEastBound(Train train) {
		if (train.getMaxWagons() == 2) {
			List<Wagon> wagons = train.getWagons();

			if (wagons.get(0).getSize() == Size.SMALL
					&& wagons.get(0).getWheelNumber() == 4) {
				train.setEastBound(true);
			}
		}
	}

}
