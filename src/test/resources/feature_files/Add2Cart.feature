@TutorialsNinjaAdd2Cart
  Feature: Verifying add to cart features of Tutorials Ninja


    @Add2CartWithLoginWithValidProduct
    Scenario Outline: Adding a valid product after logging in into the account
      Given User navigates to login page
      When User enters valid email <email>
      And User enters valid password <password>
      When User clicks on Login button
      Then User is redirected to Account Page
      When User enters valid product "HP"
      And User clicks on search button
      Then User gets valid product info display in search page
      When User clicks on AddToCart button present in ProductPage
      Then User is re-directed to AddToCartPage
      When User confirms quantity as one
      And User clicks on AddToCart button again in this page
      Then User receives a Success Message
      And The Cart symbol increments with one item
      Examples:
        | email                   | password     |
        | seleniumpanda@gmail.com | Selenium@123 |


    @Add2CartWithLoginWithInvalidProduct
      Scenario: Adding an invalid product after logging in into the account
        Given User navigates to login page
        And User enters valid email "seleniumpanda@gmail.com"
        And User enters valid password "Selenium@123"
        When User clicks on Login button
        Then User is re-directed to AccountPage
        When User enters invalid product "DELL" in searchbox
        And User clicks on search button
        Then User gets warning message no product found


    @Add2CartWithoutLoginWithValidProduct
    Scenario: Adding a valid product without logging in into the account
      Given User navigates to login page
      When User enters valid product "HP" in searchbox
      And clicks on search button
      Then User is navigated to ProductPage
      When User clicks on AddToCart button present in ProductPage
      Then User is re-directed to AddToCartPage
      When User confirms quantity as one
      And User clicks on AddToCart button again in this page
      Then User receives a Success Message
      And The Cart symbol increments with one item

      @Add2CartWithoutLoginWithInvalidProduct
      Scenario: Adding an invalid product without logging in into the account
        Given User navigates to login page
        When User enters invalid product "DELL" in searchbox
        And User clicks on search button
        Then User gets warning message no product found