package de.rugy.trains.model;

import de.rugy.trains.enums.CarShape;
import de.rugy.trains.enums.Size;

public class Wagon {

	private int trainNumber = 0;
	private int wagonNumber;
	private int wheelNumber;
	private Size size;
	private CarShape carShape;

	public Wagon(int wagonNumber, Size size, int wheelNumber, CarShape carShape) {
		this.wagonNumber = wagonNumber;
		this.size = size;
		this.wheelNumber = wheelNumber;
		this.carShape = carShape;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Size getSize() {
		return size;
	}

	public int getWheelNumber() {
		return wheelNumber;
	}

	public CarShape getCarShape() {
		return carShape;
	}

	@Override
	public String toString() {
		return "car_" + trainNumber + wagonNumber;
	}

}
