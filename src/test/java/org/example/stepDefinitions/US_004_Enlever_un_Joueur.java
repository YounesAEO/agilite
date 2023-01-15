package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.agilite.Equipe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class US_004_Enlever_un_Joueur {
    private Equipe e1;
    private int nbJoueursAncien;
    private String joueurIntrouvable;

    @Given("une équipe ayant un nom {string}")
    public void creerEquipe(String equipe) {
        e1 = new Equipe(equipe);
    }

    @When("{string} est supprimé de {string}")
    public void supprimerJoueur(String joueur, String equipe) {
        assertEquals(e1.getNom(), equipe);
        e1.ajouterJoueur(joueur);
        nbJoueursAncien = e1.getListeJoueurs().size();
        e1.enleverJoueur(joueur);
    }

    @Then("la liste des joueurs de {string} se décrémente")
    public void decrementerListeJoueurs(String equipe) {
        assertEquals(e1.getNom(), equipe);
        assertEquals(nbJoueursAncien-1, e1.getListeJoueurs().size());
    }


    @Given("{string} n'appartient pas à {string}")
    public void verfierJoueurEquipe(String joueur, String equipe) {
        joueurIntrouvable = joueur;
    }


    @Then("le système envoie une erreur disant: {string}")
    public void envoyerMessageErreur(String msgErreur) {
        e1.ajouterJoueur("joueur1");
       assertEquals(e1.enleverJoueur(joueurIntrouvable), msgErreur);
       e1.enleverJoueur("joueur1");
    }

}
