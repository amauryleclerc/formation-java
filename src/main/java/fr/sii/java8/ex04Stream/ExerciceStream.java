package fr.sii.java8.ex04Stream;

import static fr.sii.java8.utils.ExerciceAFaireException.exerciceAFaire;
import static fr.sii.java8.utils.Tuple.fromEntry;
import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.sii.java8.utils.Tuple;

public class ExerciceStream {

	// Personnes n'ayant pas de maison.
	static List<Person> homeless(List<Person> persons) {
		return persons.stream()
				.filter(p -> p.getHouse().isEmpty())
				.collect(Collectors.toList());
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
		return persons.stream() //
				.filter(p -> p.getAge() >= 30 && p.getAge() < 40) //
				.collect(toSet());
	}


    static int getNombreDeLettresDuPlusVieuxMajeureImperative(List<Person> persons) {
        Person plusVieux = null;
        for (Person p : persons) {
            if ((p.getAge() >= 18) && ((plusVieux == null) || (plusVieux.getAge() < p.getAge()))) {
                plusVieux = p;
            }
        }
        if(plusVieux == null){
            return 0;
        }

		return plusVieux.getName().length();
	}

	static Optional<Integer> getNombreDeLettresDuPlusVieuxMajeureFunctional(List<Person> persons) {
		return persons.stream() //
				.filter(p -> p.getAge() >= 18) //
				.max(Comparator.comparingInt(Person::getAge)) //
				.map(p -> p.getName().length());
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
		return persons.stream() //
				.collect(groupingBy(p -> p.getAge() / 10));
	}

	static Map<Boolean, Set<Person>> personWithOrWithoutGarden(List<Person> persons) {
		return persons.stream() //
				.collect(partitioningBy(p -> p.getHouse().flatMap(House::getGarden).isPresent(), toSet()));
	}

