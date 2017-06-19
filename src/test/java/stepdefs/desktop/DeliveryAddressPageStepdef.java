package stepdefs.desktop;

import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import desktop.pages.DeliveryAddressPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

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
        assertTrue(deliveryAddressPage.isCurrent());
    }
}
