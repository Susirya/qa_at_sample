Feature: Home page 
  As a anonymous customer 
  I want to be landed on the home page when I access the site 
  So that I could start my shopping journey  

  Scenario: Check that home page have all proper components with OBP 
    Given I am an anonymous customer with clear cookies 
    When I am on home page 
    Then On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner