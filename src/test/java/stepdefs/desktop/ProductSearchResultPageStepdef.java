package stepdefs.desktop;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.pages.SearchResultPage;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductSearchResultPageStepdef {
    private SearchResultPage searchResultsPage;

    @Given("^I am redirected to a Search page$")
    public void I_am_redirected_to_a_Search_page_() throws Throwable  {
        searchResultsPage = new SearchResultPage(Hooks.getBrowser());
    }

    @When("^I find (\\d+) products with name \"([^\"]*)\"$")
    public void iFindProductsWithName(int expectedQantity, String productNamePart) {
        List<WebElement> productsWithNameContaining = searchResultsPage.getProductsWithNameContaining(productNamePart);
        assertEquals(expectedQantity, productsWithNameContaining.size());
    }


    @Then("^all product contains image, price, button \"([^\"]*)\"$")
    public void allProductContainsImagePriceButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
