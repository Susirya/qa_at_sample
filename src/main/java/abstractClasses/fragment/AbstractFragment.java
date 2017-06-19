package abstractClasses.fragment;

import helpers.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractFragment {
    protected WebDriver browser;

    @SuppressWarnings("unchecked")
    public void init (Browser browser){
        this.browser = browser;
        PageFactory.initElements(browser, (Class) getFragmentClass());
    }

    protected abstract Class getFragmentClass();
    protected abstract WebElement getFragmentRoot();

    public boolean isDisplayed(){
        return getFragmentRoot().isDisplayed();
    }


}
