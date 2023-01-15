#Author: Younes.Abouelomoum - Nadine.Mahiout

Feature: US_004 Enlever Un Joueur
  En tant que responsable d'équipe
  Je veux enlever un joueur de mon équipe
  Afin de suivre la liste des joueurs de mon équipe

  Scenario Outline: Suppression d'un joueur
    Given une équipe ayant un nom <equipe1>
    When <joueur1> est supprimé de <equipe1>
    Then la liste des joueurs de <equipe1> se décrémente

    Examples:
      | equipe1 | joueur1 |
      | "maroc"   | "ziyech"  |

  Scenario Outline: Joueur introuvable
    Given une équipe ayant un nom <equipe1>
    And <joueur1> n'appartient pas à <equipe1>
    When <joueur1> est supprimé de <equipe1>
    Then le système envoie une erreur disant: <messageErreur>

    Examples:
      | equipe1 | joueur1              | messageErreur        |
      | "maroc"   | "Cristiano Ronaldo"  | "joueur introuvable" |