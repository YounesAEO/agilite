package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.agilite.Equipe;
import org.example.agilite.Match;

import java.util.Date;

import static org.junit.Assert.*;

public class StepDefsUS02AjouterUnJoueur {
    private Equipe e1;
    private int nbJoueursAncien;
    @Given("une équipe comprenant le nom {string}")
    public void creerEquipe(String equipe1){
        e1 = new Equipe(equipe1);
    }

    @When("{string} est ajouté à {string}")
    public void ajouterJoueur(String joueur, String equipe) {
        assertEquals(e1.getNom(), equipe);
        nbJoueursAncien = e1.getListeJoueurs().size();
        e1.ajouterJoueur(joueur);
    }


    @Then("la liste des joueurs de {string} s'incrémente")
    public void incrementerListeJoueurs(String equipe) {
        assertEquals(e1.getNom(), equipe);
        assertEquals(nbJoueursAncien+1, e1.getListeJoueurs().size());
    }
}
