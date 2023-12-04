Feature: Register

  Scenario Outline: Register at pag
    Given My favorite <browser>
    When I try to register with <name> and <mail>
    Then I fill all the necessary data
    Examples:
      | browser | name | mail             |
      | FIREFOX | demo | demo@erHuevo.com |
      #| CHROME  | demo1 | demo@erGranHuevo.com |
