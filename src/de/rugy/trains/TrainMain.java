package de.rugy.trains;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import de.rugy.trains.enums.Size;
import de.rugy.trains.model.Train;
import de.rugy.trains.model.Wagon;

public class TrainMain {

	public static void main(String[] args) {
		List<Train> trains = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int maxWagons = (int) (Math.random() * 4 + 2);
			Train train = new Train(i + 1, maxWagons);
			fillTrain(train);
			trains.add(train);
		}

		// Filter for Eastbound
		for (Train aTrain : trains) {
			if (aTrain.getMaxWagons() > 2) {
				List<Wagon> wagons = aTrain.getWagons();

				if (wagons.get(0).getSize() == Size.LARGE) {
					aTrain.setEastBound(true);
				}
			}
		}

		// Sort EastFirst, then West
		Deque<Train> trainsSorted = new LinkedList<>();
		for (Train aTrain : trains) {
			if (aTrain.isEastBound()) {
				trainsSorted.addFirst(aTrain);
			} else {
				trainsSorted.addLast(aTrain);
			}
		}

		TrainWriter.writeToFile("Test", trainsSorted);
	}

	public static void fillTrain(Train train) {
		for (int i = 0; i < train.getMaxWagons(); i++) {
			int sizeType = (int) (Math.random() * 2);
			train.addWagon(new Wagon(train.getTrainNumber(), i + 1, Size
					.values()[sizeType]));
		}
	}

}
