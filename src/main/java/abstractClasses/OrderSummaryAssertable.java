package abstractClasses;

public interface OrderSummaryAssertable {
    boolean isOrderSubtotalEqual(String givenSubtotal);
    boolean isOrderDeliveryEqual(String givenSubtotal);
    default boolean isOrderTaxesEqual(String givenSubtotal){
        return false;
    }
    boolean isOrderTotalEqual(String givenSubtotal);
}
