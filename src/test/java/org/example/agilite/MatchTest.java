package org.example.agilite;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchTest {
    private Equipe maroc;
    private Equipe portugal;
    private Match quart;



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
        maroc = new Equipe();
        portugal = new Equipe();
        quart = new Match(maroc, portugal);
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
    public void testJouerUnMatch()
    {
        setUp();
        quart.jouerUnMatch(1);
        assertEquals(1, maroc.getNombreDeMatchs());
        assertEquals(1, maroc.getNombreDeVictoires());
        assertEquals(0, maroc.getNombresDeMatchsNuls());
        assertEquals(1, portugal.getNombreDeMatchs());
        assertEquals(0, portugal.getNombreDeVictoires());
        assertEquals(0, portugal.getNombresDeMatchsNuls());
    }
}
