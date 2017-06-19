package abstractClasses.page;

import com.google.common.base.Predicate;
import desktop.fragments.HeaderFragment;
import helpers.PropertyLoader;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public abstract class AbstractDesktopPage {
    private static final String BASE_URL = PropertyLoader.getInstanse().getPropertyValue("base.url");

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
        waitGui().until((Predicate<WebDriver>) webDriver -> isCurrent());
    }

    public void visit(String relativePath){
        browser.get(BASE_URL + relativePath);
    }

    public boolean isCurrent(){
        return actualTitle().equals(getPageTitleRegex()) || actualTitle().matches(getPageTitleRegex());
    }

    protected abstract String getPageTitleRegex();
    protected abstract String getPath();
}
