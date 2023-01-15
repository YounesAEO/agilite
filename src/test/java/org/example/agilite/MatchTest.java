package org.example.agilite;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class MatchTest {
    private Equipe maroc;
    private Equipe portugal;
    private Match quart;
    private Partie partie;



    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).



    /**
     * Constructeur de la classe-test MatchTest
     */
    public MatchTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        maroc = new Equipe("maroc");
        portugal = new Equipe("portugal");
        quart = new Match(maroc, portugal, new Date());
        quart.setScore(maroc, 1);
        quart.setScore(portugal,0);
        partie = new Partie("Difficle", "ZamNo1", 2);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testTerminerUnMatch()
    {
        setUp();
        partie.suivreMatch(quart);
        quart.terminerUnMatch();
        assertEquals(1, maroc.getNombreDeMatchs());
        assertEquals(1, maroc.getNombreDeVictoires());
        assertEquals(0, maroc.getNombresDeMatchsNuls());
        assertEquals(1, portugal.getNombreDeMatchs());
        assertEquals(0, portugal.getNombreDeVictoires());
        assertEquals(0, portugal.getNombresDeMatchsNuls());
    }

    @Test
    public void testGetEquipeGagnante()
    {
        setUp();
        assertEquals(quart.getEquipeGagnante().getNom(), maroc.getNom());
    }

    @Test
    public void testGetEquipePerdante()
    {
        setUp();
        assertEquals(quart.getEquipePerdante().getNom(), portugal.getNom());
    }

}
