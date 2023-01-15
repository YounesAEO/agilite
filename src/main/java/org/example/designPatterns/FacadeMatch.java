package org.example.designPatterns;

import org.example.agilite.Equipe;
import org.example.agilite.Match;

import java.util.Date;

public class FacadeMatch {
    private Match m1;
    private Equipe equipeJoueur;
    private Equipe equipeAdverse;


    public Equipe getEquipeJoueur() {
        return equipeJoueur;
    }

    public Equipe getEquipeAdverse() {
        return equipeAdverse;
    }

    public FacadeMatch( String equipe1, String equipe2){
        equipeJoueur = new Equipe(equipe1);
        equipeAdverse = new Equipe(equipe2);
    }

    public Match getMatch() {
        return m1;
    }

    public void lancerMatch(Date date){
        m1 = new Match(equipeJoueur, equipeAdverse, date);
        // generate random numbers
        m1.setScore(equipeJoueur, 1);
        m1.setScore(equipeAdverse, 2);
    }

    public void terminerMatch(){

        m1.terminerUnMatch();
    }
}
