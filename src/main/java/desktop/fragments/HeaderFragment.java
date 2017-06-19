package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment {

    @FindBy(className = "siteLogo")
    private WebElement siteLogo;

    @FindBy(className = "header_link-text")
    private WebElement signInLink;

    @FindBy(className = "header_link")
    private WebElement signInIcon;

//  DemoLab
//    @FindBy(className = "site-search")
//  WX - TP
    @FindBy(className = "search")
    private WebElement searchBar;

    @FindBy(id = "js-site-search-input")
    private WebElement inputField;

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

    public void searchProduct(String query){
        inputField.sendKeys(query);
        inputField.submit();
    }
}
