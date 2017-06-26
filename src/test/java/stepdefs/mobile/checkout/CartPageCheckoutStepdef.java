package stepdefs.mobile.checkout;

import com.google.common.base.Predicate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import shared.pages.CartPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class CartPageCheckoutStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private CartPage cartPage;

    @And("^I am redirected to the cart page$")
    public void iAmRedirectedToTheCartPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> cartPage.isCurrent());
        assertTrue("Failed to land on Cart page.", cartPage.isCurrent());
    }

    @And("^I can view order summary$")
    public void iCanViewOrderSummary(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.transpose().asMap(String.class, String.class);
        String givenSubtotal = dataMap.get("Order Subtotal");
        String givenGrandTotal = dataMap.get("Order Total");
        assertTrue("Subtotal calculated incorrect! Expected: " + givenSubtotal, cartPage.isSubtotalEquals(givenSubtotal));
        assertTrue("Grandtotal calculated incorrect! Expected: " + givenGrandTotal, cartPage.isGrandTotalEquals(givenGrandTotal));
    }

    @And("^I click \"(.*?)\" button after redirect to cart page$")
    public void iClickButtonAfterRedirectToCartPage(String givenTitle) {
        cartPage.clickButtonWithTitle(givenTitle);
    }
}
