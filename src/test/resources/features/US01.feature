Feature: US01 Jouer un match
  En tant que equipe
  Je veux jouer un match contre une autre equipe
  Afin de pouvoir gagner ou perdre contre cette equipe

  Scenario Outline: Match gagné par l'equipe locale
    Given une equipe comprenant un nom <equipe1> et une autre equipe comprenant un nom <equipe2>
    When <equipe1> marque plus de buts que <equipe2>
    Then <equipe_gagnante> est <equipe1> et <equipe_perdue> est <equipe2>

    Examples:
      | equipe1 | equipe2 | buts1 | buts2 | equipe_gagnante | equipe_perdue |
      | maroc   | france  | 3     | 0     |   maroc         | france        |

  Scenario Outline: Match gagné par l'equipe visiteure
    Given une equipe comprenant un nom <equipe1> et une autre equipe comprenant un nom <equipe2>
    When <equipe1> marque moins de buts que <equipe2>
    Then <equipe_gagnante> est <equipe2> et <equipe_perdue> est <equipe1>

    Examples:
      | equipe1 | equipe2 | buts1 | buts2 | equipe_gagnante | equipe_perdue |
      | croatie   | argentine  | 0     | 2     |   argentine         | croatie        |

  Scenario Outline: Match nul
    Given une equipe comprenant un nom <equipe1> et une autre equipe comprenant un nom <equipe2>
    When <equipe1> marque autant de buts que <equipe2>
    Then pas de <equipe_gagnante> et pas de <equipe_perdue>

    Examples:
      | equipe1 | equipe2 | buts1 | buts2 | equipe_gagnante | equipe_perdue |
      | croatie   | argentine  | 0     | 0     |   null         | null        |
