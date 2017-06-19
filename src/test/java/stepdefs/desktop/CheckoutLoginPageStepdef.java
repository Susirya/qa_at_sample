package stepdefs.desktop;

import cucumber.api.java.en.And;
import desktop.pages.CheckoutLoginPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class CheckoutLoginPageStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private CheckoutLoginPage checkoutLoginPage;

    @FindBy(id = "guest.email")
    WebElement guestEmailField;

    @FindBy(id = "guest.confirm.email")
    WebElement guestConfirmEmailField;

    @And("^I set \"(.*?)\" as e-mail address$")
    public void iSetAsEMailAddress(String givenEmailAdress) {
        waitGui().until().element(guestEmailField).is().visible();
        guestEmailField.sendKeys(givenEmailAdress);
        guestConfirmEmailField.sendKeys(givenEmailAdress);
    }

    @And("^I proceed to checkout as a Guest user$")
    public void iProceedToCheckoutAsAGuestUser() {
        guestConfirmEmailField.submit();
    }
}
