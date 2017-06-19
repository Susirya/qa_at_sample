package mobile.pages.checkout;

import abstractClasses.page.AbstractMobilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalOrderReviewPage extends AbstractMobilePage {
    private static final String PATH = "/checkout/multi/summary/view";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";

    @FindBy(id = "Terms1")
    private WebElement agreeWithTermsAndConditionsCheckbox;

    @FindBy(id = "placeOrder")
    private WebElement placeOrderButton;

    public void checkAgreeWithTermsAndConditions(){
        if (!agreeWithTermsAndConditionsCheckbox.isSelected()){
            agreeWithTermsAndConditionsCheckbox.click();
        }
    }

    public void uncheckUseMyDeliveryAddress(){
        if (agreeWithTermsAndConditionsCheckbox.isSelected()){
            agreeWithTermsAndConditionsCheckbox.click();
        }
    }

    public void clickPlaceOrdeButton(){
        placeOrderButton.click();
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
