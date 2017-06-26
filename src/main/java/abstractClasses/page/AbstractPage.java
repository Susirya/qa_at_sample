package abstractClasses.page;

import abstractClasses.fragment.HeaderFragmentInterface;
import com.google.common.base.Predicate;
import helpers.PropertyLoader;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public abstract class AbstractPage {
    private static final String BASE_URL = PropertyLoader.getInstanse().getPropertyValue("base.url");

    @Drone
    protected WebDriver browser;

    @FindBy(className = "js-mainHeader")
    private desktop.fragments.HeaderFragment desktopHeaderFragment;

    @FindBy(className = "js-mainHeader")
    private mobile.fragments.HeaderFragment mobileHeaderFragment;

    @FindBy(css = ".branding-mobile")
    private WebElement mobilePageLayoutIndicator;

    public String actualTitle() {
        return browser.getTitle();
    }

    public HeaderFragmentInterface getHeaderFragment() {
        if (isMobilePageLayout()) {
            return mobileHeaderFragment;
        }
        return desktopHeaderFragment;
    }

    public void visit(){
        browser.get(BASE_URL + getPath());
        waitGui().until((Predicate<WebDriver>) webDriver -> isCurrent());
    }

    public void visit(String relativePath){
        browser.get(BASE_URL + relativePath);
    }

    public boolean isCurrent(){
        return actualTitle().equals(getPageTitleRegex()) || actualTitle().matches(getPageTitleRegex());
    }

    public boolean isMobilePageLayout() {
        return mobilePageLayoutIndicator.isDisplayed();
    }

    protected abstract String getPageTitleRegex();
    protected abstract String getPath();
}
