package abstractClasses.page;

import desktop.fragments.HeaderFragment;
import helpers.PropertyLoader;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AbstractPage {
    private static final String BASE_URL = PropertyLoader.getInstanse().getPropertyValue("base.url");
    private static final String HOMEPAGE_TITLE_REGEX = "Electronics Site | Homepage";

    @Drone
    protected WebDriver browser;

    @FindBy(className = "js-mainHeader")
    private HeaderFragment headerFragment;

    public String actualTitle() {
        return browser.getTitle();
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }

    public void visit(){
        browser.get(BASE_URL + getPath());
    }

    public boolean isCurrent(){
        return actualTitle().equals(getPageTitleRegex()) || actualTitle().matches(getPageTitleRegex());
    }

    protected String getPageTitleRegex(){
        return HOMEPAGE_TITLE_REGEX;
    }

    protected String getPath(){
        return "";
    }
}
