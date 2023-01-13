Feature: US01 Jouer un match
  En tant que responsable d'équipe
  Je veux avoir le résultat final d'un match de mon équipe
  Afin de mettre à jour les statistiques de l'équipe

  Scenario Outline: Enregistrement d'une victoire
    Given une équipe comprenant un nom <equipe1> et une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> supérieur à <buts2>
    Then <equipeGagnante> est <equipe1> et <nombreVictoiresAncien> devient <nombreVictoires> et <nombreMatchsAncien> devient <nombreMatchs>

    Examples:
      | equipe1 | equipe2 | buts1 | buts2 | equipeGagnante | nombreVictoiresAncien | nombreVictoires | nombreMatchsAncien | nombreMatchs |
      | maroc   | france  | 3     | 0     |   maroc         | 0                       | 1                | 0                    | 1             |

  Scenario Outline: Enregistrement d'une défaite
    Given une équipe comprenant un nom <equipe1> et une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> inférieur à <buts2>
    Then <equipeGagnante> est <equipe2> et <nombreMatchsAncien> devient <nombreMatchs>

    Examples:
      | equipe1 | equipe2   | buts1 | buts2 | equipeGagnante | nombreMatchsAncien | nombreMatchs |
      | croatie | argentine | 0     | 2     | argentine       | 0                    | 1             |

  Scenario Outline: Enregistrement d'un match nul
    Given une équipe comprenant un nom <equipe1> et une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> égale à <buts2>
    Then <equipeGagnante> est null et <nombreNullsAncien> devient <nombreNulls> et et <nombreMatchsAncien> devient <nombreMatchs>

    Examples:
      | equipe1 | equipe2   | buts1 | buts2 | equipeGagnante | nombreNullsAncien | nombreNulls | nombreMatchsAncien | nombreMatchs |
      | croatie | argentine | 0     | 0     | null            | 0                   | 1            | 0                    | 1             |
