Feature: US03 Enelver Un Joueur
  En tant que responsable d'équipe
  Je veux enlever un joueur de mon équipe
  Afin de suivre la liste des joueurs de mon équipe

  Scenario Outline: Suppression d'un joueur
    Given une équipe comprenant un nom <equipe1> et un joueur appelé <joueur1>
    When <joueur1> est supprimé de <equipe1>
    Then <nombreJoueursAncien> de <equipe1> devient <nombreJoueurs>

    Examples:
      | equipe1 | joueur1 | nombreJoueursAncien | nombreJoueurs |
      | maroc   | ziyech  | 1                     | 0              |

  Scenario Outline: Joueur introuvable
    Given une equipe comprenant un nom <equipe1> et un joueur appelé <joueur1>
    When <joueur1> est supprimé de <equipe1>
    Then le système envoie un <messageErreur>

    Examples:
      | equipe1 | joueur1              | messageErreur        |
      | maroc   | "Cristiano Ronaldo"  | "joueur introuvable" |

  Scenario Outline: Equipe ne contient pas de joueurs
    Given une equipe comprenant un nom <equipe1> et un effectif <nombreJoueurs> et un joueur appelé <joueur1>
    When <joueur1> est supprimé de <equipe1> et <nombreJoueurs> égale à 0
    Then le système envoie un <messageErreur>

    Examples:
      | equipe1 | joueur1              | nombreJoueurs | messageErreur        |
      | maroc   | "ziyech"             | 0             | "l'équipe ne contient pas de joueurs" |