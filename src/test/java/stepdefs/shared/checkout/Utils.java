package stepdefs.shared.checkout;

import abstractClasses.OrderSummaryAssertable;
import cucumber.api.DataTable;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Utils {

    private static final String SUBTOTAL_MESSAGE = "Subtotal calculated incorrect! Expected: %s but was: %s";
    private static final String DELIVERY_MESSAGE = "Delivery calculated incorrect! Expected: %s but was: %s";
    private static final String TOTAL_MESSAGE = "Total calculated incorrect! Expected: %s but was: %s";
    private static final String TAXES_MESSAGE = "Taxes calculated incorrect! Expected: %s but was: %s";

    public static void assertAllTotalsOnOrderSummaryFragment(DataTable orderTotalsDataTable, OrderSummaryAssertable totalsFragment) {
        Map<String, String> dataMap = orderTotalsDataTable.transpose().asMap(String.class, String.class);
        String expectedSubtotal = dataMap.get("Subtotal");
        String expectedDelivery = dataMap.get("Delivery");
        String expectedTaxes = dataMap.get("Tax");
        String expectedTotal = dataMap.get("Total");
        if (expectedSubtotal != null) {
            String actualSubtotal = totalsFragment.getOrderSubtotalText();
            assertEquals(String.format(SUBTOTAL_MESSAGE, expectedSubtotal, actualSubtotal), expectedSubtotal, actualSubtotal);
        }
        if (expectedDelivery != null) {
            String actualDelivery = totalsFragment.getOrderDeliveryText();
            assertEquals(String.format(DELIVERY_MESSAGE, expectedDelivery, actualDelivery), expectedDelivery, actualDelivery);
        }
        if (expectedTaxes != null) {
            String actualTaxes = totalsFragment.getOrderTaxesText();
            assertEquals(String.format(TAXES_MESSAGE, expectedTaxes, actualTaxes), expectedTaxes, actualTaxes);
        }
        if (expectedTotal != null) {
            String actualTotal = totalsFragment.getOrderTotalText();
            assertEquals(String.format(TOTAL_MESSAGE, expectedTotal, actualTotal), expectedTotal, actualTotal);
        }
    }

}
