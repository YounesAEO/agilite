package org.example.agilite;

/**
 * @author Katia.Nseir - Maria.Bou-Jawde
 * **/
public class Joueur {
    public String getPseudoJoueur() {
        return pseudoJoueur;
    }
    public void setPseudoJoueur(String pseudoJoueur) {
        this.pseudoJoueur = pseudoJoueur;
    }
    public int getNiveau() {
        return niveau;
    }
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    private String pseudoJoueur;
    private int niveau;

    public Joueur(){}
    public Joueur(String pseudoJoueur)
    {
        this.pseudoJoueur = pseudoJoueur;
        this.niveau = 1;
    }

    public String comparerNiveau(int niveauAdversaire) {
        String msg = "";

        if(this.niveau <= niveauAdversaire) {
            msg="Joueur perd. ";
        }
        else {
            this.niveau = this.niveau + 1;
            msg = "Joueur gagne. ";
        }
        return msg + "Niveau: "+this.niveau;
    }

    public String choisirEquipe(){
        return "RMA";
    }
}
