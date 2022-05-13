package fr.sii.java8.ex02Optional;

import java.util.Optional;

public record House(int rountCount, Garden garden) {

	public Optional<Garden> getGardenOpt() {
		return Optional.ofNullable(garden);
	}

	public int getRoomCount() {
		return rountCount;
	}

	public Garden getGarden() {
		return garden;
	}
}
