Feature: Product search result page
  As a anonymous customer
  I want to be able to search product on site
  So that I can quickly search products and see search results

  Background:
    Given I am an anonymous customer with clear cookies
    And I am on home page
    And I search for "camelio"
    And I am redirected to a Search page

  Scenario: AC1 - sSearch and view search result
    When I find 2 products with name "CAMILEO"
    Then all product contains image, price, button "Add to cart"

  Scenario: Add to cart
    When click "Add to cart" button for product "CAMILEO S10 EU"
    Then add to cart confirmation pop-up appears

  Scenario: Go to PDP
    When click on product "CAMILEO S10 EU" on search result page
    Then I am redirected on product details page