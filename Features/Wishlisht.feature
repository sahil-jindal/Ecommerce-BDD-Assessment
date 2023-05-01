@Wishlist
Feature: Wishlist

  Background: Background for Wishlist scenarios
    Given user is running Wishlist scenario
    And user is on homepage

  Scenario Outline: Wishlist
    Given user is logged in and at the homepage
    When user clicks on menu bar item
    And user enters the search item as "<item1>"
    And clicks on search button
    And  user will add to wishlist
    And  user enters the search item as "<item2>"
    And clicks on search button
    And  user will add to wishlist
    Then  validate the items in wishlist
    And  user removes the item "<item1>" from wishlist
    And  validate the removed product

    Examples:
      | item1   | item2   |
      | Phone   | TV      |
      | shirt   | Book    |
      | invalid | invalid |
      | invalid | Book    |
      | shirt   | invalid |
