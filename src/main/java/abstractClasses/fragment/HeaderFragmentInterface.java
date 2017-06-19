package abstractClasses.fragment;

public interface HeaderFragmentInterface {
    boolean isSignInLinkDisplayed();
    boolean isSearchBarDisplayed();
    boolean isNavigationMenuDisplayed();
    void searchProduct(String query);
    boolean isItemsCountInMinicartEqualTo(int givenAmount);
}
