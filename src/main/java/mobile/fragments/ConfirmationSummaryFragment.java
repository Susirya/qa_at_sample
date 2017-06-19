package mobile.fragments;

import abstractClasses.OrderSummaryAssertable;
import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationSummaryFragment extends AbstractFragment implements OrderSummaryAssertable {
    @FindBy(className = "orderTotal")
    private WebElement rootElement;

    @FindBy(xpath = "(.//div[@class='text-right'])[1]")
    private WebElement orderSubtotal;

    @FindBy(xpath = "(.//div[@class='text-right'])[2]")
    private WebElement orderDelivery;

    @FindBy(xpath = "(.//div[@class='totals'])[2]")
    private WebElement orderTotal;

    @Override
    public boolean isOrderSubtotalEqual(String givenSubtotal){
        return givenSubtotal != null && givenSubtotal.equals(orderSubtotal.getText());
    }

    @Override
    public boolean isOrderDeliveryEqual(String givenDelivery) {
        return givenDelivery != null && givenDelivery.equals(orderDelivery.getText());
    }

    @Override
    public boolean isOrderTaxesEqual(String givenSubtotal) {
        return false;
    }

    @Override
    public boolean isOrderTotalEqual(String givenTotal){
        return givenTotal != null && givenTotal.equals(orderTotal.getText());
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
