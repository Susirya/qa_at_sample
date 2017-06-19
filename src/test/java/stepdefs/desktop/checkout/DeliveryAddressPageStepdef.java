package stepdefs.desktop.checkout;

import com.google.common.base.Predicate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import desktop.pages.checkout.DeliveryAddressPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class DeliveryAddressPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private DeliveryAddressPage deliveryAddressPage;

    @And("^I am redirected to multicheckout delivery address page$")
    public void iAmRedirectedToMulticheckoutDeliveryAddressPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> deliveryAddressPage.isCurrent());
        assertTrue("Landed on incorrect page.", deliveryAddressPage.isCurrent());
    }

    @And("^I have the following final review$")
    public void iHaveTheFollowingFinalReview(DataTable orderTotalsDataTable) {
        CheckoutCommons.assertAllTotalsOnOrderSummaryFragment(orderTotalsDataTable, deliveryAddressPage.getTotalsFragment());
    }

    @And("^I fill in delivery address information$")
    public void iFillInDeliveryAddressInformation(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.transpose().asMap(String.class, String.class);
        deliveryAddressPage.fillMandatoryAddressFields(dataMap);
    }

    @When("^I press \"(.*?)\" button on delivery address page$")
    public void iPressButtonOnDeliveryAddressPage(String arg0) {
        deliveryAddressPage.clickNextButton();
    }
}
