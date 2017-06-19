package stepdefs.mobile.checkout;

import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import mobile.pages.checkout.DeliveryMethodPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class DeliveryMethodPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private DeliveryMethodPage deliveryMethodPage;


    @And("^I am redirected to multicheckout delivery method page$")
    public void iAmRedirectedToMulticheckoutDeliveryMethodPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> deliveryMethodPage.isCurrent());
        assertTrue("Landed on incorrect page.", deliveryMethodPage.isCurrent());
    }

    @And("^I select \"([^\"]*)\" delivery method$")
    public void iSelectDeliveryMethod(String deliveryMethodName) {
        deliveryMethodPage.selectDeliveryMathobByName(deliveryMethodName);
    }

    @And("^I press \"(.*?)\" button on delivery method page$")
    public void iPressButtonOnDeliveryMethodPage(String arg0) {
        deliveryMethodPage.clickNextButton();
    }
}
