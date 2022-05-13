package fr.sii.java8.ex04Stream;

import static java.util.Arrays.asList;

import java.util.List;

record Room(int windowCount, List<Bed> beds) {


	public static Room room(int windowCount, Bed... beds) {
		return new Room(windowCount, asList(beds));
	}


}
