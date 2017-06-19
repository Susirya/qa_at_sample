package stepdefs.desktop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.fragments.HeaderFragment;
import desktop.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class CommonStepdef {
    private HomePage homePage;

    @Given("^I am an anonymous customer with clear cookies$")
    public void iAmAnAnonymousCustomerWithClearCookies(){
        Hooks.getBrowser().clearCookies();
    }

    @When("^I am on home page$")
    public void iAmOnHomePage() throws Throwable {
        homePage = new HomePage(Hooks.getBrowser());
        homePage.visit();
    }

    @Then("^On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner$")
    public void onTheHomePageICanViewLogoSignInRegisterIconSearchFieldNavigationMenuBanner() throws Throwable {
        HeaderFragment headerFragment = homePage.getHeaderFragment();
        assertTrue("Logo is not visible", headerFragment.isSiteLogoDisplayed());
        assertTrue("Sign in or Register link is not visible", headerFragment.isSignInLinkDisplayed());
        assertTrue("Sign in or Register icon is not visible", headerFragment.isSignInIconDisplayed());
        assertTrue("Search field is not visible", headerFragment.isSearchFieldDisplayed());
        assertTrue("Navigation menu is not visible", headerFragment.isNavigationMenuDisplayed());
        assertTrue("Banner is not visible", headerFragment.isBannerDisplayed());
    }
}
