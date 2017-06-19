package stepdefs.desktop;

import cucumber.api.java.Before;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;


public class Hooks {
    @Drone
    public WebDriver browser;


    @Before
    public void setUp() {
        browser.manage().window().maximize();
    }
}
