package mobile.pages;

import abstractClasses.page.AbstractHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractHomePage {

    @FindBy(css = ".js-mobile-logo>a>img")
    private WebElement siteLogo;

    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }
}
