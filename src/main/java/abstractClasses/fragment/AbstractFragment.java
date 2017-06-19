package abstractClasses.fragment;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;

public abstract class AbstractFragment {
    @Drone
    private WebDriver browser;



}
