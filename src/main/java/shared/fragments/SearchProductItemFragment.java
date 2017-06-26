package shared.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductItemFragment extends AbstractFragment {

    @FindBy(xpath = ".//*[@class = 'product__list--thumb']")
    private WebElement thumbPicture;

    @FindBy(xpath = ".//*[@class = 'product__list--name']")
    private WebElement name;

    @FindBy(xpath = ".//*[@class = 'product__list--price-panel']")
    private WebElement price;

    @FindBy(xpath = ".//*[@class = 'product__listing--description']")
    private WebElement description;

    @FindBy(xpath = ".//*[@class = 'SearchResultsList-ListPickUpInStoreAction']")
    private WebElement pickUpInStoreButton;

    @FindBy(xpath = ".//*[@class = 'SearchResultsList-ListAddToCartAction']")
    private WebElement addToCartButton;

    public WebElement getThumbPicture() {
        return thumbPicture;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getPickUpInStoreButton() {
        return pickUpInStoreButton;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    @Override
    protected WebElement getRoot() {
        return null;
    }

    public String nameText() {
        return name.getText();
    }

    public Double priceValue() {
        return Double.parseDouble(price.getText());
    }

    public String descriptionText() {
        return description.getText();
    }
}
