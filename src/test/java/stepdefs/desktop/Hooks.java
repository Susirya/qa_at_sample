package stepdefs.desktop;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.Browser;
import helpers.BrowserFactory;
import helpers.PropertyLoader;

public class Hooks {
    private static final String BROWSER_NAME_PROPERTY_KEY = "browser.name";
    private static Browser browser;

    @Before
    public static void setUp() {
        String browserName = PropertyLoader.getInstanse().getPropertyValue(BROWSER_NAME_PROPERTY_KEY);
        browser = BrowserFactory.makeBrowser(browserName);
        browser.manage().window().maximize();
    }

    @After
    public static void tearDown() {
        if (browser != null)
            browser.quit();
    }

    public static Browser getBrowser() {
        if (browser == null) {
            setUp();
        }

        return browser;
    }
}
