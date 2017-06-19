package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class HomePage extends AbstractPage{

    @FindBy(className = "popup")
    WebElement signupPopup;

    @FindBy(id = "lightBoxClose")
    WebElement popupCloseButton;

    @FindBy(id = "homepage_slider")
    private WebElement bannerSlider;

    public void visit(){
        browser.get(BASE_URL);
        waitGui().until().element(signupPopup).is().visible();
    }

    public void closePopup() {
        if (signupPopup.isDisplayed()){
            popupCloseButton.click();
        }
    }

    public boolean isNavigationMenuDisplayed(){
        return getNavigationMenu().isDisplayed();
    }

    public boolean isBannerDisplayed(){
        return bannerSlider.isDisplayed();
    }
}
