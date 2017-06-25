package de.rugy.trains.model;

import de.rugy.trains.enums.Size;

public class Wagon {

	private int trainNumber;
	private int wagonNumber;
	private Size size;

	public Wagon(int trainNumber, int wagonNumber, Size size) {
		this.trainNumber = trainNumber;
		this.wagonNumber = wagonNumber;
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "car_" + trainNumber + wagonNumber;
	}

}
