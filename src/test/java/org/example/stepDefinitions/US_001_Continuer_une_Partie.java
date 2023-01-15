package org.example.stepDefinitions;

import org.example.agilite.Joueur;
import org.example.agilite.Partie;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class US_001_Continuer_une_Partie {
    Partie partieExpected;
    Joueur joueurExpected;
    String chargementExpected;
    static int num = 0;
    @Given("Un joueur et une partie sauvegardée {string}")
    public void un_joueur_et_une_partie_sauvegardée(String partie) {
        // Write code here that turns the phrase above into concrete actions
        num++;
        partieExpected = new Partie();
        partieExpected.setPartie(partie);
        joueurExpected = new Joueur();
        Assert.assertNotNull(this.partieExpected);
        Assert.assertNotNull(this.joueurExpected);
    }
    @Given("La partie sauvegardée contient sa difficulté {string} et sa dernière date de sauvegarde {string}")
    public void la_partie_sauvegardée_contient_sa_difficulté_et_sa_dernière_date_de_sauvegarde(String difficulte, String date) {
        // Write code here that turns the phrase above into concrete actions
        partieExpected.setDifficulte(difficulte);
        partieExpected.setDate_sauvegarde(date);
    }
    @Given("Le personnage {string} de la partie sauvegardée possède son niveau actuel {int}")
    public void le_personnage_de_la_partie_sauvegardée_possède_son_niveau_actuel(String pseudoJoueur, int niveau) {
        // Write code here that turns the phrase above into concrete actions
        joueurExpected.setPseudoJoueur(pseudoJoueur);
        joueurExpected.setNiveau(niveau);
        partieExpected.setJoueur(joueurExpected);
    }
    @When("Le joueur séléctionne une partie sauvegardée {string}")
    public void le_joueur_séléctionne_une_partie_sauvegardée(String partie) {
        // Write code here that turns the phrase above into concrete actions
        chargementExpected = partieExpected.ChargerPartie();
        Assert.assertNotNull(chargementExpected);
    }
    @Then("La partie savegardée sera chargée et retourne son message de chargement {string}")
    public void la_partie_savegardée_sera_chargée_et_retourne_son_message_de_chargement(String chargement) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(chargement, chargementExpected);
    }

}
