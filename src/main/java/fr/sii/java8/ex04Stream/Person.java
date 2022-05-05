package fr.sii.java8.ex04Stream;

import static fr.sii.java8.utils.LangUtils.opt;

import java.util.Optional;

public final class Person {
	private final String name;
	private final int age;
	private final int department;
	private final Optional<House> house;

	public static Person person(String name, int age, int department) {
		return new Person(name, age, department, Optional.empty());
	}

	public static Person person(String name, int age, int department, House house) {
		return new Person(name, age, department, opt(house));
	}

	private Person(String name, int age, int departement, Optional<House> houseOpt) {
		this.name = name;
		this.age = age;
		this.department = departement;
		this.house = houseOpt;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getDepartment() {
		return department;
	}

	public Optional<House> getHouse() {
		return house;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + age;
		result = (prime * result) + ((house == null) ? 0 : house.hashCode());
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (age != other.age) {
			return false;
		}
		if (house == null) {
			if (other.house != null) {
				return false;
			}
		} else if (!house.equals(other.house)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Person[name=" + name + ", age=" + age + ", department=" + department + ", house=" + house + "]";
	}

}
