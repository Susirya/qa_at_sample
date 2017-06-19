package desktop.pages;

import abstractClasses.page.AbstractDesktopPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractDesktopPage {
    private static final String HOMEPAGE_TITLE_REGEX = "Electronics Site | Homepage";

    @FindBy(css = "a+div>div[class='banner banner__component--responsive']")
    private WebElement bannerSlider;

    @FindBy(css = ".desktop__nav .nav-items-total")
    private WebElement minicartItemsCount;

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }

    public boolean isItemsCountInMinicartEqualTo(int givenAmount){
        String itemCountText = minicartItemsCount.getText();
        int itemCount = Integer.parseInt(itemCountText.substring(0, itemCountText.length() - 6));
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
