package org.example.stepDefinitions;

import org.example.agilite.Joueur;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_002_Comparer_les_Niveaux_des_Joueurs {
    Joueur joueurExppected;
    Joueur adversaireExpected;
    String actual;

    @Given("Le niveau {int} actuel du joueur {string} et celui de son adversaire {int}")
    public void le_niveau_actuel_du_joueur_et_celui_de_son_adversaire(int niveau, String pseudoJoueur, int niveauAdversaire) {
        // Write code here that turns the phrase above into concrete actions
        joueurExppected = new Joueur(pseudoJoueur);
        joueurExppected.setNiveau(niveau);
        adversaireExpected = new Joueur();
        adversaireExpected.setNiveau(niveauAdversaire);
        Assert.assertNotNull(joueurExppected.getNiveau());
        Assert.assertNotNull(adversaireExpected.getNiveau());
    }
    @And("Le niveau du joueur est inférieure ou égale à celui de son adversaire")
    public void le_niveau_du_joueur_est_inférieure_ou_égale_à_celui_de_son_adversaire() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(joueurExppected.getNiveau()<=adversaireExpected.getNiveau());
    }
    @When("Le joueur compare son niveau avec celui de son adversaire")
    public void le_joueur_compare_son_niveau_avec_celui_de_son_adversaire() {
        // Write code here that turns the phrase above into concrete actions
        actual = joueurExppected.comparerNiveau(adversaireExpected.getNiveau());
        Assert.assertNotNull(actual);
    }
    @Then("Le joueur perd {string} contre son adversaire et rien ne se passe")
    public void le_joueur_perd_contre_son_adversaire_et_rien_ne_se_passe(String resultat) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(actual, resultat);
    }

    @And("Le niveau du joueur est supérieure à celui de son adversaire")
    public void leNiveauNiveauDuJoueurEstSupérieureÀCeluiDeSonAdversaire() {
        Assert.assertTrue(joueurExppected.getNiveau()>adversaireExpected.getNiveau());
    }

    @Then("Le joueur gagne {string} contre son adversaire et son niveau augmente")
    public void leJoueurGagneResultatContreSonAdversaireEtSonNiveauAugmenteDe(String resultat) {
        Assert.assertEquals(actual, resultat);
    }
}
