package desktop.pages;

import abstractClasses.page.AbstractPage;

public class DeliveryAddressPage extends AbstractPage {
    private static final String PATH = "/checkout/multi/delivery-address/add";
    private static final String DELIVERY_ADDRESS_PAGE_TITLE_REGEX = "Checkout | Electronics Site";







    @Override
    protected String getPageTitleRegex() {
        return DELIVERY_ADDRESS_PAGE_TITLE_REGEX;
    }

    @Override
    protected String getPath() {
        return PATH;
    }
}
