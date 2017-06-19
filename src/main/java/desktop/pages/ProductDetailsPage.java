package desktop.pages;

import abstractClasses.page.AbstractPage;

public class ProductDetailsPage extends AbstractPage {
    private static final String PRODUCT_DETAILS_PAGE_TITLE_REGEX = "(.*)| Open Catalogue | Electronics Site";






    @Override
    protected String getPageTitleRegex(){
        return PRODUCT_DETAILS_PAGE_TITLE_REGEX;
    }
}
