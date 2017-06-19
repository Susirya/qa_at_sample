package mobile.pages.checkout;

import abstractClasses.page.AbstractPage;
import mobile.fragments.CheckoutOrderSummaryFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class DeliveryAddressPage extends AbstractPage {
    private static final String PATH = "/checkout/multi/delivery-address/add";
    private static final String TITLE_REGEX = "Checkout | Electronics Site";

    @FindBy(className = "checkout-order-summary")
    private CheckoutOrderSummaryFragment checkoutOrderSummaryFragment;

    //TODO inplement/include OrderCheckoutStepsFragment(class="checkout-steps")

    @FindBy(id="address.country")
    private Select addressCountrySelect;

    @FindBy(id="address.title")
    private Select addressTitleSelect;

    @FindBy(id="address.title")
    private WebElement addressTitle;

    @FindBy(id="address.firstName")
    private WebElement addressFirstName;

    @FindBy(id="address.surname")
    private WebElement addressSurname;

    @FindBy(id="address.line1")
    private WebElement addressLine1;

    @FindBy(id="address.line2")
    private WebElement addressLine2;

    @FindBy(id="address.townCity")
    private WebElement addressTownCity;

    @FindBy(id="address.region")
    private Select addressRegionSelect;

    @FindBy(id="address.postcode")
    private WebElement addressPostcode;

    @FindBy
    private WebElement addressSubmit;

    public void fillMandatoryAddressFields(Map<String,String> dataMap){
        addressCountrySelect.selectByVisibleText(dataMap.get("Country"));
        waitGui().until().element(addressTitle).is().visible();
        addressTitleSelect.selectByVisibleText(dataMap.get("Title"));
        addressFirstName.sendKeys(dataMap.get("First Name"));
        addressSurname.sendKeys(dataMap.get("Last Name"));
        addressLine1.sendKeys(dataMap.get("Address Line 1"));
        addressTownCity.sendKeys(dataMap.get("City"));
        if (dataMap.get("Region") != null) {
            addressRegionSelect.selectByVisibleText(dataMap.get("Region"));
        }
        addressPostcode.sendKeys(dataMap.get("Post Code"));
    }

    public void clickNextButton(){
        addressSubmit.click();
    }

    public CheckoutOrderSummaryFragment getTotalsFragment() {
        return checkoutOrderSummaryFragment;
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
