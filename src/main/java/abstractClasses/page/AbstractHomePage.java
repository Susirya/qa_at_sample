package abstractClasses.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractHomePage extends AbstractPage implements HomePageInterface {
    private static final String HOMEPAGE_TITLE_REGEX = "Electronics Site | Homepage";

    @FindBy(css = "a+div>div[class='banner banner__component--responsive']")
    private WebElement bannerSlider;

    @Override
    public abstract boolean isSiteLogoDisplayed();

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
