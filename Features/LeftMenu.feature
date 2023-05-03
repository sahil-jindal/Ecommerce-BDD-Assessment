@LeftMenu
Feature: Left Menu functionality

  Background: Background for Left Menu functionality scenarios
    Given user is running Left Menu functionality scenario

  @LM
  Scenario Outline:  Validate menu item
    Given user is on homepage
    When user clicks on menu bar item
    When user clicks on left menu item "<item>"
    Then The count of the category should match with no. of items displayed

    Examples:
      | item            |
      | Electronics     |
      | Kids Wear       |
      | Furnitures      |
      | Home Appliances |
      | Mens Wear       |
      | invalid         |
