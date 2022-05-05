package fr.sii.java8.ex04Stream;

import java.util.*;
import java.util.Map.Entry;

import static fr.sii.java8.utils.ExerciceAFaireException.exerciceAFaire;

public class ExerciceStream {

    // Personnes n'ayant pas de maision.
    static List<Person> homeless(List<Person> persons) {
        return exerciceAFaire("Listez les personnes sans maison");
    }

    static Set<Person> personnesTrentenairesImperative(List<Person> persons) {
        Set<Person> result = new HashSet<>();

        for (Person person : persons) {
            if ((person.getAge() >= 30) && (person.getAge() < 40)) {
                result.add(person);
            }
        }

        return result;
    }

    static Set<Person> personnesTrentenairesFunctional(List<Person> persons) {
        return exerciceAFaire("Listez les personnes trentenaires");
    }

    static int getNombreDeLettresDuPlusVieuxMajeureImperative(List<Person> persons) {
        Person plusVieux = null;
        for (Person p : persons) {
            if ((p.getAge() >= 18) && ((plusVieux == null) || (plusVieux.getAge() < p.getAge()))) {
                plusVieux = p;
            }
        }

        return plusVieux.getName().length();
    }

    static Optional<Integer> getNombreDeLettresDuPlusVieuxMajeureFunctional(List<Person> persons) {
        return exerciceAFaire("Retournez le nombre de lettre du nom de la plus vieille personne majeure");
    }

    static Map<Integer, List<Person>> getPersonesByDecadeImperative(List<Person> persons) {
        Map<Integer, List<Person>> result = new HashMap<>();

        for (Person person : persons) {
            int decade = person.getAge() / 10;
            List<Person> l = result.get(decade);

            if (l == null) {
                l = new ArrayList<>();
                result.put(decade, l);
            }
            l.add(person);
        }

        return result;
    }

    static Map<Integer, List<Person>> getPersonesByDecadeFunctional(List<Person> persons) {
        return exerciceAFaire("Listez les personnes par décénnie");
    }

    static Map<Boolean, Set<Person>> personWithOrWithoutGarden(List<Person> persons) {
        return exerciceAFaire("Groupez les personnes ayant ou non un jardin");
    }

    static boolean checkAllDepartmentHaveAtLeast10SleepingPlaces(List<Person> persons) {
        return exerciceAFaire("Vérifiez que tout les département on au moins 10 palces de couchage");
    }

    static List<Person> personSortedByRoomCountThenBySleepingPlacesCount(List<Person> persons) {
        Comparator<Person> personCmp = exerciceAFaire("Trouvez le bon Comparator");

        return exerciceAFaire("Triez les personnes selon le nombre de pièces puis nombre de places de couchage");

    }

    static int getSleepingPlacesCount(List<Person> persons) {
        return exerciceAFaire("Comptez le nombre de places de couchage");
    }

    static long getAllPhysicalBedCountInRoomWithWindowsImperative(List<Person> persons) {
        long result = 0;

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);

