package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    private static final String PATH = "cart";
    private static final String CARTPAGE_TITLE_REGEX = "Your Shopping Cart | Electronics Site";


    // Ugly, but the only possible way with xpath/css
    @FindBy(xpath = "(.//*[text()='Subtotal:']/following::*[contains(@class,'text-right')])[1]")
    private WebElement subtotal;

    @FindBy(xpath = ".//*[text()='Order Total']/following::*[contains(@class,'col-xs-6 cart-totals-right text-right')]")
    private WebElement grandTotal;

    @FindBy(xpath = ".//button[contains(@class, 'js-continue-checkout-button')]")
    private WebElement checkoutButton;

    @FindBy(xpath = ".//button[contains(@class, 'js-continue-shopping-button')]")
    private WebElement continueShoppingButton;





    public boolean isSubtotalEquals(String givenAmount) {
        return givenAmount != null && givenAmount.equalsIgnoreCase(subtotal.getText());
    }

    public boolean isGrandTotalEquals(String givenAmount){
        return givenAmount != null && givenAmount.equalsIgnoreCase(grandTotal.getText());
    }

    public void clickButtonWithTitle(String givenTitle){
        if ("Checkout".equalsIgnoreCase(givenTitle)){
            checkoutButton.click();
        }
        if ("Continue shopping".equalsIgnoreCase(givenTitle)) {
            continueShoppingButton.click();
        }
    }


    @Override
    protected String getPageTitleRegex(){
        return CARTPAGE_TITLE_REGEX;
    }

    @Override
    protected String getPath(){
        return PATH;
    }
}
