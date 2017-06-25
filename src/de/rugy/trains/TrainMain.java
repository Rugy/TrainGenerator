package de.rugy.trains;

import java.util.ArrayList;
import java.util.List;

public class TrainMain {

	public static void main(String[] args) {
		List<String> texts = new ArrayList<>();
		texts.add("A");
		texts.add("B");

		Train trainA = new Train();
		trainA.addWagon(new Wagon(Size.Small));

		texts.add(trainA.toString());

		TrainWriter
				.writeToFile("Test", texts.toArray(new String[texts.size()]));
	}
}
