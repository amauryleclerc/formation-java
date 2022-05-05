package fr.sii.java8.ex02Optional;

import java.util.Optional;

class Person {
	private final String name;
	private final int age;
	private final House house;

	public Person(String name, int age, House house) {
		this.name = name;
		this.age = age;
		this.house = house;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public Optional<House> getHouseOpt() {
		return Optional.ofNullable(house);
	}

	public House getHouse() {
		return house;
	}
}
