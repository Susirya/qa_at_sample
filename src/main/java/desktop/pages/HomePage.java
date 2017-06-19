package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{
    private static final String HOMEPAGE_TITLE_REGEX = "Electronics Site | Homepage";



    @FindBy(css = "a+div>div[class='banner banner__component--responsive']")
    private WebElement bannerSlider;

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }

    @Override
    protected String getPageTitleRegex(){
        return HOMEPAGE_TITLE_REGEX;
    }

    @Override
    protected String getPath(){
        return "";
    }
}
