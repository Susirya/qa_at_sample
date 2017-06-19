package abstractClasses;

public interface OrderSummaryAssertable {
    boolean isOrderSubtotalEqual(String givenSubtotal);
    boolean isOrderDeliveryEqual(String givenSubtotal);
    boolean isOrderTaxesEqual(String givenSubtotal);
    boolean isOrderTotalEqual(String givenSubtotal);
}
