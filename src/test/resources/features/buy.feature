Feature: Buy products

  Scenario Outline: Buy the products in the car.
    Given How I like <browser> for paying.
    When I try to pay with my <email> and <password>
    And I add basic products to the car.
    And I try to pay.
    Then I finish.

    Examples:
      | browser | email            | password |
      | FIREFOX | hola@erHuevo.com | demodemo |
      #| CHROME  | hola@erHuevo.com | demodemo |