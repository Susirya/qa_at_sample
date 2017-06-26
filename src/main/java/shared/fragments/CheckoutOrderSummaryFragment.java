package shared.fragments;

import abstractClasses.OrderSummaryAssertable;
import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOrderSummaryFragment extends AbstractFragment implements OrderSummaryAssertable {
    @FindBy(className = "checkout-order-summary")
    private WebElement rootElement;

    @FindBy(xpath = ".//div[@class='subtotal']/span")
    private WebElement orderSubtotal;

    @FindBy(xpath = ".//div[@class='totals']/span")
    private WebElement orderTotal;

    @FindBy(xpath = ".//div[@class='shipping']/span")
    private WebElement orderDelivery;

    @FindBy(className = "realTotals")
    private WebElement orderTaxesMessage;


    @Override
    public String getOrderSubtotalText() {
        return orderSubtotal.getText();
    }

    @Override
    public String getOrderTotalText() {
        return orderTotal.getText();
    }

    @Override
    public String getOrderDeliveryText() {
        return orderDelivery.getText();
    }

    @Override
    public String getOrderTaxesText() {
        String messageText = orderTaxesMessage.getText();
        return messageText.substring(20, messageText.length()-5).trim();
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