            if (house != null) {
                for (Room room : house.getRooms()) {
                    if (room.getWindowCount() > 0) {
                        result += room.getBeds().size();
                    }
                }
            }
        }

        return result;
    }

    static long getAllPhysicalBedCountInRoomWithWindowsFunctional(List<Person> persons) {
        return exerciceAFaire("Comptez le nombre de lit qui sont dans des pièces fenêtrées");
    }

    static List<Person> getThreeOldestPersonsImperative(List<Person> persons) {
        ArrayList<Person> cloned = new ArrayList<>(persons);

        Comparator<Person> cmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        Collections.sort(cloned, cmp);

        int i = 0;
        List<Person> result = new ArrayList<>();
        for (Iterator<Person> it = cloned.iterator(); it.hasNext() && (i < 3); i++) {
            result.add(it.next());
        }

        return result;
    }

    static List<Person> getThreeOldestPersonsFunctional(List<Person> persons) {
        return exerciceAFaire("Listez les 3 plus vieilles personnes");
    }

    static Set<Person> personHavingHouseWithWindowInAllRooms(List<Person> persons) {
        return exerciceAFaire("Listez les personnes ayant des fenêtres dans toutes les pièces");
    }

    static Map<Integer, List<Person>> getPersonsByRoomCountImperative(List<Person> persons) {
        Map<Integer, List<Person>> result = new HashMap<>();

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);

            if (house != null) {
                int roomCount = house.getRooms().size();

                List<Person> list = result.get(roomCount);

                if (list == null) {
                    list = new ArrayList<>();
                    result.put(roomCount, list);
                }
                list.add(person);
            }
        }

        return result;
    }

    static Map<Integer, List<Person>> getPersonsByRoomCountFunctional(List<Person> persons) {
        return exerciceAFaire("Groupez les personnes par nombre de pièces. "
                + "Les personnes qui n'ont pas de maison sont considérées comme ayant 0 pièce");
    }

    static Map<Integer, Long> getPersonCountByRoomCountImperative(List<Person> persons) {
        Map<Integer, Long> result = new HashMap<>();

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);

            if (house != null) {
                int roomCount = house.getRooms().size();

                Long prevCount = result.get(roomCount);

                if (prevCount == null) {
                    result.put(roomCount, 1L);
                } else {
                    result.put(roomCount, prevCount + 1);
                }
            }
        }

        return result;
    }

    // Les personnes qui n'ont pas de maison sont considérées comme ayant 0
    // rooms.
    static Map<Integer, Long> getPersonCountByRoomCountFunctional(List<Person> persons) {
        return exerciceAFaire("Comptez les personnes en fonction du nombre de pièces de leur maison.");
    }

    static Map<Integer, IntSummaryStatistics> getPhysicalBedStatisticsBySleepingPlacesImperative(List<Person> persons) {
        Map<Integer, IntSummaryStatistics> result = new HashMap<>();

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);

            if (house != null) {
                for (Room room : house.getRooms()) {
                    for (Bed bed : room.getBeds()) {
                        int forPersonCount = bed.getForPersonCount();
                        IntSummaryStatistics iss = result.get(forPersonCount);

                        if (iss == null) {
                            iss = new IntSummaryStatistics();
                            result.put(forPersonCount, iss);
                        }
                        iss.accept(forPersonCount);
                    }
                }
            }
        }

        return result;
    }

    static Map<Integer, IntSummaryStatistics> getPhysicalBedStatisticsBySleepingPlacesFunctional(List<Person> persons) {
        return exerciceAFaire(
                "Calculez les stats sur les lits pour chaque nombre de places de couchage dans la maison");
    }

    static Map<Integer, Long> sumOfGardensSurfaceByRoomCountImperative(List<Person> persons) {
        Map<Integer, Long> result = new HashMap<>();

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);

            if (house != null) {
                int roomCount = house.getRooms().size();
                Garden garden = house.getGarden().orElse(null);

                if (garden != null) {
                    long surface = garden.getSurface();
                    Long prevSurface = result.get(roomCount);

                    if (prevSurface == null) {
                        result.put(roomCount, surface);
                    } else {
                        result.put(roomCount, prevSurface + surface);
                    }
                }
            }
        }

        return result;
    }

    // Les personnes qui n'ont pas de maison sont considérées comme ayant 0
    // rooms.
    static Map<Integer, Long> sumOfGardensSurfaceByRoomCountFunction(List<Person> persons) {
        return exerciceAFaire("Calculez la somme de surface de jardin par nombre de pièces dans la maison");
    }

    // liste triée des plus vieux par département. Cette liste ne doit **PAS**
    // contenir le plus vieux.
    static Map<Integer, List<Person>> getOldestPersonsByDeptUnlessTheOldestImperative(List<Person> persons) {
        Map<Integer, List<Person>> result = new HashMap<>();

        for (Person person : persons) {
            int dpt = person.getDepartment();

            List<Person> list = result.get(dpt);

            if (list == null) {
                list = new ArrayList<>();
                result.put(dpt, list);
            }
            list.add(person);
        }

        Comparator<Person> cmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(), o2.getAge());
            }
        };

        Map<Integer, List<Person>> resultWitoutOldest = new HashMap<>();

        for (Entry<Integer, List<Person>> kv : result.entrySet()) {
            List<Person> oldestPersons = kv.getValue();
            Collections.sort(oldestPersons, cmp);

            resultWitoutOldest.put(kv.getKey(), oldestPersons.subList(1, oldestPersons.size()));
        }

        return resultWitoutOldest;
    }

    static Map<Integer, List<Person>> getOldestPersonsByDeptUnlessTheOldestFunctional(List<Person> persons) {
        return exerciceAFaire(
                "Triez les personnes les plus vieilles personnes par département (en excluant la plus vieille du département)");
    }

    static Map<String, Integer> getSleepingPlacesCountByPersonName(List<Person> persons) {
        return exerciceAFaire("Comptez le nombre de places de couchage pour chaque nom de personne");
    }

    static List<Bed> bedsOfTheOldestPerson(List<Person> persons) {
        return exerciceAFaire("Listez les lits de la plus vieille personne");
    }

    static SortedMap<Integer, SortedMap<Integer, List<Person>>> personsByRoomCountDescThenByBedCountDesc(
            List<Person> persons) {
        return exerciceAFaire(
                "Groupez les personnes par nombre de pièce descendant puis par nombre de lits descendant");
    }

    static String listingPersonsByRoomCountDescThenByBedCountDesc(List<Person> persons) {

        SortedMap<Integer, SortedMap<Integer, List<Person>>> groupedPersons = personsByRoomCountDescThenByBedCountDesc(
                persons);

        return exerciceAFaire("Ecrire une liste indentée de du groupement précédent");
    }

    static Map<Integer, Set<Person>> getPersonsByDeptOf5SleepingPlacesMinimum(List<Person> persons) {
        return exerciceAFaire("Listez par département les personnes ayant au moins 5 places de couchage");
    }
}
