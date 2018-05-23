Feature: Hotel search
  As a User, I should be able to find Accommodations

  Scenario: Verify User is lead to search Accommodations results page
    Given I go to Despegar accommodations site
    When I search for hotels
      | destiny    | check in   | stay duration | adults | kids |
      | Montevideo | In 10 days | 3 nights      | 2      | 1    |
#    Then I am lead to Search Accommodations results page

#  Scenario: Verify User is able to see details for the cheapest 5 Star Accommodation
#    Given I go to Despegar accommodations site
#    And I search for hotels
#      | destiny    | check in   | stay duration | adults | kids |
#      | Montevideo | In 10 days | 3 nights      | 2      | 1    |
#    When I filter Accommodations by '5' stars
#    And I choose the cheapest Accommodation
#    Then I am lead to Accommodation purchase page