#Author: Younes.Abouelomoum - Nadine.Mahiout - Katia.Nseir - Maria.Bou-Jawde

Feature: US_005 Lancer un Match
  En tant que joueur, je voudrais lancer un match de football 
  en choissant mon équipe afin de jouer contre un adversaire

  Scenario Outline: Lancer un match de football contre un ordinateur
    Given Le lancement d'un match de football entre équipe du joueur <equipe>
    et équipe adverse <equipeAdverse>
    When Le joueur <pseudoJoueur> choisi une équipe <equipe>
    Then Le joueur joue contre une autre équipe adverse <equipeAdverse>


    Examples:
      | pseudoJoueur | equipe     | equipeAdverse |
      | "TheBest"    | "RMA"      | "Barca"       |
      | "ZamNo1"     |  "Bayern"  | "Chelsea"     |


