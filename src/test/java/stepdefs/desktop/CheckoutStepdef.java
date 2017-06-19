package stepdefs.desktop;

import com.google.common.base.Predicate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import desktop.pages.CartPage;
import desktop.pages.HomePage;
import desktop.pages.ProductDetailsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static java.lang.String.format;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class CheckoutStepdef {
    public static final String RELATIVE_PATH_FORMAT_WITH_PRODUCT_ID = "/p/%s";
    @Drone
    public WebDriver browser;

    @Page
    private HomePage homePage;

    @Page
    private ProductDetailsPage productPage;

    @Page
    private CartPage cartPage;

    @Given("^I select \"(.*?)\" for product \"(.*?)\" ?$")
    public void iSelectForProduct(String givenTitle, String givenId) {
        homePage.visit(format(RELATIVE_PATH_FORMAT_WITH_PRODUCT_ID, givenId));
        waitGui().until((Predicate<WebDriver>) webDriver -> productPage.isCurrent());
        assertTrue(format("Landed incorrect PDP. Expected product id: ", givenId), productPage.isProductIdEquals(givenId));
        productPage.clickButtonWithTitle(givenTitle);
    }

    @And("^I select \"([^\"]*)\" in cart pop-up$")
    public void iSelectInCartPopUp(String givenTitle) {
        productPage.goToCheckoutOnPopup(givenTitle);
    }

    @And("^I am redirected to the cart page$")
    public void iAmRedirectedToTheCartPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> cartPage.isCurrent());
        assertTrue("Failed to land on Cart page.", cartPage.isCurrent());
    }

    @And("^I can view order summary$")
    public void iCanViewOrderSummary(DataTable dataTable) throws Throwable {
        Map<String, Double> dataMap = dataTable.transpose().asMap(String.class, Double.class);
        Double givenSubtotal = dataMap.get("Order Subtotal");
        Double givenGrandTotal = dataMap.get("Order Total");
        assertTrue("Subtotal calculated incorrect! Expected: " + givenSubtotal, cartPage.isSubtotalEquals(givenSubtotal));
        assertTrue("Grandtotal calculated incorrect! Expected: " + givenGrandTotal, cartPage.isGrandTotalEquals(givenGrandTotal));
    }
}
