package mobile.pages;

import abstractClasses.page.AbstractPage;
import mobile.fragments.AddedToCartPopupFragment;
import mobile.fragments.SearchProductItemFragment;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {
    private static final String PATH = "search/";
    private static final String SEARCHPAGE_TITLE_REGEX = "Search (.*)| Electronics Site";

    @FindBy(className = "product__list--item")
    private List<SearchProductItemFragment> products;

    @FindBy(id = "cboxContent")
    private AddedToCartPopupFragment addedToCartPopupFragment;


    public int searchResultsQuantityOnPage(){
        return products.size();
    }

    public List<SearchProductItemFragment> getProductsWithNamePart(String namePart){
        List<SearchProductItemFragment> result = products.stream()
                .filter(product -> product.nameText().contains(namePart))
                .collect(Collectors.toList());
        return result;
    }

    public List<SearchProductItemFragment> getSearchResultProducts(){
        return products;
    }



    public boolean isAddedToCartPopupFragmentDisplayed(){
        return addedToCartPopupFragment.isDisplayed();
    }

    @Override
    protected String getPageTitleRegex(){
        return SEARCHPAGE_TITLE_REGEX;
    }

    @Override
    protected String getPath() {
        return null;
    }
}
