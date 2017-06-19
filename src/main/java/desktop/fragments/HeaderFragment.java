package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import helpers.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment {

    @FindBy(className = "header")
    private WebElement root;

    @FindBy(className = "siteLogo")
    private WebElement siteLogo;

    @FindBy(className = "header_link-text")
    private WebElement signInLink;

    @FindBy(className = "header_link")
    private WebElement signInIcon;

    @FindBy(className = "navMainList")
    private WebElement navigationMenu;

    @FindBy(id = "homepage_slider")
    private WebElement bannerSlider;

    @FindBy(className = "site-search")
    private WebElement searchBar;

    @FindBy(id = "js-site-search-input")
    private WebElement inputField;

    @SuppressWarnings("unchecked")
    @Override
    public void init(Browser browser) {
        super.init(browser);
    }

    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }

    public boolean isSignInIconDisplayed(){
        return signInIcon.isDisplayed();
    }

    public boolean isSearchBarDisplayed(){
        return searchBar.isDisplayed();
    }

    public boolean isNavigationMenuDisplayed(){
        return navigationMenu.isDisplayed();
    }

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }

    public void searchProduct(String query){
        inputField.sendKeys(query);
        inputField.submit();
    }

    @Override
    protected Class getFragmentClass(){
        return this.getClass();
    }

    @Override
    protected WebElement getFragmentRoot() {
        return root;
    }
}
