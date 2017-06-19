package stepdefs.desktop.checkout;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import desktop.fragments.CheckoutOrderSummaryFragment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CheckoutCommonStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private CheckoutOrderSummaryFragment checkoutOrderSummaryFragment;

    @And("^I have the following final review$")
    public void iHaveTheFollowingFinalReview(DataTable orderTotalsDataTable) {
        Map<String, String> dataMap = orderTotalsDataTable.transpose().asMap(String.class, String.class);
        String givenSubtotal = dataMap.get("Subtotal");
        String givenDelivery = dataMap.get("Delivery");
        String givenTax = dataMap.get("Tax");
        String givenTotal = dataMap.get("Total");
        if (givenSubtotal != null) {
            assertTrue("Subtotal calculated incorrect! Expected: " +
                    givenSubtotal, checkoutOrderSummaryFragment.isOrderSubtotalEqual(givenSubtotal));
        }
        if (givenDelivery != null) {
            assertTrue("Delivery calculated incorrect! Expected: " +
                    givenDelivery, checkoutOrderSummaryFragment.isOrderDeliveryEqual(givenDelivery));
        }
        if (givenTax != null) {
            assertTrue("Taxes calculated incorrect! Expected: " +
                    givenTax, checkoutOrderSummaryFragment.isOrderTaxesEqual(givenTax));
        }
        if (givenTotal != null) {
            assertTrue("Total calculated incorrect! Expected: " +
                    givenTotal, checkoutOrderSummaryFragment.isOrderTotalEqual(givenTotal));
        }
    }

}
