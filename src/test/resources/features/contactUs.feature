Feature: Contact Us

  Scenario Outline: Contact Us form
    Given My <browser>
    When I fill the contact us with <name> and <mail>
    And I click the button
    Then I get a correct message

    Examples:
      | browser | name | mail             |
      | FIREFOX | John | demo@erHuevo.com |
      | CHROME  | John | demo@erHuevo.com|