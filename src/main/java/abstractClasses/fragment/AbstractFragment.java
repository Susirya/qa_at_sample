package abstractClasses.fragment;

import helpers.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractFragment implements WebElement {
    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

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
