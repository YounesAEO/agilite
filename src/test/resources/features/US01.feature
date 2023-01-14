Feature: US01 Jouer un match
  En tant que responsable d'équipe
  Je veux avoir le résultat final d'un match de mon équipe
  Afin de mettre à jour les statistiques de l'équipe

  Scenario Outline: Enregistrement d'une victoire
    Given une équipe comprenant un nom <equipe1>
    And une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> supérieur à <buts2>
    Then <equipe1> gagne
    And nombre de victoires de l'équipe gagnante s'incrémente
    And nombre de matchs des deux équipes s'incrémente

    Examples:
      | equipe1 | equipe2 | buts1 | buts2 |
      | "maroc"   | "france"  | 3     | 0   |
  Scenario Outline: Enregistrement d'une défaite
    Given une équipe comprenant un nom <equipe1>
    And une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> inférieur à <buts2>
    Then <equipe1> perd
    And nombre de matchs des deux équipes s'incrémente

    Examples:
      | equipe1 | equipe2   | buts1 | buts2 |
      | "croatie" | "argentine" | 0     | 2     |

  Scenario Outline: Enregistrement d'un match nul
    Given une équipe comprenant un nom <equipe1>
    And une autre équipe comprenant un nom <equipe2>
    When le match termine avec <buts1> égale à <buts2>
    Then les deux équipes égalisent
    And nombre de matchs nuls des deux équipes s'incrémente
    And nombre de matchs des deux équipes s'incrémente


    Examples:
      | equipe1 | equipe2   | buts1 | buts2 |
      | "croatie" | "argentine" | 0     | 0     |