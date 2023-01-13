package org.example.agilite;

public class Match {

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private final Equipe e1;
    private final Equipe e2;

    /**
     * Constructeur d'objets de classe Match
     * @param e1
     * @param e2
     */
    public Match(Equipe e1, Equipe e2)
    {
        // initialisation des variables d'instance
        this.e1 = e1;
        this.e2 = e2;
    }


    public void jouerUnMatch(int resultat)
    {
        // Insérez votre code ici
        switch (resultat) {
            case 1 -> {
                e1.jouerUnMatch(1);
                e2.jouerUnMatch(-1);
            }
            case 0 -> {
                e1.jouerUnMatch(0);
                e2.jouerUnMatch(0);
            }
            default -> {
                e1.jouerUnMatch(-1);
                e2.jouerUnMatch(1);
            }
        }

    }
}
