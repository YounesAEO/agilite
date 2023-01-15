package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.agilite.Equipe;
import org.example.agilite.Match;
import org.example.agilite.Partie;
import org.example.designPatterns.Observer;

import java.util.Date;

import static org.junit.Assert.*;

public class StepDefsUS01JouerUnMatch {
    private Equipe e1;
    private Equipe e2;
    private Match matchE1E2;
    private Partie partie;
    @Given("une équipe comprenant un nom {string}")
    public void creerEquipe(String equipe1){
        partie = new Partie("difficle", "ZamNo1", 2);
        e1 = new Equipe(equipe1);
    }
    @Given("une autre équipe comprenant un nom {string}")
    public void creerDeuxiemeEquipe(String equipe2){
        e2 = new Equipe(equipe2);
    }

    @When("le match termine avec {int} supérieur à {int}")
    public void terminerMatchGagnant(int buts1, int buts2){
        matchE1E2 = new Match(e1, e2, new Date());
       assertTrue(buts1>buts2);
       matchE1E2.setScore(e1,buts1);
       matchE1E2.setScore(e2,buts2);
    }

    @Then("{string} gagne")
    public void trouverEquipeGagnante(String equipe){
        assertEquals(matchE1E2.getEquipeGagnante().getNom(), equipe);
    }

    @Then("nombre de victoires de l'équipe gagnante s'incrémente")
    public void incrementerNombreDeVictoiresEquipeGagnante(){
        int nbVictoiresAncien = matchE1E2.getEquipeGagnante().getNombreDeVictoires();
        partie.suivreMatch(matchE1E2);
        matchE1E2.terminerUnMatch();
        assertEquals(nbVictoiresAncien+1, matchE1E2.getEquipeGagnante().getNombreDeVictoires());
    }

    @Then("nombre de matchs des deux équipes s'incrémente")
    public void incrementerNombreDeMatchsDeuxEquipes(){
        int nbMatchsE1Ancien = e1.getNombreDeMatchs();
        int nbMatchsE2Ancien = e2.getNombreDeMatchs();
        partie.suivreMatch(matchE1E2);
        matchE1E2.terminerUnMatch();
        assertEquals(nbMatchsE1Ancien+1, e1.getNombreDeMatchs());
        assertEquals(nbMatchsE2Ancien+1, e2.getNombreDeMatchs());

    }

    @When("le match termine avec {int} inférieur à {int}")
    public void terminerMatchPerdant(int buts1, int buts2){
        matchE1E2 = new Match(e1, e2, new Date());
        assertTrue(buts1<buts2);
        matchE1E2.setScore(e1, buts1);
        matchE1E2.setScore(e2, buts2);
    }

    @Then("{string} perd")
    public void trouverEquipePerdante(String equipe){
        assertEquals(matchE1E2.getEquipePerdante().getNom(), equipe);
    }

    @When("le match termine avec {int} égale à {int}")
    public void terminerMatchNul(int buts1, int buts2){
        matchE1E2 = new Match(e1, e2, new Date());
        assertEquals(buts1,buts2);
        matchE1E2.setScore(e1, buts1);
        matchE1E2.setScore(e2, buts2);
    }

    @Then("les deux équipes égalisent")
    public void trouverMatchNul(){
        assertNull(matchE1E2.getEquipePerdante());
        assertNull(matchE1E2.getEquipeGagnante());
    }

    @Then("nombre de matchs nuls des deux équipes s'incrémente")
    public void incrementerNombreMatchNuls(){
        int nbMatchsNulsE1Ancien = e1.getNombresDeMatchsNuls();
        int nbMatchsNulsE2Ancien = e2.getNombresDeMatchsNuls();
        partie.suivreMatch(matchE1E2);
        matchE1E2.terminerUnMatch();
        assertEquals(nbMatchsNulsE1Ancien+1, e1.getNombreDeMatchs());
        assertEquals(nbMatchsNulsE2Ancien+1, e2.getNombreDeMatchs());
    }

}
