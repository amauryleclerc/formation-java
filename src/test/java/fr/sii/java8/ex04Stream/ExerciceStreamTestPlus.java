package fr.sii.java8.ex04Stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class ExerciceStreamTestPlus extends ExerciceStreamTest {

    protected List<Person> getPersons4() {
        return Collections.emptyList();
    }

    @Test
    @Override
    public void testGetNombreDeLettresDuPlusVieuxMajeurImperative() {
        eq(Integer.class, 0, ExerciceStream.getNombreDeLettresDuPlusVieuxMajeureImperative(getPersons4()));
    }

    @Test
    @Override
    public void testGetPersonsByRoomCount() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getPersonsByRoomCountFunctional, //
                ExerciceStream::getPersonsByRoomCountImperative, //
                actual -> eq(Map.class,
                        justNames(map( //
                                0, set(JOHN), //
                                2, set(MARIE, CONSTANCE, PATRICK, JACQUES, MARTINE), //
                                3, set(DAVID))),
                        justNames(actual)));
    }

    @Test
    @Override
    public void testGetPersonCountByRoomCount() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::getPersonCountByRoomCountFunctional, //
                ExerciceStream::getPersonCountByRoomCountImperative, //
                actual -> eq(Map.class, map(0, 1L, 2, 5L, 3, 1L), actual));
    }

    @Test
    @Override
    public void testSumOfGardensSurfaceByRoomCount() {
        functionalAndImperativeTester(getPersons(), //
                ExerciceStream::sumOfGardensSurfaceByRoomCountFunction, //
                ExerciceStream::sumOfGardensSurfaceByRoomCountImperative, //
                actual -> eq(Map.class, map(0, 0L, 2, 5150L, 3, 150L), actual));
    }
}
