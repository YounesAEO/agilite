package org.example.agilite;

import org.example.designPatterns.Observer;
import org.example.designPatterns.Subject;

import java.util.Date;
import java.util.HashMap;
/**
 * @author Younes.Abouelomoum - Nadine.Mahiout
 * **/
public class Match implements Subject {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final Equipe e1;
    private final Equipe e2;
    private Date date;
    private HashMap<String, Integer> score;
    private Boolean matchTermine;
    private Observer observer;

    /**
     * Constructeur d'objets de classe Match
     * @param e1
     * @param e2
     */
    public Match(Equipe e1, Equipe e2, Date date)
    {
        // initialisation des variables d'instance
        this.e1 = e1;
        this.e2 = e2;
        this.date = date;
        score = new HashMap<String, Integer>();
        score.put(e1.getNom(), 0);
        score.put(e2.getNom(), 0);
        matchTermine = false;
    }

    public void setScore(Equipe e, int buts){
        if(score.containsKey(e.getNom())){
            score.put(e.getNom(), buts);
        }
    }

    public String getScore(){
        return e1.getNom()+": "+score.get(e1.getNom())+" - "+e2.getNom()+": "+score.get(e2.getNom());
    }

    public Date getDate() {
        return date;
    }

    public Equipe getEquipeGagnante(){
        if(score.get(e1.getNom())>score.get((e2.getNom()))){
            return e1;
        } else if (score.get(e1.getNom())<score.get(e2.getNom())) {
            return e2;
        } else {
            return null;
        }
    }

    public Equipe getEquipePerdante(){
        if(score.get(e1.getNom())>score.get((e2.getNom()))){
            return e2;
        } else if (score.get(e1.getNom())<score.get(e2.getNom())) {
            return e1;
        } else {
            return null;
        }
    }
    public void terminerUnMatch()
    {
        // Insérez votre code ici
        Equipe equipeGagnante = getEquipeGagnante();
        if(equipeGagnante == null){
            e1.jouerUnMatch(0);
            e2.jouerUnMatch(0);
        }
        else if (equipeGagnante.equals(e1)) {
            e1.jouerUnMatch(1);
            e2.jouerUnMatch(-1);
        } else {
            e1.jouerUnMatch(-1);
            e2.jouerUnMatch(1);
        }
        matchTermine = true;
    }

    @Override
    public void enregistrerObsever(Observer o) {
        observer = o;
    }

    @Override
    public void supprimerObserver(Observer o) {
        observer = null;
    }

    @Override
    public void notifierObserver() {
        observer.update(this);
    }
}
