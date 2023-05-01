@Order
Feature: Order
  I want order feature file

  Background: Background for  Order scenarios
    Given user is running  Order scenario
    And user is on homepage

  Scenario Outline: Order
    Given user is logged in and at the homepage
    When user clicks on menu bar item
    And  user enters the search item as "<item1>"
    And  clicks on search button
    And  user will add to wishlist
    And  user enters the search item as "<item2>"
    And  clicks on search button
    And  user will add to wishlist
    And  user is on wishlist
    When user clicks on move to cart
    And  user clicks on edit cart button
    And  user clicks on checkout button
    And  user will fill the card details as "<name>" "<email>" "<address>" "<city>" "<state>" "<Zip>" "<card_name>" "<card_no>" "<expiry_date>" "<cvv>"
    And  user successfully places the order
    And  validate the order

    Examples:
      | item1   | item2 | name  | email               | address | city  | state | Zip     | card_name | card_no          | expiry_date | cvv |
      | Phone   | TV    | other | otheruser@gmail.com | street1 | Delhi | Delhi | 100203  | OTHER     | 1101220133034404 | 12/24       | 389 |
      | shirt   | Book  | other | otheruser@gmail.com | street1 | Delhi | Delhi | 100203  | OTHER     | 11012201304      | 12/24       | 389 |
      | shirt   | Book  | other | otheruser@gmail.com | street1 | Delhi | Delhi | 1003    | OTHER     | 1101220133034404 | 12/24       | 389 |
      | invalid | Book  | other | otheruser@gmail.com | street1 | Delhi | Delhi | 1003302 | OTHER     | 1101220133034404 | 12/24       | 389 |