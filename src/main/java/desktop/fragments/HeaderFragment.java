package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment {
    @FindBy(css = ".js-mainHeader")
    private WebElement rootElement;

    @FindBy(xpath = ".//div[contains(@class,'js-site-logo')]")
    private WebElement siteLogo;

    @FindBy(xpath = ".//ul[contains(@class,'nav__links--account')]")
    private WebElement signInLink;

    @FindBy(className = "site-search")
    private WebElement searchBar;

    @FindBy(id = "js-site-search-input")
    private WebElement inputField;

    @FindBy(xpath = ".//nav[contains(@class,'navigation--bottom')]")
    private WebElement navigationMenu;

    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }

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

    @Override
    protected WebElement getRoot() {
        return rootElement;
    }
}
