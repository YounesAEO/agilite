package org.example.designPatterns;

public interface Subject {
    void enregistrerObsever(Observer o);
    void supprimerObserver(Observer o);
    void notifierObserver();
}
