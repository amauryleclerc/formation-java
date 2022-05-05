package fr.sii.java8.ex04Stream;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

final class House {
	private final Optional<Garden> garden;

	private final List<Room> rooms;

	public House(Optional<Garden> garden, List<Room> rooms) {
		this.rooms = rooms;
		this.garden = garden;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Optional<Garden> getGarden() {
		return garden;
	}

	public static House house(Optional<Garden> gardenOpt, Room... rooms) {
		return new House(gardenOpt, asList(rooms));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((garden == null) ? 0 : garden.hashCode());
		result = (prime * result) + ((rooms == null) ? 0 : rooms.hashCode());
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
		House other = (House) obj;
		if (garden == null) {
			if (other.garden != null) {
				return false;
			}
		} else if (!garden.equals(other.garden)) {
			return false;
		}
		if (rooms == null) {
			if (other.rooms != null) {
				return false;
			}
		} else if (!rooms.equals(other.rooms)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "House[garden=" + garden + ", rooms=" + rooms + "]";
	}

}
