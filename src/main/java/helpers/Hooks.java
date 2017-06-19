package helpers;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {
    public Browser browser;

    @Before
    public void setUp() throws IOException {
        browser = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
    }

    @After
    public void tearDown() throws IOException {
        if (browser != null)
            browser.quit();
    }
}
