package org.example.designPatterns;

import org.example.agilite.Equipe;
import org.example.agilite.Match;

import java.util.Date;

public class FacadeMatch {
    private Match m1;
    private Equipe e1;
    private Equipe e2;

    public FacadeMatch( String equipe1, String equipe2){
        e1 = new Equipe(equipe1);
        e2 = new Equipe(equipe2);
    }

    public Match getMatch() {
        return m1;
    }

    public void lancerMatch(Date date){
        m1 = new Match(e1, e2, date);
        // generate random numbers
        m1.setScore(e1, 1);
        m1.setScore(e2, 2);
    }

    public void terminerMatch(){

        m1.terminerUnMatch();
    }
}
