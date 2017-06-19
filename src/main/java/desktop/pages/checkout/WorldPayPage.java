package desktop.pages.checkout;

import abstractClasses.page.AbstractPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

public class WorldPayPage extends AbstractPage {
    private static final String PATH = "/checkout/multi/payment-method/add";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";





    @Override
    protected String getPageTitleRegex() {
        return TITLE_REGEX;
    }

    @Override
    protected String getPath() {
        return PATH;
    }
}
