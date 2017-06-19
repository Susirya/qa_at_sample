package abstractClasses.page;

import desktop.fragments.HeaderFragment;
import helpers.Browser;
import helpers.PropertyLoader;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private static final String BASE_URL = PropertyLoader.getInstanse().getPropertyValue("base.url");
    protected Browser browser;

    @FindBy(id = "header")
    HeaderFragment headerFragment;

    public AbstractPage(Browser browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        headerFragment = PageFactory.initElements(browser, HeaderFragment.class);
    }

    public String getTitle() {
        return browser.getTitle();
    }

    public Browser getBrowser() {
        return browser;
    }

    public HeaderFragment getHeaderFragment() {
        return headerFragment;
    }

    public void visit(){
        browser.navigate().to(BASE_URL + getPath());
    }

    protected String getPath(){
        return "";
    }
}
