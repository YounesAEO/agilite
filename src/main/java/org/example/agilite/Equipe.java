package org.example.agilite;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int nombreDeMatchs;
    private int nombreDeVictoires;
    private int nombreDeMatchNuls;

    private String nom;
    private List<String> joueurs;

    /**
     * Constructeur d'objets de classe Equipe
     */
    public Equipe()
    {
        // initialisation des variables d'instance
        nombreDeMatchs = 0;
        nombreDeVictoires = 0;
        nombreDeMatchNuls = 0;
        joueurs = new ArrayList<String>();
    }


    public int getNombreDeMatchs()
    {
        // Insérez votre code ici
        return nombreDeMatchs;
    }

    public int getNombreDeVictoires()
    {
        // Insérez votre code ici
        return nombreDeVictoires;
    }

    public int getNombresDeMatchsNuls(){
        return nombreDeMatchNuls;
    }

    public void jouerUnMatch(int resultat){
        if(resultat == 1){
            nombreDeVictoires++;
        } else if (resultat == 0){
            nombreDeMatchNuls++;
        }

        nombreDeMatchs++;
    }

    public String getNom(){
        return nom;
    }

    public void ajouterJoueur(String j){
        joueurs.add(j);
    }

    public void enleverJoueur(String j){
        if(joueurs.contains(j)){
            joueurs.remove(j);
        }
    }
}
