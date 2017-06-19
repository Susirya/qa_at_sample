package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment {

    @FindBy(className = "siteLogo")
    WebElement siteLogo;

    @FindBy(className = "header_link-text")
    WebElement signInLink;

    @FindBy(className = "header_link")
    WebElement signInIcon;

    @FindBy(name = "search_form")
    WebElement searchField;

    @FindBy(className = "navMainList")
    WebElement navigationMenu;

    @FindBy(id = "homepage_slider")
    WebElement bannerSlider;

    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }

    public boolean isSignInIconDisplayed(){
        return signInIcon.isDisplayed();
    }

    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    public boolean isNavigationMenuDisplayed(){
        return navigationMenu.isDisplayed();
    }

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }


}
