package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

    @FindBy(css = "a+div>div[class='banner banner__component--responsive']")
    private WebElement bannerSlider;

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }
}
