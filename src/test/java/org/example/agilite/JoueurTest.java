package org.example.agilite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class JoueurTest {

    private static Joueur joueur;
    @BeforeEach
    public void setUp() {

        JoueurTest.joueur = new Joueur();
    }

    @Test
    public void testcomparerNiveaux() {
        // test joueur quand il perd
        JoueurTest.joueur.setNiveau(74);
        String expected = "Joueur perd. Niveau: 74";
        String actual = JoueurTest.joueur.comparerNiveau(74);
        assertEquals(actual, expected);

        // test joueur quand il gagne
        JoueurTest.joueur.setNiveau(78);
        String expected2 = "Joueur gagne. Niveau: 79";
        String actual2 = JoueurTest.joueur.comparerNiveau(70);
        assertEquals(actual2, expected2);

    }
}