	static boolean checkAllDepartmentHaveAtLeast10SleepingPlaces(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(Person::getDepartment))
				.entrySet()
				.stream()
				.allMatch(kv -> kv.getValue().stream()
						.flatMap(p -> p.getHouse().stream())
						.flatMap(h -> h.getRooms().stream())
						.flatMap(r -> r.getBeds().stream())
						.mapToInt(Bed::getForPersonCount)
						.sum() >= 10);
	}

    static List<Person> personSortedByRoomCountThenBySleepingPlacesCount(List<Person> persons) {
		Comparator<Person> byRoomCount = comparingInt(p -> p.getHouse().map(h -> h.getRooms().size()).orElse(0));

		Comparator<Person> bySleepingPlaces = comparingInt(p -> p.getHouse()
				.map(h -> h.getRooms().stream()
						.flatMap(r -> r.getBeds().stream())
						.mapToInt(Bed::getForPersonCount)
						.sum())
				.orElse(0));

		Comparator<Person> personCmp = byRoomCount.thenComparing(bySleepingPlaces);

		return persons.stream()
				.sorted(personCmp)
				.collect(toList());
	}

	static int getSleepingPlacesCount(List<Person> persons) {
		return persons.stream()
				.flatMap(p -> p.getHouse().stream())
				.flatMap(h -> h.getRooms().stream())
				.flatMap(r -> r.getBeds().stream())
				.mapToInt(Bed::getForPersonCount)
				.sum();
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
		return persons.stream()
                .flatMap(p -> p.getHouse().stream())
                .flatMap(h -> h.getRooms().stream())
                .filter(r -> r.getWindowCount() > 0)
                .mapToLong(r -> r.getBeds().size())
                .sum();

	}


	static List<Person> getThreeOldestPersonsImperative(List<Person> persons) {
		ArrayList<Person> cloned = new ArrayList<>(persons);

		Comparator<Person> cmp = Comparator.comparingInt(Person::getAge).reversed();

		Collections.sort(cloned, cmp);

		int i = 0;
		List<Person> result = new ArrayList<>();
		for (Iterator<Person> it = cloned.iterator(); it.hasNext() && (i < 3); i++) {
			result.add(it.next());
		}

		return result;
	}

	static List<Person> getThreeOldestPersonsFunctional(List<Person> persons) {
		return persons.stream()
				.sorted(comparing(Person::getAge).reversed())
				.limit(3)
				.collect(toList());
	}

	static Set<Person> personHavingHouseWithWindowInAllRooms(List<Person> persons) {
		return persons.stream()
				.filter(p -> p.getHouse()
						.filter(h -> h.getRooms().stream()
								.allMatch(r -> r.getWindowCount() > 0))
						.isPresent())
				.collect(toSet());
	}

	static Map<Integer, List<Person>> getPersonsByRoomCountImperative(List<Person> persons) {
		Map<Integer, List<Person>> result = new HashMap<>();

        for (Person person : persons) {
            House house = person.getHouse().orElse(null);
            int roomCount = 0;
            if (house != null) {
                roomCount = house.getRooms().size();
            }
            List<Person> list = result.get(roomCount);

            if (list == null) {
                list = new ArrayList<>();
                result.put(roomCount, list);
            }
            list.add(person);
        }

		return result;
	}

	static Map<Integer, List<Person>> getPersonsByRoomCountFunctional(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(p -> p.getHouse()
						.map(h -> h.getRooms().size())
						.orElse(0)));
	}

	static Map<Integer, Long> getPersonCountByRoomCountImperative(List<Person> persons) {
		Map<Integer, Long> result = new HashMap<>();

		for (Person person : persons) {
			House house = person.getHouse().orElse(null);

            int roomCount = 0 ;
            if (house != null) {
                roomCount = house.getRooms().size();
            }
            Long prevCount = result.get(roomCount);

            if (prevCount == null) {
                result.put(roomCount, 1L);
            } else {
                result.put(roomCount, prevCount + 1);
            }
        }

		return result;
	}

	// Les personnes qui n'ont pas de maison sont considérées comme ayant 0
	// rooms.
	static Map<Integer, Long> getPersonCountByRoomCountFunctional(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(
						p -> p.getHouse() //
								.map(h -> h.getRooms().size()) //
								.orElse(0), //
						counting()));
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
		return persons.stream()
				.flatMap(p -> p.getHouse().stream())
				.flatMap(h -> h.getRooms().stream())
				.flatMap(r -> r.getBeds().stream())
				.collect(groupingBy(Bed::getForPersonCount, summarizingInt(Bed::getForPersonCount)));
	}

	static Map<Integer, Long> sumOfGardensSurfaceByRoomCountImperative(List<Person> persons) {
		Map<Integer, Long> result = new HashMap<>();

		for (Person person : persons) {
			House house = person.getHouse().orElse(null);

            int roomCount = 0;
            long surface=0;
            if (house != null) {
                roomCount = house.getRooms().size();
                Garden garden = house.getGarden().orElse(null);

                if (garden != null) {
                    surface = garden.getSurface();

                }
            }
            Long prevSurface = result.get(roomCount);

            if (prevSurface == null) {
                result.put(roomCount, surface);
            } else {
                result.put(roomCount, prevSurface + surface);
            }
        }

		return result;
	}

	// Les personnes qui n'ont pas de maison sont considérées comme ayant 0
	// rooms.
	static Map<Integer, Long> sumOfGardensSurfaceByRoomCountFunction(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(
						p -> p.getHouse() //
								.map(h -> h.getRooms().size()) //
								.orElse(0), //
						summingLong(p -> p.getHouse() //
								.flatMap(House::getGarden) //
								.map(Garden::getSurface) //
								.orElse(0))));
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
		return persons.stream()
				.collect(groupingBy(Person::getDepartment))
				.entrySet().stream()
				.map(kv -> fromEntry(kv)
						.mapB(ps -> ps.stream()
								.sorted(comparing(Person::getAge).reversed())
								.skip(1)
								.collect(toList())))
				.collect(toMap(Tuple::getA, Tuple::getB));
	}

	static Map<String, Integer> getSleepingPlacesCountByPersonName(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(Person::getName,
						summingInt(p -> p.getHouse().stream()
								.flatMap(h -> h.getRooms().stream())
								.flatMap(r -> r.getBeds().stream())
								.mapToInt(Bed::getForPersonCount)
								.sum())));
	}

	static List<Bed> bedsOfTheOldestPerson(List<Person> persons) {
		return persons.stream()
				.max(comparingInt(Person::getAge))
				.flatMap(Person::getHouse)
				.map(h -> h.getRooms().stream()
						.flatMap(r -> r.getBeds().stream())
						.collect(toList()))
				.orElseGet(Collections::emptyList);
	}

	static SortedMap<Integer, SortedMap<Integer, List<Person>>> personsByRoomCountDescThenByBedCountDesc(
			List<Person> persons) {
		Comparator<Integer> reverseInts = reverseOrder();

		return persons.stream()
				.collect(groupingBy(
						p -> p.getHouse()
								.map(h -> h.getRooms().size())
								.orElse(0),
						() -> new TreeMap<>(reverseInts),
						groupingBy(
								p -> p.getHouse()
										.map(h -> h.getRooms().stream()
												.mapToInt(r -> r.getBeds().size())
												.sum())
										.orElse(0),
								() -> new TreeMap<>(reverseInts),
								toList())));
	}

	static String listingPersonsByRoomCountDescThenByBedCountDesc(List<Person> persons) {

		SortedMap<Integer, SortedMap<Integer, List<Person>>> groupedPersons = personsByRoomCountDescThenByBedCountDesc(
				persons);

		return groupedPersons.entrySet().stream()
				.flatMap(kv1 -> concat(Stream.of("- " + kv1.getKey() + " rooms"),
						kv1.getValue().entrySet().stream() //
								.flatMap(kv2 -> concat(Stream.of("  - " + kv2.getKey() + " beds"),
										kv2.getValue().stream()
												.map(p -> "    - " + p.getName() + " (" + p.getAge() + " ans)")))))
				.collect(joining("\n"));
	}

	static Map<Integer, Set<Person>> getPersonsByDeptOf5SleepingPlacesMinimum(List<Person> persons) {
		return persons.stream()
				.collect(groupingBy(Person::getDepartment, toSet()))
				.entrySet().stream()
				.filter(kv -> kv.getValue().stream()
						.mapToInt(p -> p.getHouse()
								.map(h -> h.getRooms().stream()
										.flatMap(r -> r.getBeds().stream())
										.mapToInt(Bed::getForPersonCount)
										.sum())
								.orElse(0))
						.sum() >= 5)
				.collect(toMap(Entry::getKey, Entry::getValue));
	}
}
