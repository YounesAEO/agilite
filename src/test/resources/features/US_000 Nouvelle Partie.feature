#Author: Katia.Nseir - Maria.Bou-Jawde

Feature: US_000 Nouvelle Partie
  En tant que joueur, je voudrais commencer une nouvelle partie de mon jeu préféré.

  Scenario Outline: Créer une nouvelle partie et choisir sa difficulté
    Given Le lancement du jeu par le joueur pour creer une nouvelle partie
    When Le joueur saisi la difficulté <difficulte> de la nouvelle partie et son surnom <pseudoJoueur>
    Then La nouvelle partie <partie> est créée

    Examples:
      | partie    | difficulte  | pseudoJoueur |
      | "partie1" | "facile"    | "TheBest"    |
      | "partie2" | "normale"   | "Killer999"  |
      | "partie3" | "difficile" | "ZamNo1"     |