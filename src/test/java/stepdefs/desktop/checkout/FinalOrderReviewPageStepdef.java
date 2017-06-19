package stepdefs.desktop.checkout;

import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import desktop.pages.checkout.FinalOrderReviewPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class FinalOrderReviewPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private FinalOrderReviewPage finalOrderReviewPage;


    @And("^I am redirected to WorldPay page$")
    public void iAmRedirectedToWorldPayPage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> finalOrderReviewPage.isCurrent());
        assertTrue("Landed on incorrect page.", finalOrderReviewPage.isCurrent());
    }


    @And("^I agree with terms and conditions$")
    public void iAgreeWithTermsAndConditions() {
        finalOrderReviewPage.checkAgreeWithTermsAndConditions();
    }

    @And("^I click Make payment button$")
    public void iClickMakePaymentButton() {
        finalOrderReviewPage.clickPlaceOrdeButton();
    }
}
