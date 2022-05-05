package fr.sii.java8.ex02Optional;

import java.util.Optional;

class House {
    private final int roomCount;

    private final Garden garden;

    public House(int rountCount, Garden garden) {
        this.roomCount = rountCount;
        this.garden = garden;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public Garden getGarden() {
        return garden;
    }

    public Optional<Garden> getGardenOpt() {
        return Optional.ofNullable(garden);
    }
}
