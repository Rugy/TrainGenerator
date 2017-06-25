package de.rugy.trains;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TrainMain {

	public static void main(String[] args) {
		List<Train> trains = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int maxWagons = (int) (Math.random() * 4 + 2);
			Train train = new Train(maxWagons);
			fillTrain(train);
			trains.add(train);
		}

		for (Train aTrain : trains) {
			if (aTrain.getMaxWagons() > 3) {
				List<Wagon> wagons = aTrain.getWagons();

				if (wagons.get(wagons.size() - 1).getSize() == Size.Small) {
					aTrain.setEastBound(true);
				}
			}
		}

		Deque<Train> trainsSorted = new LinkedList<>();
		for (Train aTrain : trains) {
			if (aTrain.isEastBound()) {
				trainsSorted.addFirst(aTrain);
			} else {
				trainsSorted.addLast(aTrain);
			}
		}

		String[] trainDescr = new String[trainsSorted.size()];

		for (int i = 0; i < trainDescr.length; i++) {
			trainDescr[i] = trainsSorted.poll().toString();
		}

		TrainWriter.writeToFile("Test", trainDescr);
	}

	public static void fillTrain(Train train) {
		for (int i = 0; i < train.getMaxWagons(); i++) {
			int sizeType = (int) (Math.random() * 2);
			train.addWagon(new Wagon(Size.values()[sizeType]));
		}
	}
}
