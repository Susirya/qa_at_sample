package mobile.pages;

import abstractClasses.page.AbstractPage;
import com.google.common.base.Predicate;
import mobile.fragments.AddedToCartPopupFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class ProductDetailsPage extends AbstractPage {
    private static final String PRODUCT_DETAILS_PAGE_TITLE_REGEX = "(.*)| Open Catalogue | Electronics Site";

    @FindBy(className = "name")
    private WebElement productName;

    @FindBy(className = "code")
    private WebElement productCode;

    @FindBy(className = "price")
    private WebElement productPrice;

    @FindBy(className = "description")
    private WebElement productDescription;

    @FindBy(id = "pdpAddtoCartInput")
    private WebElement productAddToCartQuantity;

    @FindBy(id = "addToCartButton")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//button[contains(@class,'js-pickup-in-store-button')]")
    private WebElement pickUpInStoreButton;

    @FindBy(id = "cboxContent")
    private AddedToCartPopupFragment addedToCartPopupFragment;

    public boolean isProductIdEquals(String givenId) {
        return givenId != null && givenId.equals(productCode.getText());
    }

    public void clickButtonWithTitle(String givenTitle){
        if ("Add to cart".equalsIgnoreCase(givenTitle)){
            addToCartButton.click();
            waitGui().until((Predicate<WebDriver>) webDriver -> addedToCartPopupFragment.isDisplayed());
        }
        if ("Pick Up in Store".equalsIgnoreCase(givenTitle)) {
            pickUpInStoreButton.click();
            // TODO add waiter for store selector popup (when it will be implemented
        }
    }

    public void goToCheckoutOnPopup(String givenTitle){
        addedToCartPopupFragment.clickButtonWithTitle(givenTitle);
    }

    @Override
    protected String getPageTitleRegex(){
        return PRODUCT_DETAILS_PAGE_TITLE_REGEX;
    }

    @Override
    protected String getPath(){
        return "";
    }
}
