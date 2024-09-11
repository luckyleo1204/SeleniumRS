@tag
  Feature: Purchase the order from Ecommmerce WebSite
    I want to use this template for my feature file

    @Background:
      Given I landed on Ecommerce Page

    @tag2
      Scenario Outline: Title of the scenaro Outline
      Given  I Logged in with username <name> and password <password>
      When I add the prouct <productName> to cart
      And Checkout <productName> and submit the order
      Then "THANKYOU FOR THE ORDER" message is displayed on confirmation page.

      Examples:
        | name                  | password    | productName |  |
        | rahulsheety@gmail.com | Iamking@000 | Zara coat 3 |  |
