package stepdefs.desktop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.fragments.HeaderFragment;
import desktop.pages.HomePage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CommonStepdef {
    @Drone
    public WebDriver browser;

    @Page
    private HomePage homePage;

    @Given("^I am an anonymous customer with clear cookies$")
    public void iAmAnAnonymousCustomerWithClearCookies(){
        browser.manage().deleteAllCookies();
    }

    @When("^I am on home page$")
    public void iAmOnHomePage() {
        homePage.visit();
        homePage.closePopup();
    }

    @Then("^On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner$")
    public void onTheHomePageICanViewLogoSignInRegisterIconSearchFieldNavigationMenuBanner() {

        HeaderFragment headerFragment = homePage.getHeaderFragment();
        assertTrue("Logo is not visible", headerFragment.isSiteLogoDisplayed());
        assertTrue("Sign in or Register link is not visible", headerFragment.isSignInLinkDisplayed());
        assertTrue("Sign in or Register icon is not visible", headerFragment.isSignInIconDisplayed());
        assertTrue("Search field is not visible", headerFragment.isSearchBarDisplayed());
        assertTrue("Navigation menu is not visible", homePage.isNavigationMenuDisplayed());
        assertTrue("Banner is not visible", homePage.isBannerDisplayed());
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String query) {
        homePage.getHeaderFragment().searchProduct(query);
    }
}
