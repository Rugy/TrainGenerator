package de.rugy.trains;

public class Wagon {

	private Size size;

	public Wagon(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return size.toString();
	}

}
