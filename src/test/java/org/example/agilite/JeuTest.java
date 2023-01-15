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
        List<String> actual = Arrays.asList("partie1", "partie2", "partie3");
        List<String> expected = new ArrayList<String>();

        JeuTest.jeu.nouvellePartie("facile", "TheBest");
        JeuTest.jeu.nouvellePartie("normale", "Killer999");
        JeuTest.jeu.nouvellePartie("difficile", "ZamNo1");

        String partie1 = JeuTest.jeu.getParties().get(0).toString();
        String partie2 = JeuTest.jeu.getParties().get(1).toString();
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

        JeuTest.jeu.nouvellePartie("facile", "TheBest");
        JeuTest.jeu.getParties().get(0).setDateSauvegarde("10/09/2022");
        String actual = JeuTest.jeu.chargerPartie(partie);
        assertEquals(actual, expected);

    }

}
