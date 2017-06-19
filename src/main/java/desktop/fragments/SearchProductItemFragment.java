package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductItemFragment extends AbstractFragment {

    @FindBy(className = "search")
    private WebElement root;




    @Override
    protected Class getFragmentClass(){
        return this.getClass();
    }

    @Override
    protected WebElement getFragmentRoot() {
        return root;
    }
}
