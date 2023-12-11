Feature: Search products

  Scenario Outline: Search products
    Given I use <browser> for search products
    When I type a <category>.
    Then I see a <category> result.

    Examples:
      |browser| category|
      #|FIREFOX| T-Shirt |
      |CHROME | Jeans|