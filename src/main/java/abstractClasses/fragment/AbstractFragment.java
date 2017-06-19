package abstractClasses.fragment;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractFragment {
    @Drone
    protected WebDriver browser;

    public boolean isDisplayed(){
        return getRoot().isDisplayed();
    }

    protected abstract WebElement getRoot();

}
