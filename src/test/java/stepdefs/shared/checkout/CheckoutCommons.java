package stepdefs.shared.checkout;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import shared.pages.checkout.DeliveryAddressPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;
import shared.fragments.CheckoutOrderSummaryFragment;

public class CheckoutCommons {
    @Drone
    public WebDriver browser;

    @Page
    private CheckoutOrderSummaryFragment checkoutOrderSummaryFragment;

    @Page
    private DeliveryAddressPage deliveryAddressPage;

    @And("^I have the following final review$")
    public void iHaveTheFollowingFinalReview(DataTable orderTotalsDataTable) {
        if (deliveryAddressPage.isCurrent()) {
            Utils.assertAllTotalsOnOrderSummaryFragment(orderTotalsDataTable, deliveryAddressPage.getTotalsFragment());
        }
    }

}
