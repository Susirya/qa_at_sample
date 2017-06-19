package helpers;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BrowserFactory {
    private static final String CHROME_STRING = "chrome";
    private static final String FIREFOX_STRING = "firefox";
    private static final String EDGE_STRING = "edge";
    private static final String IE_STRING = "ie";

    private static final String BROWSER_CONGIG_ERR = "Browser configuration error";
//    private static final String NO_CONFIG_ERR =  "No configuration available for driver";

    private static String projDir = new File(System.getProperty("user.dir")).getAbsolutePath();
    private static String chromeFilePath = projDir + "/src/test/resources/drivers/chromedriver.exe";
    private static String edgeFilePath = projDir + "/src/test/resources/drivers/MicrosoftWebDriver.exe";
    private static String ieFilePath = projDir + "/src/test/resources/drivers/IEDriverServer.exe";

    public static Browser makeBrowser(String browserName) {
        WebDriver driver = null;
        System.out.println(browserName);
        if (FIREFOX_STRING.equals(browserName)) {
            driver = WebDriverProvider.FIREFOX.create();
        } else if (CHROME_STRING.equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", chromeFilePath);
            driver = WebDriverProvider.CHROME.create();
        } else if (EDGE_STRING.equals(browserName)) {
            System.setProperty("webdriver.edge.driver", edgeFilePath);
            driver = WebDriverProvider.EDGE.create();
        } else if (IE_STRING.equals(browserName)) {
            System.setProperty("webdriver.ie.driver", ieFilePath);
            driver = WebDriverProvider.IE.create();
        } else {
            Assert.fail(BROWSER_CONGIG_ERR);
        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        return new Browser(driver);
    }
}
