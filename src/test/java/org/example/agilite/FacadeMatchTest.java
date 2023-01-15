package org.example.agilite;

import org.example.designPatterns.FacadeMatch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeMatchTest {

    private static FacadeMatch facadeMatch;
    private static Partie partie;

    @BeforeEach
    public void setUp() {
        FacadeMatchTest.facadeMatch = new FacadeMatch("RMA", "Barca");
        partie = new Partie("difficle", "ZamNo1", 2);
    }

    @Test
    public void testlancerMatch() {
        Date date =new Date();

        FacadeMatchTest.facadeMatch.lancerMatch(date);

        // tester que match n'est pas null
        assertNotNull(FacadeMatchTest.facadeMatch.getMatch());

        // tester que l'équipe RMA a perdu et barca a gagné
        assertTrue(facadeMatch.getMatch().getEquipePerdante().getNom().equals("RMA"));
        assertTrue(facadeMatch.getMatch().getEquipeGagnante().getNom().equals("Barca"));

    }

    @Test
    public void testterminerUnMatch() {
        Date date =new Date();

        FacadeMatchTest.facadeMatch.lancerMatch(date);
        partie.suivreMatch(FacadeMatchTest.facadeMatch.getMatch());

       FacadeMatchTest.facadeMatch.terminerMatch();

        // test après le lancement de la methode terminer match
       assertTrue(FacadeMatchTest.facadeMatch.getMatch().getMatchTermine());

    }

}
