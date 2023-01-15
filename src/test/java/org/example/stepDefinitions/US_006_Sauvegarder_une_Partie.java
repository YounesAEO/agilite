package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.agilite.Equipe;
import org.example.agilite.Joueur;
import org.example.agilite.Partie;
import org.example.designPatterns.FacadeMatch;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class US_006_Sauvegarder_une_Partie {

    private Partie partie;
    private FacadeMatch facadeMatch;
    private Joueur joueur;

    @Given("Une partie")
    public void unePartie() {
        partie = new Partie("difficle", "ZamNo1", 2);
        // test de la partie pour qu'elle ne soit pas null
        Assert.assertNotNull(partie);
    }

    @And("Un match entre équipe joueur {string} et équipe adverse {string} avec la date {string}")
    public void unMatchEntreEquipeJoueurEtEquipeAdverseAvecLaDateDateSauvegarde(String equipeJoueur, String equipeAdverse, String date) {
        facadeMatch = new FacadeMatch(equipeJoueur, equipeAdverse);
        Date d = new Date(date);

        // test l'existance des equipes d'un match
        Assert.assertEquals(facadeMatch.getEquipeJoueur().getNom(), equipeJoueur);
        Assert.assertEquals(facadeMatch.getEquipeAdverse().getNom(), equipeAdverse);
        facadeMatch.lancerMatch(d);
    }
    @And("Un joueur {string}")
    public void unJoueurPseudojoueur(String pseudoJoueur) {
        joueur = new Joueur(pseudoJoueur);

        // test le pseudo du joueur
        Assert.assertEquals(joueur.getPseudoJoueur(), pseudoJoueur);

    }

    @When("Le joueur termine le match")
    public void leJoueurTermineLeMatch() {
        partie.suivreMatch(facadeMatch.getMatch());
        facadeMatch.terminerMatch();

        // test que le match est terminé
        Assert.assertTrue(facadeMatch.getMatch().getMatchTermine());
    }

    @Then("la partie est sauvegardée {string}")
    public void laPartieEstSauvegardée(String date) {
        Date d = new Date(date);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(d);

        // test que la partie a été sauvegarder
        Assert.assertEquals("Partie difficle de ZamNo1 du " + stringDate + " est sauvegardée!", partie.sauvegarderPartie(d));


    }


}
