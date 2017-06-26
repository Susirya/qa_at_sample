package stepdefs.shared.checkout;

import com.google.common.base.Predicate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import shared.pages.checkout.ConfirmationPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;
import stepdefs.shared.checkout.Utils;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class ConfirmationPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private ConfirmationPage confirmationPage;

    @Then("^I am redirected to checkout confirmation page$")
    public void iAmRedirectedToCheckoutConfirmationPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> confirmationPage.isCurrent());
        assertTrue("Landed on incorrect page.", confirmationPage.isCurrent());
    }

    @And("^I have the following final review at order confirmation page$")
    public void iHaveTheFollowingFinalReviewAtOrderConfirmationPage(DataTable dataTable) {
        Utils.assertAllTotalsOnOrderSummaryFragment(dataTable, confirmationPage.getTotalsFragment());
    }

    @And("^checkout message is \"([^\"]*)\"$")
    public void checkoutMessageIs(String givenMessage) {
        assertTrue("Incorrect confirmation message!", confirmationPage.isConfirmationmessageEqual(givenMessage));
    }

    @And("^I can obtain an order number$")
    public void iCanObtainAnOrderNumber() {
        assertTrue("Order number is not visible!", confirmationPage.isOrderNumberVisible());
    }

    @And("^I press \"([^\"]*)\" button on checkout confirmation page$")
    public void iPressButtonOnCheckoutConfirmationPage(String arg0) throws Throwable {
        confirmationPage.clickContinueShoppingButton();
    }
}
