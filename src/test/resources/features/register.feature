Feature: Register

  Scenario Outline: Register at pag
    Given My favorite <browser>
    When I try to register with <name> and <mail>
    And I fill all the necessary data with the glorious <password>
    Then I remove the created account
    Examples:
      | browser | name | mail             | password |
      | FIREFOX | demo | demo@erHuevo.com |demodemo  |
      | CHROME  | demo | demo@erHuevo.com |demodemo|
