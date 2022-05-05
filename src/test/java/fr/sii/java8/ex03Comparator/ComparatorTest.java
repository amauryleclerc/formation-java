package fr.sii.java8.ex03Comparator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.Comparator;
import java.util.List;

import static fr.sii.java8.utils.ExerciceAFaireException.exerciceAFaire;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

public class ComparatorTest extends BaseTest {

    final List<String> strings = unmodifiableList(
            asList("David Gilmour", "Roger Waters", "Syd Barrett", "Richard Wright", "David Waters", "Nick Mason"));

    @Test
    public void testCompare1() {
        Comparator<String> parNomPrenom = exerciceAFaire(
                "Ecrire le Comparator comparant par Nom ascendant puis Prenom ascendant");

        List<String> sortedNomPrenom = sorted(strings, parNomPrenom);

        System.out.println(sortedNomPrenom);

        assertEquals(
                asList("Syd Barrett", "David Gilmour", "Nick Mason", "David Waters", "Roger Waters", "Richard Wright"),
                sortedNomPrenom);
    }

    @Test
    public void testCompare2() {
        Comparator<String> parPrenomDescNom = exerciceAFaire(
                "Ecrire le Comparator comparant par Prenom descendant puis par Nom ascendant");

        List<String> sortedPrenomDescNom = sorted(strings, parPrenomDescNom);

        System.out.println(sortedPrenomDescNom);

        assertEquals(
                asList("Syd Barrett", "Roger Waters", "Richard Wright", "Nick Mason", "David Gilmour", "David Waters"),
                sortedPrenomDescNom);
    }

    @Test
    public void testCompareAvecNulls() {
        List<String> strings = asList( //
                "11. 	Don't Leave Me Now", //
                "5. 	Another Brick in the Wall, Part II", //
                "1. 	In the Flesh?", //
                "13. 	Goodbye Cruel World", "4. 	The Happiest Days of Our Lives", //
                null, //
                "12. 	Another Brick in the Wall, Part III", //
                "10. 	One of My Turns", //
                "6. 	Mother", //
                null, //
                "9. 	Young Lust", //
                "2. 	The Thin Ice", //
                "7. 	Goodbye Blue Sky", //
                null, //
                "8. 	Empty Spaces", //
                "3. 	Another Brick in the Wall, Part I" //
        );

        Comparator<String> trackComparator = exerciceAFaire(
                "Ecire le Comparator permettant de remettre les titres dans l'ordre avec les null à la fin");

        List<String> sortedTracks = sorted(strings, trackComparator);

        System.out.println(sortedTracks.stream().map(String::valueOf).collect(joining("\n")));

        assertEquals(asList( //
                "1. 	In the Flesh?", //
                "2. 	The Thin Ice", //
                "3. 	Another Brick in the Wall, Part I", //
                "4. 	The Happiest Days of Our Lives", //
                "5. 	Another Brick in the Wall, Part II", //
                "6. 	Mother", //
                "7. 	Goodbye Blue Sky", //
                "8. 	Empty Spaces", //
                "9. 	Young Lust", //
                "10. 	One of My Turns", //
                "11. 	Don't Leave Me Now", //
                "12. 	Another Brick in the Wall, Part III", //
                "13. 	Goodbye Cruel World", //
                null, //
                null, //
                null), sortedTracks);
    }
}
