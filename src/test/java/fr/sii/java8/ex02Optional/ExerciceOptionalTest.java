package fr.sii.java8.ex02Optional;

import org.junit.Test;

import static fr.sii.java8.ex02Optional.ExerciceOptional.*;
import static org.junit.Assert.*;

public class ExerciceOptionalTest {


    private Person HOMELESS = new Person("John le globe trotter", 30, null);

    private Person PIERRE = new Person("Pierre", 40, new House(4, new Garden(500)));

    @Test
    public void testGetNameLabel() {
        String expected = "le nom est : " + HOMELESS.getName();

        assertEquals(expected, getNameLabelImperative(HOMELESS));
        assertEquals(expected, getNameLabelFunctional(HOMELESS));

        String expected2 = "il n'y a persone !";
        assertEquals(expected2, getNameLabelImperative(null));
        assertEquals(expected2, getNameLabelFunctional(null));
    }

    @Test
    public void testGetHouseTax() {
        assertEquals(10, getHouseTaxImperative(HOMELESS));
        assertEquals(10, getHouseTaxFunctional(HOMELESS));

        assertEquals(300, getHouseTaxImperative(PIERRE));
        assertEquals(300, getHouseTaxFunctional(PIERRE));
    }

    @Test
    public void testStartCookingImperativeForHomeless() {
        PLAY_STATION = false;
        FOOT_IN_THE_GARDEN = false;

        startPlayingImperative(HOMELESS);

        assertTrue(PLAY_STATION);
        assertFalse(FOOT_IN_THE_GARDEN);
    }

    @Test
    public void testStartCookingImperativeForPierre() {
        PLAY_STATION = false;
        FOOT_IN_THE_GARDEN = false;

        startPlayingImperative(PIERRE);

        assertTrue(FOOT_IN_THE_GARDEN);
        assertFalse(PLAY_STATION);
    }

    @Test
    public void testStartCookingFunctionalForHomeless() {
        PLAY_STATION = false;
        FOOT_IN_THE_GARDEN = false;

        startPlayingFunctional(HOMELESS);

        assertTrue(PLAY_STATION);
        assertFalse(FOOT_IN_THE_GARDEN);
    }

    @Test
    public void testStartCookingFunctionalForPierre() {
        PLAY_STATION = false;
        FOOT_IN_THE_GARDEN = false;

        startPlayingFunctional(PIERRE);

        assertTrue(FOOT_IN_THE_GARDEN);
        assertFalse(PLAY_STATION);
    }

}
