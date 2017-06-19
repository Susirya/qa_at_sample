package desktop.pages;

import abstractClasses.page.AbstractPage;
import desktop.fragments.SearchProductItemFragment;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {
    private static final String PATH = "search/";
    private static final String SEARCHPAGE_TITLE_REGEX = "Search (.*)| Electronics Site";

    @FindBy(className = "product__list--item")
    List<SearchProductItemFragment> produсts;

    public int searchResultsQuantityOnPage(){
        return produсts.size();
    }

    public List<SearchProductItemFragment> getProductsWithNamePart(String namePart){
        List<SearchProductItemFragment> result = produсts.stream()
                .filter(product -> product.nameText().contains(namePart))
                .collect(Collectors.toList());
        return result;
    }

    public List<SearchProductItemFragment> getSearchResultProducts(){
        return produсts;
    }




    @Override
    protected String getPageTitleRegex(){
        return SEARCHPAGE_TITLE_REGEX;
    }
}
