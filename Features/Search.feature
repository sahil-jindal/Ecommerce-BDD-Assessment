@Search
Feature: Search for an Item

  Background: Background for Search scenarios
    Given user is running search scenario

  @SP
  Scenario Outline: Search for the Item
    Given user is on homepage
    When user clicks on menu bar item
    And  user selects category as "<category>"
    And user enters the search item as "<item>"
    And clicks on search button
    Then user should be able to view the items "<item>"

    Examples:
      | category       | item    |
      | All Categories | sony    |
      | Men            | tv      |
      | Women          | phone   |
      | invalid        | phone   |
      | All Categories | invalid |
      | All Categories |         |