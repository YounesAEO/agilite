package org.example.agilite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JeuTest {
    private static Jeu jeu;

    @BeforeEach
    public void setUp() {

        JeuTest.jeu = new Jeu();
    }
    @Test
    public void testnouvellePartie() {
        List<String> actual = Arrays.asList("partie2", "partie3", "partie4");
        List<String> expected = new ArrayList<String>();


        JeuTest.jeu.nouvellePartie("facile", "TheBest", "RMA");
        String partie1 = JeuTest.jeu.getParties().get(0).toString();

        JeuTest.jeu.nouvellePartie("normale", "Killer999", "RMA");
        String partie2 = JeuTest.jeu.getParties().get(1).toString();

        JeuTest.jeu.nouvellePartie("difficile", "ZamNo1", "RMA");
        String partie3 = JeuTest.jeu.getParties().get(2).toString();

        expected.add(partie1);
        expected.add(partie2);
        expected.add(partie3);

        assertEquals(actual,expected);
    }

    @Test
    public void testchargerPartie() {
        int partie = 0;
        String expected = "Partie facile de TheBest du 10/09/2022 est chargée!";

        JeuTest.jeu.nouvellePartie("facile", "TheBest", "RMA");
        JeuTest.jeu.getParties().get(0).setDateSauvegarde("10/09/2022");
        String actual = JeuTest.jeu.chargerPartie(partie);
        assertEquals(actual, expected);

    }

}
