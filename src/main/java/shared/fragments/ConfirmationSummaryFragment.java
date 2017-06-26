package shared.fragments;

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
        return "";
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
