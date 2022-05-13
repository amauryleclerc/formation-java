package fr.sii.java8.ex02Optional;

import java.util.Optional;

record Person(String name, int age, House house) {


	public Optional<House> getHouseOpt() {
		return Optional.ofNullable(house);
	}


}
