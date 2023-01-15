#Author: Katia.Nseir - Maria.Bou-Jawde

Feature: US_001 Continuer une Partie
  En tant que joueur, je voudrais continuer la partie de mon jeu préféré que j'avais arrêté il y a 2 semaines.

  Scenario Outline: Reprendre une partie savegardée
    Given Un joueur et une partie sauvegardée <partie>
    And La partie sauvegardée contient sa difficulté <difficulte> et sa dernière date de sauvegarde <date_sauvegarde>
    And Le personnage <pseudoJoueur> de la partie sauvegardée possède son niveau actuel <niveau>
    When Le joueur séléctionne une partie sauvegardée <partie>
    Then La partie savegardée sera chargée et retourne son message de chargement <chargement>

    Examples:
      | partie    | difficulte  | date_sauvegarde | pseudoJoueur | niveau | chargement                                               |
      | "partie1" | "facile"    | "10/09/2022"    | "TheBest"    | 74     | "Partie facile de TheBest du 10/09/2022 est chargée!"    |
      | "partie2" | "normale"   | "02/01/2023"    | "Killer999"  | 52     | "Partie normale de Killer999 du 02/01/2023 est chargée!" |
      | "partie3" | "difficile" | "12/12/2019"    | "ZamNo1"     | 35     | "Partie difficile de ZamNo1 du 12/12/2019 est chargée!"  |