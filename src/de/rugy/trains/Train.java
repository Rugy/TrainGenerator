package de.rugy.trains;

import java.util.ArrayList;
import java.util.List;

public class Train {

	private int trainNumber;
	private List<Wagon> wagons = new ArrayList<>();
	private int maxWagons;
	private boolean eastBound;

	public Train(int trainNumber, int maxWagons) {
		this.trainNumber = trainNumber;
		this.maxWagons = maxWagons;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void addWagon(Wagon wagon) {
		wagons.add(wagon);
	}

	public int getMaxWagons() {
		return maxWagons;
	}

	public List<Wagon> getWagons() {
		return wagons;
	}

	public boolean isEastBound() {
		return eastBound;
	}

	public void setEastBound(boolean eastBound) {
		this.eastBound = eastBound;
	}

	@Override
	public String toString() {
		StringBuilder train = new StringBuilder();

		if (eastBound) {
			train.append("% This Train is eastbound\n");
		} else {
			train.append("% This train is westbound\n");
		}

		train.append("% This Train has " + maxWagons + " Wagons\n");

		for (int i = 0; i < wagons.size(); i++) {
			train.append("Wagon " + i + " is "
					+ wagons.get(i).toString().toLowerCase() + "\n");
		}

		return train.toString();
	}
}
