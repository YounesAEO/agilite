package org.example.stepDefinitions;

import org.example.agilite.Jeu;
import org.example.agilite.Partie;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class US_000_Nouvelle_Partie {
    Jeu jeu;
    Partie nouvellePartieExpected;
    ArrayList<Partie> expected = new ArrayList<Partie>();
    static int num = 0;

    @Given("Le lancement du jeu par le joueur pour creer une nouvelle partie")
    public void lancement_du_jeu() {
        // Write code here that turns the phrase above into concrete actions
        jeu = new Jeu();
    }
    @When("Le joueur saisi la difficulté {string} de la nouvelle partie et son surnom {string}")
    public void joueur_saisie_la_difficulte_et_son_surnom(String difficulte, String pseudoJoueur) {
        // Write code here that turns the phrase above into concrete actions
        num++;
        nouvellePartieExpected = new Partie(difficulte, pseudoJoueur, num);
        this.expected.add(nouvellePartieExpected);
        jeu.nouvellePartie(difficulte, pseudoJoueur);
        assertNotNull(nouvellePartieExpected);
        assertNotNull(expected);
    }
    @Then("La nouvelle partie {string} est créée")
    public void nouvelle_partie_est_créée(String nouvPartie) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(this.nouvellePartieExpected.toString().equals(nouvPartie));
        assertTrue(this.expected.size()==this.jeu.getParties().size());
        assertTrue(this.jeu.getParties().get(this.jeu.getParties().size()-1).equals(nouvPartie));
    }
}
