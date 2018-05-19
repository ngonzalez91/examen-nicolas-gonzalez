Feature: Flight Purchase
  As a User, I should be able to buy flight tickets

  Scenario: Verify User is lead to Flight Tickets purchase page
    Given I go to Despegar site
    And I search for flights
      | from         | to         | depart date | return date |
      | Buenos Aires | Montevideo | Tomorrow    | In 1 week   |
    When I want to buy the most expensive flight
    Then I am lead to Flight Tickets purchase page