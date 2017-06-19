package desktop.pages;

import abstractClasses.page.AbstractPage;
import helpers.Browser;
import org.openqa.selenium.support.PageFactory;

public class CheckoutLoginPage extends AbstractPage {
    public static final String PATH = "/checkout/hybrid/login";

    public CheckoutLoginPage(Browser browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }

    @Override
    protected String getPath(){
        return PATH;
    }
}
