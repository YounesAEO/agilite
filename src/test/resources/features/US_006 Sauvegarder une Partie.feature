#Author: Younes.Abouelomoum - Nadine.Mahiout - Katia.Nseir - Maria.Bou-Jawde

Feature: US_006 Sauvegarder une Partie
  En tant que joueur, je voudrais sauvegarder une partie que j'ai terminé afin de consulter le résultat plus tard

  Scenario Outline: Sauvegarder la partie terminée par le joueur
    Given Une partie
    And Un match entre équipe joueur <equipe1> et équipe adverse <equipe2> avec la date <dateSauvegarde>
    And Un joueur <pseudojoueur>
    When Le joueur termine le match
    Then la partie est sauvegardée <dateSauvegarde>

    Examples:
      | equipe1 | equipe2   | pseudojoueur | dateSauvegarde |
      | "RMA"   | "Barca"   | "TheBest"    | "10/09/2022"   |
      | "Bayern"| "Chelsea" | "ZamNo1"     | "12/12/2019"   |



