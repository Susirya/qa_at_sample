package mobile.fragments;

import abstractClasses.fragment.AbstractFragment;
import abstractClasses.fragment.HeaderFragmentInterface;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class HeaderFragment extends AbstractFragment implements HeaderFragmentInterface {
    @FindBy(css = ".js-mainHeader")
    private WebElement rootElement;

    @FindBy(css = ".js-toggle-sm-navigation")
    private WebElement navOpenMenuButton;

    @FindBy(xpath = ".//div[@class='close-nav']/button")
    private WebElement navCloseMenuButton;

    @FindBy(css = ".userSign")
    private WebElement signInLink;

    @FindBy(css = ".js-toggle-xs-search")
    private WebElement searchButton;

    @FindBy(className = "site-search")
    private WebElement searchBar;

    @FindBy(id = "js-site-search-input")
    private WebElement inputField;

    @FindBy(xpath = ".//nav[contains(@class,'navigation--bottom')]")
    private WebElement navigationMenu;

    @FindBy(css = ".mobile__nav__row--table-row .nav-items-total")
    private WebElement minicartItemsCount;


    public void openMenu() {
        if (!navCloseMenuButton.isDisplayed()) {
            navOpenMenuButton.click();
            waitGui().until().element(signInLink).is().visible();
        }
    }

    public void closeMenu() {
        if (navCloseMenuButton.isDisplayed()) {
            navCloseMenuButton.click();
            waitGui().until().element(signInLink).is().not().visible();
        }
    }

    public void openSearchBar() {
        if (!searchBar.isDisplayed()) {
            searchButton.click();
            waitGui().until().element(searchBar).is().visible();
        }
    }

    public void closeSearchBar() {
        if (searchBar.isDisplayed()) {
            searchButton.click();
            waitGui().until().element(searchBar).is().not().visible();
        }
    }

    public boolean isSignInLinkDisplayed(){
        boolean linkVisible = signInLink.isDisplayed();
        if (!linkVisible) {
            openMenu();
            linkVisible = signInLink.isDisplayed();
            closeMenu();
        }
        return linkVisible;
    }

    public boolean isSearchBarDisplayed(){
        openSearchBar();
        return searchBar.isDisplayed();
    }

    public boolean isNavigationMenuDisplayed(){
        return navigationMenu.isDisplayed();
    }

    public void searchProduct(String query){
        openSearchBar();
        inputField.sendKeys(query);
        inputField.submit();
    }

    public boolean isItemsCountInMinicartEqualTo(int givenAmount){
        int itemCount = Integer.parseInt(minicartItemsCount.getText());
        return itemCount == givenAmount;
    }

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
