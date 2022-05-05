package fr.sii.java8.ex02Optional;

import static fr.sii.java8.utils.ExerciceAFaireException.exerciceAFaire;

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
        return exerciceAFaire("Ecrire la version fonctionnelle de la méthode impérative correspondante");
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
        return exerciceAFaire("Ecrire la version fonctionnelle de la méthode impérative correspondante");
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
        exerciceAFaire("Ecrire la version fonctionnelle de la méthode impérative correspondante");
    }

    private static void startPlayStation() {
        PLAY_STATION = true;
    }

    private static void startPlayingInTheGarden(Garden g) {
        FOOT_IN_THE_GARDEN = true;
    }

}
