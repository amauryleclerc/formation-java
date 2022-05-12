package fr.sii.java8.ex02Optional;

import java.util.Optional;

import static java.util.Optional.ofNullable;

class ExerciceOptional {

    public static boolean FOOT_IN_THE_GARDEN;
    public static boolean PLAY_STATION;

    static String getNameLabelImperative(Person person) {
        String result;

        if (person != null) {
            result = "le nom est : " + person.getName();
        } else {
            result = "il n'y a persone !";
        }

        return result;
    }

    static String getNameLabelFunctional(Person person) {
        return ofNullable(person) //
                .map(p -> "le nom est : " + p.getName()) //
                .orElse("il n'y a persone !");
    }

    static int getHouseTaxImperative(Person person) {
        int taxe = 10;

        if (person != null) {
            House house = person.getHouse();

            if (house != null) {
                int roomCount = house.getRoomCount();

                if (roomCount > 3) {
                    taxe = 100 + (50 * roomCount);
                }
            }
        }

        return taxe;
    }

    static int getHouseTaxFunctional(Person person) {
        return ofNullable(person) //
                .flatMap(Person::getHouseOpt) //
                .filter(h -> h.getRoomCount() > 3) //
                .map(h -> 100 + (50 * h.getRoomCount()))//
                .orElse(10);
    }

    static void startPlayingImperative(Person person) {

        if (person != null) {
            House house = person.getHouse();

            if (house != null) {
                Garden garden = house.getGarden();

                if (garden != null) {
                    startPlayingInTheGarden(garden);
                    return;
                }
            }
        }
        startPlayStation();
    }

    static void startPlayingFunctional(Person person) {
        ofNullable(person)
                .flatMap(Person::getHouseOpt)
                .flatMap(House::getGardenOpt)
                .ifPresentOrElse(
                        ExerciceOptional::startPlayingInTheGarden,
                        ExerciceOptional::startPlayStation);
    }

    private static void startPlayStation() {
        PLAY_STATION = true;
    }

    private static void startPlayingInTheGarden(Garden g) {
        FOOT_IN_THE_GARDEN = true;
    }

}
