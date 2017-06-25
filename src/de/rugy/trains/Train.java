package de.rugy.trains;

import java.util.ArrayList;
import java.util.List;

public class Train {

	private List<Wagon> wagons = new ArrayList<>();

	public void addWagon(Wagon wagon) {
		wagons.add(wagon);
	}

	@Override
	public String toString() {
		return wagons.get(0).toString().toLowerCase();
	}

}
