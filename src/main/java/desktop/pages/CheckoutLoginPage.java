package desktop.pages;

import abstractClasses.page.AbstractPage;

public class CheckoutLoginPage extends AbstractPage {
    public static final String PATH = "/checkout/hybrid/login";

    @Override
    protected String getPageTitleRegex() {
        return "";
    }

    @Override
    protected String getPath(){
        return PATH;
    }
}
