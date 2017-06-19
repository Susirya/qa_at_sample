package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import abstractClasses.fragment.HeaderFragmentInterface;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment implements HeaderFragmentInterface {
    @FindBy(css = ".js-mainHeader")
    private WebElement rootElement;

    @FindBy(xpath = ".//ul[contains(@class,'nav__links--account')]")
    private WebElement signInLink;

    @FindBy(className = "site-search")
    private WebElement searchBar;

    @FindBy(id = "js-site-search-input")
    private WebElement inputField;

    @FindBy(xpath = ".//nav[contains(@class,'navigation--bottom')]")
    private WebElement navigationMenu;

    @FindBy(css = ".desktop__nav .nav-items-total")
    private WebElement minicartItemsCount;

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }

    public boolean isSearchBarDisplayed(){
        return searchBar.isDisplayed();
    }

    public boolean isNavigationMenuDisplayed(){
        return navigationMenu.isDisplayed();
    }

    public void searchProduct(String query){
        inputField.sendKeys(query);
        inputField.submit();
    }

    public boolean isItemsCountInMinicartEqualTo(int givenAmount){
        String itemCountText = minicartItemsCount.getText();
        int itemCount = Integer.parseInt(itemCountText.substring(0, itemCountText.length() - 6));
        return itemCount == givenAmount;
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
