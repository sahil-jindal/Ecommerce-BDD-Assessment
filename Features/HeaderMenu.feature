@HeaderMenu
Feature: Menu Functionality

  Background: Background for Menu functionality scenarios
    Given user is running menu functionality scenario

  @HM
  Scenario Outline: Validate menu item
    Given user is on homepage
    When user clicks on menu bar item "<item>"
    Then user should be able to navigate to the item page

    Examples:
      | item            |
      | Electronics     |
      | Kids Wear       |
      | Furniture       |
      | Home Appliances |
      | invalid         |

  @HM1
  Scenario Outline: Validate Products
    Given user is on homepage
    When user clicks on menu bar item "<item>"
    Then user should be able to navigate to the item page
    And validate the product present with "<name>" and "<original price>" and "<Disc price>"

    Examples:
      | item                | name                  | original price | Disc price |
      | Electronics Gadgets | sony headphones       | $990.00        | 3500       |
      | Electronics Gadgets | samsung headphones    | $990.00        | 3500       |
      | Kids Wear           | camera with 3D pixels | $990.00        | 2569       |
      