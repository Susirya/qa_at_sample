package mobile.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class AddedToCartPopupFragment extends AbstractFragment{
    @FindBy(id = "cboxContent")
    private WebElement rootElement;

    @FindBy(id = "cboxClose")
    private WebElement closeButton;

    @FindBy(className = "headline-text")
    private WebElement popupTitle;

    @FindBy(className = "add-to-cart-item")
    private WebElement addToCartItem;

    @FindBy(xpath = ".//a[contains(@class,'add-to-cart-button')]")
    private WebElement checkoutButton;

    @FindBy(xpath = ".//a[contains(@class,'js-mini-cart-close-button')]")
    private WebElement continueShoppingButton;

    public void clickButtonWithTitle(String givenTitle){
        if ("Checkout".equalsIgnoreCase(givenTitle)){
            checkoutButton.click();
        }
        if ("Continue shopping".equalsIgnoreCase(givenTitle)) {
            continueShoppingButton.click();
        }
    }

    @Override
    protected WebElement getRoot() {
        waitGui().until().element(rootElement).is().visible();
        return rootElement;
    }
}
