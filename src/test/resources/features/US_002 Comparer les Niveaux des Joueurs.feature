#Author: Katia.Nseir - Maria.Bou-Jawde

Feature: US_002 Comparer les Niveaux des Joueurs
  En tant que joueur, je voudrais comparer mon niveau actuel avec mes adversaires
  afin de les battre et devenir le plus fort.

  Scenario Outline: Le joueur compare son niveau avec son adversaire et perd.
    Given Le niveau <niveau> actuel du joueur <pseudoJoueur> et celui de son adversaire <niveauAdversaire>
    And Le niveau du joueur est inférieure ou égale à celui de son adversaire
    When Le joueur compare son niveau avec celui de son adversaire
    Then Le joueur perd <resultat> contre son adversaire et rien ne se passe

    Examples:
      | pseudoJoueur | niveau | niveauAdversaire | resultat                  |
      | "TheBest"    | 74     | 74               | "Joueur perd. Niveau: 74" |
      | "Killer999"  | 52     | 75               | "Joueur perd. Niveau: 52" |
      | "ZamNo1"     | 35     | 50               | "Joueur perd. Niveau: 35" |

  Scenario Outline: Le joueur compare son niveau avec son adversaire, gagne et monte d'un niveau.
    Given Le niveau <niveau> actuel du joueur <pseudoJoueur> et celui de son adversaire <niveauAdversaire>
    And Le niveau du joueur est supérieure à celui de son adversaire
    When Le joueur compare son niveau avec celui de son adversaire
    Then Le joueur gagne <resultat> contre son adversaire et son niveau augmente

    Examples:
      | pseudoJoueur | niveau | niveauAdversaire | resultat                   |
      | "TheBest"    | 78     | 70               | "Joueur gagne. Niveau: 79" |
      | "Killer999"  | 56     | 55               | "Joueur gagne. Niveau: 57" |
      | "ZamNo1"     | 35     | 25               | "Joueur gagne. Niveau: 36" |
