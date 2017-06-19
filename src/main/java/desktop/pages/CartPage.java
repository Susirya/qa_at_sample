package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    private static final String PATH = "cart";
    private static final String CARTPAGE_TITLE_REGEX = "Your Shopping Cart | Electronics Site";


    @FindBy(xpath = "(.//*[text()='Subtotal:']/following::*[contains(@class,'text-right')])[1]")
    private WebElement subtotal;

    @FindBy(xpath = ".//*[text()='Order Total']/following::*[contains(@class,'col-xs-6 cart-totals-right text-right')]")
    private WebElement grandTotal;

    public boolean isSubtotalEquals(Double givenAmount){
        double actualAmmount = Double.parseDouble(subtotal.getText());
        return Double.compare(actualAmmount, givenAmount) == 0;
    }

    public boolean isGrandTotalEquals(Double givenAmount){
        double actualAmmount = Double.parseDouble(grandTotal.getText());
        return Double.compare(actualAmmount, givenAmount) == 0;
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
