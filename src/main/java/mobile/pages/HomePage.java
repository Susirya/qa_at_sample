package mobile.pages;

import abstractClasses.page.AbstractMobilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractMobilePage {
    private static final String HOMEPAGE_TITLE_REGEX = "Electronics Site | Homepage";

    @FindBy(css = ".js-mobile-logo>a>img")
    private WebElement siteLogo;

    @FindBy(css = "a+div>div[class='banner banner__component--responsive']")
    private WebElement bannerSlider;

    @FindBy(css = ".mobile__nav__row--table-row .nav-items-total")
    private WebElement minicartItemsCount;


    public boolean isSiteLogoDisplayed(){
        return siteLogo.isDisplayed();
    }

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }

    public boolean isItemsCountInMinicartEqualTo(int givenAmount){
        int itemCount = Integer.parseInt(minicartItemsCount.getText());
        return itemCount == givenAmount;
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
