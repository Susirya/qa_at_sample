package mobile.pages.checkout;

import abstractClasses.page.AbstractMobilePage;
import mobile.fragments.ConfirmationSummaryFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractMobilePage {
    private static final String PATH = "/checkout/orderConfirmation/";
    private static final String TITLE_REGEX = "Order Confirmation | Electronics Site";

    @FindBy(className = "orderTotal")
    private ConfirmationSummaryFragment confirmationSummaryFragment;

    @FindBy(className = "checkout-success__body__headline")
    private WebElement confirmationMessage;

    @FindBy(xpath = ".//div[@class='checkout-success__body']/p[1]/b")
    private WebElement orderNumber;

    @FindBy(xpath = ".//button[contains(@class, 'btn--continue-shopping')]")
    private WebElement continueShoppingButton;

    public ConfirmationSummaryFragment getTotalsFragment() {
        return confirmationSummaryFragment;
    }

    public boolean isConfirmationmessageEqual(String givenMessage){
        return givenMessage != null && givenMessage.equalsIgnoreCase(confirmationMessage.getText());
    }

    public boolean isOrderNumberVisible() {
        return orderNumber.isDisplayed() && !orderNumber.getText().trim().equals("");
    }

    public void clickContinueShoppingButton() {
        Actions actions = new Actions(browser);
        actions.moveToElement(continueShoppingButton);
        actions.perform();
        continueShoppingButton.click();
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
