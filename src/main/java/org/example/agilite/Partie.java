package org.example.agilite;
import org.example.designPatterns.Observer;
import org.example.designPatterns.Subject;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author Katia.Nseir - Maria.Bou-Jawde
 * **/
public class Partie implements Observer {
    private String partie;
    private Joueur joueur;
    private String difficulte;
    private String date_sauvegarde;
    private Subject match;

    @Override
    public String toString() {
        return partie;
    }

    @Override
    public boolean equals(Object o) {
        if (this.partie.equals((String)o)) return true;
        return false;
    }

    public void setDateSauvegarde(Date date_sauv) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date_sauv);
        this.date_sauvegarde = stringDate;
    }

    public void setDateSauvegarde(String date_sauv) {
        this.date_sauvegarde = date_sauv;
    }

    public Partie(){

    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public Partie(String choix, String pseudoJoueur, int numero) {
        this.difficulte = choix;
        this.joueur = new Joueur(pseudoJoueur);
        Date date = new Date();
        this.setDateSauvegarde(date);
        this.partie = "partie"+numero;
    }

    public void suivreMatch(Subject match){
        this.match = match;
        match.enregistrerObsever(this);
    }

    public void setPartie(String partie) {
        this.partie = partie;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Joueur getJoueur(){return joueur;}

    public String ChargerPartie(){
        return "Partie " + this.difficulte + " de "
                + this.joueur.getPseudoJoueur() + " du "
                + this.date_sauvegarde +" est chargée!";
    }

    public String sauvegarderPartie(Date date){
        setDateSauvegarde(date);
        return "Partie " + this.difficulte + " de "
                + this.joueur.getPseudoJoueur() + " du "
                + this.date_sauvegarde +" est sauvegardée!";
    }

    public void update(Subject subject){
        if(subject instanceof Match){
            Match match = (Match) subject;
            System.out.println("Resultat match"+ match.getScore());
            sauvegarderPartie(match.getDate());
        }
    }
}
