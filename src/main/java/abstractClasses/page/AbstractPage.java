package abstractClasses.page;

import desktop.fragments.HeaderFragment;
import helpers.PropertyLoader;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbstractPage {
    protected static final String BASE_URL = PropertyLoader.getInstanse().getPropertyValue("base.url");

    @Drone
    protected WebDriver browser;

    @FindBy(id = "header")
    private HeaderFragment headerFragment;

//   DemoLab
//    @FindBy(className = "navMainList")
//   WX - TP
    @FindBy(id = "nav_main")
    private WebElement navigationMenu;

    public String getTitle() {
        return browser.getTitle();
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }

    public WebElement getNavigationMenu() {
        return navigationMenu;
    }

    public void visit(){
        browser.get(BASE_URL + getPath());
    }

    protected String getPath(){
        return "";
    }
}
