package mobile.pages.checkout;

import abstractClasses.page.AbstractMobilePage;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class FinalOrderReviewPage extends AbstractMobilePage {
    private static final String PATH = "/checkout/multi/summary/view";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";

    @FindBy(id = "Terms1")
    private WebElement agreeWithTermsAndConditionsCheckbox;

    @FindBy(id = "placeOrder")
    private WebElement placeOrderButton;

    @ArquillianResource
    private JavascriptExecutor jsExecutor;

    public void checkAgreeWithTermsAndConditions(){
//        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", agreeWithTermsAndConditionsCheckbox);
        Actions actions = new Actions(browser);
        actions.moveToElement(agreeWithTermsAndConditionsCheckbox);
        actions.perform();
        waitGui().until().element(agreeWithTermsAndConditionsCheckbox).is().visible();
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
