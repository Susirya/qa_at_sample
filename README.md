##This is BDD sample project.

####Task: 
1. Setup Hybris Environment using Demo.
2. Create Testing Framework using : Java, Selenium, BDD (Cucumber or JBehave). 
See Framework Schema in main/resources/Schema.png 
3. Implement tests from test/resources/features.

####Description: 
  2 main branches contain different approaches/tools used in framework.

  While both use Cucumber, 
  
  `master` branch uses simple BrowserFactory to provide webdriver instances, and 
  
  `aqruillian` branch uses Arquillian Drone/Graphene to init webdriver, pages and fragments 
  
  Test environment selected by maven profile:
   `mvn -Pchrome_desktop`
   
  Possible profiles are: 
  
  `chrome_desktop`, `firefox_desktop`, `edge_desktop`, `chrome_mobile`