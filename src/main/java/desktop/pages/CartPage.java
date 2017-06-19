package desktop.pages;

import abstractClasses.page.AbstractPage;
import helpers.Browser;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {
    static final String PATH = "/cart";

    public CartPage(Browser browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }

    @Override
    protected String getPath(){
        return PATH;
    }
}
