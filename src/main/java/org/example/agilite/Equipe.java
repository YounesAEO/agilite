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
    public Equipe(String nom)
    {
        // initialisation des variables d'instance
        nombreDeMatchs = 0;
        nombreDeVictoires = 0;
        nombreDeMatchNuls = 0;
        joueurs = new ArrayList<String>();
        this.nom = nom;
    }

    public List<String> getListeJoueurs(){
        return joueurs;
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

    public String enleverJoueur(String j){
        if(joueurs.size() == 0) return "l'équipe ne contient pas de joueurs";
        if(!joueurs.contains(j)) return "joueur introuvable";
        joueurs.remove(j);
        return "joueur supprimé";
    }
}
