package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOrderSummaryFragment extends AbstractFragment {
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






    public boolean isOrderSubtotalEqual(String givenSubtotal){
        return givenSubtotal != null && givenSubtotal.equals(orderSubtotal.getText());
    }

    public boolean isOrderDeliveryEqual(String givenDelivery) {
        return givenDelivery != null && givenDelivery.equals(orderDelivery.getText());
    }

    public boolean isOrderTotalEqual(String givenTotal){
        return givenTotal != null && givenTotal.equals(orderTotal.getText());
    }

    public boolean isOrderTaxesEqual(String givenTaxes){
        String messageText = orderTaxesMessage.getText();
        String orderTaxes = messageText.substring(20, messageText.length()-5).trim();
        return givenTaxes != null && givenTaxes.equals(orderTaxes);
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
