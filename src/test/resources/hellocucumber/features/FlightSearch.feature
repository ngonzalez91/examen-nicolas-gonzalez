Feature: Flight search
  As a User, I should be able to find flights

  Scenario: Verify I can search flights given 'from, to, depart date, and return date' parameters
    Given I go to Despegar flights site
    When I search for flights
      | from         | to         | depart date | return date |
      | Buenos Aires | Montevideo | Tomorrow    | In 1 week   |
#    Then I am lead to Search Flight results page