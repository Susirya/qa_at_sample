package stepdefs.desktop;

import com.google.common.base.Predicate;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shared.fragments.SearchProductItemFragment;
import shared.pages.ProductDetailsPage;
import shared.pages.SearchResultPage;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSearchResultPageStepdef {

    @Drone
    private WebDriver browser;

    @Page
    private SearchResultPage searchResultsPage;

    @Page
    private ProductDetailsPage productDetailsPage;

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
    public void allProductContainsImagePriceButton(String buttonText) {
        List<SearchProductItemFragment> searchResultProducts = searchResultsPage.getSearchResultProducts();
        searchResultProducts.forEach(product -> {
            assertTrue(product.getName() + " is missing the thumbnail pic.", product.getThumbPicture().isDisplayed());
            assertTrue(product.getName() + " is missing the price.", product.getPrice().isDisplayed());
            assertTrue(product.getName() + " is missing the 'Add to Cart' button", product.getAddToCartButton().isDisplayed());
        });
    }

    @When("^click \"([^\"]*)\" button for product \"([^\"]*)\"$")
    public void clickButtonForProduct(String buttonText, String givenProductName) {
        SearchProductItemFragment product = getProductFragmentByProductName(givenProductName);
        product.getAddToCartButton().click();
    }

    private SearchProductItemFragment getProductFragmentByProductName(String name) {
        List<SearchProductItemFragment> searchResultProducts = searchResultsPage.getSearchResultProducts();
        return searchResultProducts.stream()
                .filter(pr -> name.equalsIgnoreCase(pr.nameText()))
                .findFirst().get();
    }

    @Then("^add to cart confirmation pop-up appears$")
    public void addToCartConfirmationPopUpAppears() {
        assertTrue("Add to cart confirmation pop up doesn't appear!", searchResultsPage.isAddedToCartPopupFragmentDisplayed());
    }

    @When("^click on product \"([^\"]*)\" on search result page$")
    public void clickOnProductOnSearchResultPage(String givenProductName) {
        SearchProductItemFragment product = getProductFragmentByProductName(givenProductName);
        product.getThumbPicture().click();
        waitGui().until((Predicate<WebDriver>) webDriver -> productDetailsPage.isCurrent());
    }

    @Then("^I am redirected on product details page$")
    public void iAmRedirectedOnProductDetailsPage() {
        productDetailsPage.isCurrent();
    }
}

