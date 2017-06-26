package stepdefs.shared.checkout;

import com.google.common.base.Predicate;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import shared.pages.checkout.PaymentBillingAddressPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class PaymentBillingAddressPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private PaymentBillingAddressPage paymentBillingAddressPage;


    @And("^I am redirected to multicheckout payment method page$")
    public void iAmRedirectedToMulticheckoutPaymentMethodPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> paymentBillingAddressPage.isCurrent());
        assertTrue("Landed on incorrect page.", paymentBillingAddressPage.isCurrent());
    }


    @And("^I select to use my delivery address$")
    public void iSelectToUseMyDeliveryAddress() {
        paymentBillingAddressPage.checkUseMyDeliveryAddress();
    }

    @And("^I enter test card data$")
    public void iEnterTestCardData(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        paymentBillingAddressPage.fillMandatoryCardFields(dataMap);
    }

    @And("^I press \"([^\"]*)\" button on payment method page$")
    public void iPressButtonOnPaymentMethodPage(String arg0) {
        paymentBillingAddressPage.clickNextButton();
    }
}
