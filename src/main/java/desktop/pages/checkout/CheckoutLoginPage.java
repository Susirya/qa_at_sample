package desktop.pages.checkout;

import abstractClasses.page.AbstractPage;

public class CheckoutLoginPage extends AbstractPage {
    private static final String PATH = "/login/checkout";
    private static final String PRODUCT_DETAILS_PAGE_TITLE_REGEX = "(.*)| Open Catalogue | Electronics Site";

    @Override
    protected String getPageTitleRegex() {
        return "";
    }

    @Override
    protected String getPath(){
        return PATH;
    }
}
