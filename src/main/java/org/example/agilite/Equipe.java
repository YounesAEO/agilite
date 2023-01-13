package org.example.agilite;

public class Equipe {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int nombreDeMatchs;
    private int nombreDeVictoires;
    private int nombreDeMatchNuls;

    private String nom;

    /**
     * Constructeur d'objets de classe Equipe
     */
    public Equipe()
    {
        // initialisation des variables d'instance
        nombreDeMatchs = 0;
        nombreDeVictoires = 0;
        nombreDeMatchNuls = 0;
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
}
