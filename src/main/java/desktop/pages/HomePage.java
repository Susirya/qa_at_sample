package desktop.pages;

import abstractClasses.page.AbstractHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractHomePage {

    @FindBy(xpath = ".//div[contains(@class,'js-site-logo')]")
    private WebElement siteLogo;

    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }
}
