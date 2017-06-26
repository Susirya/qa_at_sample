package stepdefs.mobile;

import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import mobile.pages.HomePage;
import shared.pages.ProductDetailsPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class ProductDetailsPageStepdef {
    public static final String RELATIVE_PATH_FORMAT_WITH_PRODUCT_ID = "/p/%s";

    @Drone
    public WebDriver browser;

    @Page
    private HomePage homePage;

    @Page
    private ProductDetailsPage productPage;

    @Given("^I select \"(.*?)\" for product \"(.*?)\" ?$")
    public void iSelectForProduct(String givenTitle, String givenId) {
        homePage.visit(format(RELATIVE_PATH_FORMAT_WITH_PRODUCT_ID, givenId));
        waitGui().until((Predicate<WebDriver>) webDriver -> productPage.isCurrent());
        assertTrue(format("Landed incorrect PDP. Expected product id: ", givenId), productPage.isProductIdEquals(givenId));
        productPage.clickButtonWithTitle(givenTitle);
    }

    @And("^I select \"(.*?)\" in cart pop-up$")
    public void iSelectInCartPopUp(String givenButtonTitle) {
        productPage.goToCheckoutOnPopup(givenButtonTitle);
    }
}
