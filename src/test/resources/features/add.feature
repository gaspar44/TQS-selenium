Feature: Add products

  Scenario Outline: Search and add two products to the shopping car
    Given The <browser> that I use for buying products
    When I add the first two products to the car.
    Then I check the car.

    Examples:
      | browser |
      | FIREFOX |
      #|CHROME |