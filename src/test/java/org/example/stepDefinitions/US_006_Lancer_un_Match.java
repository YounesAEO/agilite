package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.agilite.Joueur;
import org.example.designPatterns.FacadeMatch;
import org.junit.Assert;

import java.util.Date;

public class US_006_Lancer_un_Match {

    private FacadeMatch facadeMatch;
    private Joueur joueur;

    @Given("Le lancement d'un match de football entre équipe du joueur {string} et équipe adverse {string}")
    public void leLancementDUnMatchDeFootballEntreEquipeDuJoueurEquipeEtEquipeAdverseEquipeAdverse(String equipeJoueur, String equipeAdverse) {
        facadeMatch = new FacadeMatch(equipeJoueur, equipeAdverse);
        Date date = new Date();

        // match lancé
        facadeMatch.lancerMatch(date);
        Assert.assertNotNull(facadeMatch.getMatch());
    }

    @When("Le joueur {string} choisi une équipe {string}")
    public void leJoueurPseudoJoueurChoisiUneEquipe(String pseudoJoueur, String equipeChoisie) {
        joueur = new Joueur(pseudoJoueur);

        String actual = joueur.choisirEquipe(equipeChoisie);

        // test que le joueur a choisi son équipe
        Assert.assertEquals(actual, equipeChoisie);
    }

    @Then("Le joueur joue contre une autre équipe adverse {string}")
    public void leJoueurJoueContreUneAutreEquipeAdverse(String equipeAdverse) {

        // test qu'il y a bien une équipe adverse
        Assert.assertEquals(facadeMatch.getEquipeAdverse().getNom(), equipeAdverse);

    }
}
