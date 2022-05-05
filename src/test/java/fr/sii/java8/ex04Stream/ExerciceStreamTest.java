package fr.sii.java8.ex04Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static fr.sii.java8.ex04Stream.ExerciceStream.*;
import static java.util.stream.Collectors.joining;

public class ExerciceStreamTest extends BaseTest {

    @Test
    public void testGetPersonsByRoomCount() {
        functionalAndImperativeTester(getPersons2(), //
                ExerciceStream::getPersonsByRoomCountFunctional, //
                ExerciceStream::getPersonsByRoomCountImperative, //
                actual -> eq(Map.class,
                        justNames(map( //
                                2, set(MARIE, CONSTANCE, PATRICK, JACQUES, MARTINE), //
                                3, set(DAVID))), //
                        justNames(actual)));
    }

    @Test
    public void testGetPersonesByDecade() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getPersonesByDecadeFunctional, //
                ExerciceStream::getPersonesByDecadeImperative, //
                actual -> eq(Map.class,
                        justNames(map( //
                                2, set(MARIE), //
                                3, set(DAVID), //
                                5, set(JACQUES, JOHN), //
                                6, set(PATRICK, MARTINE), //
                                8, set(CONSTANCE))),
                        justNames(actual)));
    }

    @Test
    public void testGetThreeOldestPersons() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getThreeOldestPersonsFunctional, //
                ExerciceStream::getThreeOldestPersonsImperative, //
                actual -> eq(List.class, justNames(list( //
                        CONSTANCE, PATRICK, MARTINE)), justNames(actual)));
    }

    @Test
    public void testGetOldestPersonsByDeptUnlessTheOldestFunctional() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getOldestPersonsByDeptUnlessTheOldestFunctional, //
                ExerciceStream::getOldestPersonsByDeptUnlessTheOldestImperative, //
                actual -> eq(Map.class,
                        justNames(map( //
                                22, list(JACQUES, MARTINE), //
                                35, list(), //
                                44, list(MARIE, DAVID))),
                        justNames(actual)));
    }

    @Test
    public void testPlusVieuxMajeurFunc() {
        eq(Optional.class, Optional.of(CONSTANCE.getName().length()),
                getNombreDeLettresDuPlusVieuxMajeureFunctional(getPersons()));
    }

    @Test
    public void testPersonnesTrentenairesFunc() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::personnesTrentenairesFunctional, //
                ExerciceStream::personnesTrentenairesImperative, //
                actual -> eq(Set.class, set(DAVID), actual));
    }

    @Test
    public void testGetNombreDeLettresDuPlusVieuxMajeurImperative() {
        eq(Integer.class, 19, getNombreDeLettresDuPlusVieuxMajeureImperative(getPersons()));
    }

    @Test
    public void testNombreDeLettresDuPlusVieuxMajeurFunc() {
        eq(Optional.class, Optional.of(19), getNombreDeLettresDuPlusVieuxMajeureFunctional(getPersons()));
    }

    @Test
    public void testGetPersonCountByRoomCount() {
        functionalAndImperativeTester(getPersons2(), //
                ExerciceStream::getPersonCountByRoomCountFunctional, //
                ExerciceStream::getPersonCountByRoomCountImperative, //
                actual -> eq(Map.class, map(2, 5L, 3, 1L), actual));
    }

    @Test
    public void testSumOfGardensSurfaceByRoomCount() {
        functionalAndImperativeTester(getPersons2(), //
                ExerciceStream::sumOfGardensSurfaceByRoomCountFunction, //
                ExerciceStream::sumOfGardensSurfaceByRoomCountImperative, //
                actual -> eq(Map.class, map(2, 5150L, 3, 150L), actual));
    }

    @Test
    public void testGetPhysicalBedStatisticsBySleepingPlaces() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getPhysicalBedStatisticsBySleepingPlacesFunctional, //
                ExerciceStream::getPhysicalBedStatisticsBySleepingPlacesImperative, //
                actual -> eq(String.class,
                        "1=IntSummaryStatistics{count=6, sum=6, min=1, average=1,000000, max=1}\n" + //
                                "2=IntSummaryStatistics{count=13, sum=26, min=2, average=2,000000, max=2}", //
                        actual.entrySet().stream().map(String::valueOf).sorted().collect(joining("\n"))));
    }

    @Test
    public void testGetAllPhysicalBedCountInRoomWithWindows() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getAllPhysicalBedCountInRoomWithWindowsFunctional, //
                ExerciceStream::getAllPhysicalBedCountInRoomWithWindowsImperative, //
                actual -> eq(Long.class, 16L, actual));
    }

    @Test
    public void testGetSleepingPlacesCount() {
        eq(Integer.class, 32, getSleepingPlacesCount(getPersons()));
    }

    @Test
    public void testPersonWithOrWithoutGarden() {
        Map<Boolean, Set<String>> actualNames = justNames(personWithOrWithoutGarden(getPersons()));

        eq(Map.class,
                justNames(map( //
                        false, set(JOHN, JACQUES, PATRICK), //
                        true, set(MARIE, DAVID, MARTINE, CONSTANCE))),
                actualNames);
    }

    @Test
    public void testPersonHavingHouseWithWindowInAllRooms() {
        eq(Set.class, set(MARTINE, PATRICK, CONSTANCE), personHavingHouseWithWindowInAllRooms(getPersons()));
    }

    @Test
    public void testPersonSortedByRoomCountThenBySleepingPlacesCount() {
        eq(List.class, list(JOHN, JACQUES, MARTINE, MARIE, PATRICK, CONSTANCE, DAVID),
                personSortedByRoomCountThenBySleepingPlacesCount(getPersons()));
    }

    @Test
    public void testBedsOfTheOldestPerson() {
        eq(List.class, list(CONSTANCE_BEDS), bedsOfTheOldestPerson(getPersons()));
    }

    @Test
    public void testListingPersonsByRoomCountDescThenByBedCountDesc() {
        eq(String.class, //
                "- 3 rooms\n" + //
                        "  - 5 beds\n" + //
                        "    - David (38 ans)\n" + //
                        "- 2 rooms\n" + //
                        "  - 5 beds\n" + //
                        "    - Constance-Cunégonde (87 ans)\n" + //
                        "  - 3 beds\n" + //
                        "    - Marie (25 ans)\n" + //
                        "  - 2 beds\n" + //
                        "    - Jacques (50 ans)\n" + //
                        "    - Martine (62 ans)\n" + //
                        "    - Patrick (65 ans)\n" + //
                        "- 0 rooms\n" + //
                        "  - 0 beds\n" + //
                        "    - JOHN globe-trotter (53 ans)",
                listingPersonsByRoomCountDescThenByBedCountDesc(getPersons()));
    }

    @Test
    public void testCheckAllDepartmentHaveAtLeast10SleepingPlaces() {
        eq(Boolean.class, true, checkAllDepartmentHaveAtLeast10SleepingPlaces(getPersons()));
    }

    @Test
    public void testHomeless() {
        eq(List.class, list(JOHN), homeless(getPersons()));
    }

    @Test
    public void testGetSleepingPlacesCountByPersonName() {
        eq(Map.class,
                map( //
                        MARIE.getName(), 4, //
                        CONSTANCE.getName(), 10, //
                        PATRICK.getName(), 4, //
                        JACQUES.getName(), 3, //
                        MARTINE.getName(), 3, //
                        DAVID.getName(), 8, //
                        JOHN.getName(), 0),
                getSleepingPlacesCountByPersonName(getPersons()));
    }

    @Test
    public void testGetPersonsByDeptOf5SleepingPlacesMinimum() {
        Map<Integer, Set<String>> actualNames = justNames(getPersonsByDeptOf5SleepingPlacesMinimum(getPersons()));

        eq(Map.class,
                justNames(map( //
                        35, set(CONSTANCE), //
                        22, set(PATRICK, JACQUES, MARTINE), //
                        44, set(MARIE, DAVID, JOHN))),
                actualNames);
    }

}
