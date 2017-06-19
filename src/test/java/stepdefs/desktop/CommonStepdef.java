package stepdefs.desktop;

import abstractClasses.fragment.HeaderFragmentInterface;
import com.google.common.base.Predicate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.pages.HomePage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertTrue;

public class CommonStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private HomePage homePage;

    @Given("^I am an anonymous customer with clear cookies$")
    public void iAmAnAnonymousCustomerWithClearCookies() {
        browser.manage().deleteAllCookies();
    }

    @When("^I am on home page$")
    public void iAmOnHomePage() {
        homePage.visit();
        assertTrue("Landed on incorrect page.", homePage.isCurrent());
    }

    @Then("^On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner$")
    public void onTheHomePageICanViewLogoSignInRegisterIconSearchFieldNavigationMenuBanner() {
        HeaderFragmentInterface headerFragment = homePage.getHeaderFragment();
        assertTrue("Logo is not visible.", homePage.isSiteLogoDisplayed());
        assertTrue("Sign in or Register link is not visible.", headerFragment.isSignInLinkDisplayed());
        assertTrue("Search field is not visible.", headerFragment.isSearchBarDisplayed());
        assertTrue("Navigation menu is not visible.", headerFragment.isNavigationMenuDisplayed());
        assertTrue("Banner is not visible.", homePage.isBannerDisplayed());
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String query) {
        homePage.getHeaderFragment().searchProduct(query);
    }

    @And("^I am redirected to the home page$")
    public void iAmRedirectedToTheHomePage() {
        waitGui().until((Predicate<WebDriver>) webDriver -> homePage.isCurrent());
        assertTrue("Landed on incorrect page.", homePage.isCurrent());
    }

    @And("^mini cart icon on home page shows (\\d+) items in cart$")
    public void miniCartIconOnHomePageShowsItemsInCart(int expectedAmount) {
        assertTrue("Product quantitty in minicart is incorrect! Expected " +
                expectedAmount, homePage.getHeaderFragment().isItemsCountInMinicartEqualTo(expectedAmount));

    }
}
