package mobile.pages.checkout;

import abstractClasses.page.AbstractMobilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DeliveryMethodPage extends AbstractMobilePage {
    private static final String PATH = "/checkout/multi/delivery-method/choose";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";
    private static final String STANDARD_DELIVERY_OPTION_TEXT = "STANDARD DELIVERY - 3-5 BUSINESS DAYS - $11.99";
    private static final String PREMIUM_DELIVERY_OPTION_TEXT = "PREMIUM DDELIVERY - 1-2 BUSINESS DAYS - $19.99";
    private static final String STANDARD_DELIVERY_OPTION_VALUE = "standard-gross";
    private static final String PREMIUM_DELIVERY_OPTION_VALUE = "premium-gross";

    @FindBy (id = "delivery_method")
    private Select deliveryMethodSelect;

    @FindBy
    private WebElement deliveryMethodSubmit;

    public void selectDeliveryMathobByName(String deliveryMethodName){
        if (STANDARD_DELIVERY_OPTION_TEXT.equalsIgnoreCase(deliveryMethodName)){
            deliveryMethodSelect.selectByValue(STANDARD_DELIVERY_OPTION_VALUE);
        }
        if (PREMIUM_DELIVERY_OPTION_TEXT.equalsIgnoreCase(deliveryMethodName)){
            deliveryMethodSelect.selectByValue(PREMIUM_DELIVERY_OPTION_VALUE);
        }
    }

    public void clickNextButton(){
        deliveryMethodSubmit.click();
    }

    @Override
    protected String getPageTitleRegex() {
        return TITLE_REGEX;
    }

    @Override
    protected String getPath() {
        return PATH;
    }
}
