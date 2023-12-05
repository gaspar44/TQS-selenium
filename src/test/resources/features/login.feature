Feature: Login

  Scenario Outline: Login at pag
    Given The <browser>. I register with <name>, <mail> and <password>
    When I try to login with <mail>, <name> and the the glorious <password>
    Then I remove the logged account
    Examples:
      | browser | name | mail             | password |
      | FIREFOX | demo | demo@erHuevo.com | demodemo |
      | CHROME  | demo | demo@erHuevo.com |demodemo|