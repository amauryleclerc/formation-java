package fr.sii.java8.ex04Stream;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

record House(Optional<Garden> garden, List<Room> rooms) {

    public static House house(Optional<Garden> gardenOpt, Room... rooms) {
        return new House(gardenOpt, asList(rooms));
    }


}
