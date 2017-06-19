package desktop.pages;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    private static final By PRODUCT_LIST_ITEMS = By.className("product__list--item");

    @FindBy(className = "product__list--wrapper")
    WebElement productList;


    public int searchResultsQuantityOnPage(){
        return getProductsItemList().size();
    }

    public List<WebElement> getProductsWithNameContaining (String namePart){
        return productList.findElements(By.partialLinkText(namePart));
    }






    private List<WebElement> getProductsItemList() {
        return productList.findElements(PRODUCT_LIST_ITEMS);
    }
}
