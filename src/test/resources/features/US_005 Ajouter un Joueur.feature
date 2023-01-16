#Author: Younes.Abouelomoum - Nadine.Mahiout

Feature: US_005 Ajouter Un Joueur
  En tant que responsable d'équipe je veux ajouter un nouveau joueur à mon équipe afin de suivre la liste des joueurs de mon équipe

  Scenario Outline: Ajout de joueur
    Given une équipe comprenant le nom <equipe1>
    When <joueur1> est ajouté à <equipe1>
    Then la liste des joueurs de <equipe1> s'incrémente

    Examples:
      | equipe1 | joueur1 |
      | "maroc" | "ziyech"|
