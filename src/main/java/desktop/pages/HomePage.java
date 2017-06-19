package desktop.pages;

import abstractClasses.page.AbstractPage;
import helpers.Browser;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{
    public HomePage(Browser browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }
}
