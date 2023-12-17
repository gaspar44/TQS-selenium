Feature: Verify Subscription in home page

  Scenario: User subscribes successfully from the home page
    Given I use <browser>
    When I scroll down to the footer
    And I verify the presence of the text 'SUBSCRIPTION'
    And I enter an email address and click on the arrow button
    Then I verify the success message 'You have been successfully subscribed!' is visible

    Examples:
      | browser | email            |
      | FIREFOX | hola@erHuevo.com |
      #| CHROME  | hola@erHuevo.com |