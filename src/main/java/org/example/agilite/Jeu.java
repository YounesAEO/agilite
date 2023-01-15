package org.example.agilite;

import org.example.designPatterns.FacadeMatch;

import java.util.ArrayList;
import java.util.Date;
/**
 * @author Katia.Nseir - Maria.Bou-Jawde
 * **/
public class Jeu {
    ArrayList<Partie> parties = new ArrayList<>();;
    static int num;

    public ArrayList<Partie> getParties() {
        return parties;
    }

    public void setParties(ArrayList<Partie> parties) {
        this.parties = parties;
    }

    public Jeu() {
        this.num = 0;
    }

    public Partie nouvellePartie(String difficulte, String pseudoJoueur){
        num++;
        this.parties.add(new Partie(difficulte, pseudoJoueur, num));
        Partie nouvellePartie = this.parties.get(this.parties.size()-1);
        String equipeJ = nouvellePartie.getJoueur().choisirEquipe();
        FacadeMatch facadeMatch = new FacadeMatch(equipeJ, "FCB");
        facadeMatch.lancerMatch(new Date());
        nouvellePartie.suivreMatch(facadeMatch.getMatch());
        return this.parties.get(this.parties.size()-1);
    }

    public String chargerPartie(int partie){
        return this.parties.get(partie).ChargerPartie();
    }
}
