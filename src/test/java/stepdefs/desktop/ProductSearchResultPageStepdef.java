package stepdefs.desktop;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import desktop.fragments.SearchProductItemFragment;
import desktop.pages.SearchResultPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSearchResultPageStepdef {

    @Drone
    private WebDriver browser;

    @Page
    private SearchResultPage searchResultsPage;

    @Given("^I am redirected to a Search page$")
    public void I_am_redirected_to_a_Search_page_() {
        assertTrue("Landed on incorrect page: " + searchResultsPage.actualTitle(), searchResultsPage.isCurrent());
    }

    @When("^I find (\\d+) products with name \"([^\"]*)\"$")
    public void iFindProductsWithName(int expectedQantity, String productNamePart) {
        List<SearchProductItemFragment> productsWithNameContaining = searchResultsPage.getProductsWithNamePart(productNamePart);
        assertEquals(expectedQantity, productsWithNameContaining.size());
    }


    @Then("^all product contains image, price, button \"([^\"]*)\"$")
    public void allProductContainsImagePriceButton(String arg0) {
        List<SearchProductItemFragment> searchResultProducts = searchResultsPage.getSearchResultProducts();
        searchResultProducts.forEach(product -> {
            assertTrue(product.getName() + " is missing the thumbnail pic.", product.getThumbPicture().isDisplayed());
            assertTrue(product.getName() + " is missing the price.", product.getPrice().isDisplayed());
            assertTrue(product.getName() + " is missing the 'Add to Cart' button", product.getAddToCartButton().isDisplayed());
        });
    }
}

