package de.rugy.trains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TrainWriter {

	public static void writeToFile(String fileName, String[] text) {
		Path target = Paths.get(System.getProperty("user.dir") + "\\"
				+ fileName + ".pl");

		try {
			if (Files.exists(target)) {
				Files.delete(target);
			}
			target = Files.createFile(target);
			for (int i = 0; i < text.length; i++) {
				Files.write(target, (text[i] + "\n").getBytes(),
						StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
