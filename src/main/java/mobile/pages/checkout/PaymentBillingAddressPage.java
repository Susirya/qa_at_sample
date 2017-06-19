package mobile.pages.checkout;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PaymentBillingAddressPage extends AbstractPage {
    private static final String PATH = "/checkout/multi/sop/response";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";

    @FindBy (id="card_cardType")
    private Select cardTypeSelect;

    @FindBy (id="card_nameOnCard")
    private WebElement cardHolderNameField;

    @FindBy (id="card_accountNumber")
    private WebElement cardNumberField;

    @FindBy (id="ExpiryMonth")
    private Select cardExpiryMonthSelect;

    @FindBy (id="ExpiryYear")
    private Select cardExpiryYearSelect;

    @FindBy (id="card_cvNumber")
    private WebElement cardVerificationNumberField;

    @FindBy (id="useDeliveryAddress")
    private WebElement useDeliveryAddressCheckbox;

    @FindBy(xpath = ".//button[contains(@class, 'submit_silentOrderPostForm')]")
    private WebElement submitPaymentDetailsButton;

    public void fillMandatoryCardFields(Map<String,String> dataMap){
        cardTypeSelect.selectByVisibleText(dataMap.get("type"));
        cardNumberField.sendKeys(dataMap.get("number"));
        cardExpiryMonthSelect.selectByVisibleText(dataMap.get("month"));
        cardExpiryYearSelect.selectByVisibleText(dataMap.get("year"));
        cardVerificationNumberField.sendKeys(dataMap.get("verificationID"));
    }

    public void checkUseMyDeliveryAddress(){
        if (!useDeliveryAddressCheckbox.isSelected()){
            useDeliveryAddressCheckbox.click();
        }
    }

    public void uncheckUseMyDeliveryAddress(){
        if (useDeliveryAddressCheckbox.isSelected()){
            useDeliveryAddressCheckbox.click();
        }
    }

    public void clickNextButton(){
        submitPaymentDetailsButton.click();
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
