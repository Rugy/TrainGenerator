package de.rugy.trains;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import de.rugy.trains.enums.CarShape;
import de.rugy.trains.enums.Size;
import de.rugy.trains.model.Train;
import de.rugy.trains.model.Wagon;

public class TrainMain {

	public static final int POSITIVE_EXAMPLES = 5;
	public static final int NEGATIVE_EXAMPLES = 5;
	public static final int MIN_TRAINS = 2;
	public static final int MAX_TRAINS = 2;

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
		TrainWriter.writeCSVFile("train", trainsSorted, true);
	}

	private static Train createTrain() {
		int maxWagons = (int) (Math.random() * (MAX_TRAINS - MIN_TRAINS + 1) + MIN_TRAINS);
		Train train = new Train(maxWagons);
		fillTrain(train);
		setEastBound(train);

		return train;
	}

	private static void fillTrain(Train train) {
		for (int i = 0; i < train.getMaxWagons(); i++) {
			int sizeType = (int) (Math.random() * Size.values().length);
			int wheels = (int) (Math.random() * 4 + 2);
			int carShapeType = (int) (Math.random() * CarShape.values().length);
			train.addWagon(new Wagon(i + 1, Size.values()[sizeType], wheels,
					CarShape.values()[carShapeType]));
		}
	}

	// Filter for Eastbound
	private static void setEastBound(Train train) {
		List<Wagon> wagons = train.getWagons();

		/**
		 * Random Large Train und danach ein 4 Räder oder Shape Circle
		 */
		/*
		 * int firstWagonNumber = (int) (Math.random() (train.getMaxWagons() -
		 * 1) + 1); int secondWagonNumber = (int) (Math.random()
		 * (train.getMaxWagons() - firstWagonNumber) + 1 + firstWagonNumber);
		 * System.out.println("Max are: " + train.getMaxWagons() +
		 * " firstWagon is #: " + firstWagonNumber + " secondWagon is: #: " +
		 * secondWagonNumber);
		 * 
		 * Wagon firstWagon = train.getWagons().get(firstWagonNumber - 1); Wagon
		 * secondWagon = train.getWagons().get(secondWagonNumber - 1); for (int
		 * i = 0; i < train.getMaxWagons(); i++) { if
		 * (train.getWagons().get(i).getSize() == Size.LARGE) { for (int j = i +
		 * 1; j < train.getMaxWagons(); j++) { if
		 * (train.getWagons().get(j).getWheelNumber() == 4) {
		 * train.setEastBound(true); } if
		 * (train.getWagons().get(j).getCarShape() == CarShape.CIRCLE) {
		 * train.setEastBound(true); } } } }
		 */

		/**
		 * More than 3 and More than 2 Circles
		 */
		/*
		 * if (train.getMaxWagons() >= 3) { int circleLoads = 0; for (Wagon
		 * aWagon : train.getWagons()) { if (aWagon.getCarShape() ==
		 * CarShape.CIRCLE) { circleLoads++; } } if (circleLoads >= 2) {
		 * train.setEastBound(true); } }
		 */

		/**
		 * 2 Wagons: Left larger than right
		 */
		// if (train.getWagons().get(0).getSize().ordinal() == train.getWagons()
		// .get(1).getSize().ordinal() + 1) {
		// train.setEastBound(true);
		// }

		/**
		 * 4+ Wagons: Circel then Large
		 */
		// if (train.getMaxWagons() > 3
		// && train.getWagons().get(0).getCarShape() == CarShape.CIRCLE
		// && train.getWagons().get(3).getSize() == Size.LARGE) {
		// train.setEastBound(true);
		// }

		/**
		 * Some Large && Wheels next = 5 && wagonsCount
		 */
		// for (int i = 0; i < wagons.size(); i++) {
		// if (wagons.get(i) != wagons.get(wagons.size() - 2)
		// && wagons.get(i).getSize() == Size.LARGE) {
		// for (int j = i + 1; j < wagons.size(); j++) {
		// if (wagons.get(j).getSize() == Size.MEDIUM) {
		// for (int k = j + 1; k < wagons.size(); k++) {
		// if (wagons.get(k).getSize() == Size.SMALL) {
		// train.setEastBound(true);
		// }
		// }
		// }
		// }
		// }
		// }

		/**
		 * first Wagon size + 1 equ. or higher than number of wagons
		 */
		/*
		 * if (train.getWagons().get(0).getSize().ordinal() + 1 + 1 > train
		 * .getMaxWagons()) { train.setEastBound(true); }
		 */

		/**
		 * Ein Wagon ist Medium und hat weniger als drei Räder und danach kommt
		 * ein Wagon mit Shape Circle und mehr als drei Rädern Weniger als 10
		 * Räder == Falsch Erster Wagon und Letzter gleiche Shape == Falsch
		 */
		// int wheelCount = 0;
		// for (int i = 0; i < wagons.size(); i++) {
		// wheelCount += wagons.get(i).getWheelNumber();
		// if (wagons.get(i).getSize() == Size.MEDIUM
		// && wagons.get(i).getWheelNumber() < 3) {
		// for (int j = i + 1; j < wagons.size(); j++) {
		// if (wagons.get(j).getCarShape() == CarShape.CIRCLE
		// && wagons.get(j).getWheelNumber() > 3) {
		// train.setEastBound(true);
		// }
		// }
		// }
		//
		// }
		// if (wheelCount < 10) {
		// train.setEastBound(false);
		// }
		// if (wagons.get(0).getCarShape() == wagons.get(wagons.size() - 1)
		// .getCarShape()) {
		// train.setEastBound(false);
		// }

		/**
		 * 5 Wagons und mind. 3 Dreieck
		 */
		// if (train.getMaxWagons() == 5) {
		// int triangleCount = 0;
		//
		// for (Wagon aWagon : wagons) {
		// if (aWagon.getCarShape() == CarShape.TRIANGLE) {
		// triangleCount++;
		// }
		// }
		//
		// if (triangleCount > 2) {
		// train.setEastBound(true);
		// }
		// }

		/**
		 * 2 Wagons und erster größer als zweiter
		 */
		if (wagons.get(0).getSize().ordinal() < wagons.get(1).getSize()
				.ordinal()) {
			train.setEastBound(true);
		}

	}
}
