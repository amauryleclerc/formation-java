package fr.sii.java8.ex04Stream;

import static fr.sii.java8.utils.LangUtils.opt;

import java.util.Optional;

public record Person(String name, int age, int departement, Optional<House> houseOpt) {

	public static Person person(String name, int age, int department) {
		return new Person(name, age, department, Optional.empty());
	}

	public static Person person(String name, int age, int department, House house) {
		return new Person(name, age, department, opt(house));
	}


	public Optional<House> getHouse() {
		return houseOpt;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getDepartment() {
		return departement;
	}
}
