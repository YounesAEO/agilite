package org.example.agilite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EquipeTest {
    private Equipe realMadrid;
    private String joueur;
    public EquipeTest(){}

    @BeforeEach
    public void setUp() // throws java.lang.Exception {
        realMadrid = new Equipe("Real Madrid");
        joueur = "Benzema";
    }

    @AfterEach
    public void tearDown() // throws java.lang.Exception {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testAjouterJoueur() {
        setUp();
        realMadrid.ajouterJoueur(joueur);
        assertTrue(realMadrid.getListeJoueurs().contains(joueur));
    }

    @Test
    public void testEnleverJoueur() {
        setUp();
        assertEquals(realMadrid.enleverJoueur(joueur), "l'équipe ne contient pas de joueurs");
        realMadrid.ajouterJoueur(joueur);
        assertEquals(realMadrid.enleverJoueur("Ronaldo"), "joueur introuvable");
        assertEquals(realMadrid.enleverJoueur(joueur), "joueur supprimé");
    }
}
