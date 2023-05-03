@Cart
Feature: Cart feature

  Background: Background for Cart scenarios
    Given user is running Cart scenario
    And user is on homepage

  Scenario Outline: Cart
    Given user is logged in and at the homepage
    When user clicks on menu bar item
    And user enters the search item as "<item1>"
    And clicks on search button
    And user will add to wishlist
    And user enters the search item as "<item2>"
    And clicks on search button
    And user will add to wishlist
    And user is on wishlist
    When user clicks on move to cart
    And user clicks on edit cart button
    And validate the items in cart
    And user update the quantity as "<quantity1>" "<quantity2>"
    And validate the updation

    Examples: 
      | item1   | item2   | quantity1 | quantity2 |
      | Phone   | TV      |         2 |         3 |
      | shirt   | Book    |         3 |         4 |
      | invalid | invalid |         2 |         2 |
