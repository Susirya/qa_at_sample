package stepdefs.shared.checkout;

import abstractClasses.OrderSummaryAssertable;
import cucumber.api.DataTable;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Utils {

    public static void assertAllTotalsOnOrderSummaryFragment(DataTable orderTotalsDataTable, OrderSummaryAssertable totalsFragment) {
        Map<String, String> dataMap = orderTotalsDataTable.transpose().asMap(String.class, String.class);
        String givenSubtotal = dataMap.get("Subtotal");
        String givenDelivery = dataMap.get("Delivery");
        String givenTax = dataMap.get("Tax");
        String givenTotal = dataMap.get("Total");
        if (givenSubtotal != null) {
            assertTrue("Subtotal calculated incorrect! Expected: " +
                    givenSubtotal, totalsFragment.isOrderSubtotalEqual(givenSubtotal));
        }
        if (givenDelivery != null) {
            assertTrue("Delivery calculated incorrect! Expected: " +
                    givenDelivery, totalsFragment.isOrderDeliveryEqual(givenDelivery));
        }
        if (givenTax != null) {
            assertTrue("Taxes calculated incorrect! Expected: " +
                    givenTax, totalsFragment.isOrderTaxesEqual(givenTax));
        }
        if (givenTotal != null) {
            assertTrue("Total calculated incorrect! Expected: " +
                    givenTotal, totalsFragment.isOrderTotalEqual(givenTotal));
        }
    }

}
