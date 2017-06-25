package de.rugy.trains.model;

import de.rugy.trains.enums.Size;

public class Wagon {

	private int trainNumber = 0;
	private int wagonNumber;
	private Size size;

	public Wagon(int wagonNumber, Size size) {
		this.wagonNumber = wagonNumber;
		this.size = size;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "car_" + trainNumber + wagonNumber;
	}

}
