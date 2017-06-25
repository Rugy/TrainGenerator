package de.rugy.trains;

public class Wagon {

	private Size size;

	public Wagon(Size size) {
		this.size = size;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public String toString() {
		return size.toString();
	}

}
