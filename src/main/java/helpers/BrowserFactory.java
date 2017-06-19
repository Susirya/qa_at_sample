package helpers;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String EDGE = "edge";
    private static final String IE = "ie";
    private static final String FIREFOX_REMOTE = "firefox_r";
    private static final String CHROME_REMOTE = "chrome_r";
    private static final String EDGE_REMOTE = "edge_r";
    private static final String IE_REMOTE = "ie_r";

    private static final String BROWSER_CONGIG_ERR = "Browser configuration error";
    private static final String NO_CONFIG_ERR =  "No configuration available for driver";

    private static final String MAC = "mac";

    private static final String HUB_URL = "selemium.grib.hub.url";

    private static String projDir = new File(System.getProperty("user.dir")).getAbsolutePath();
    private static String chromeFilePath = projDir + "/src/test/resources/chromedriver.exe";
    private static String edgeFilePath = projDir + "/src/test/resources/MicrosoftWebDriver.exe";
    private static String ieFilePath = projDir + "/src/test/resources/IEDriverServer.exe";

    static Browser create(String browser) {
        Browser testDriver = setDefaultConfiguration(browser);
        return testDriver;
    }

    private static Browser setDefaultConfiguration(String browser) {
        WebDriver driver = null;
        DesiredCapabilities capabilities = setDefaultCapabilities(browser);
        String hubURL = PropertyLoader.loadProperty(HUB_URL);
        try {
            if (browser.equals(FIREFOX)) {
                driver = new FirefoxDriver(capabilities);
            } else if (browser.equals(CHROME)) {
                System.setProperty("webdriver.chrome.driver", chromeFilePath);
                driver = new ChromeDriver(capabilities);
            } else if (browser.equals(EDGE)) {
                System.setProperty("webdriver.edge.driver", edgeFilePath);
                driver = new EdgeDriver(capabilities);
            } else if (browser.equals(IE)) {
                System.setProperty("webdriver.ie.driver", ieFilePath);
                driver = new InternetExplorerDriver(capabilities);
            } else if (browser.equals(FIREFOX_REMOTE)) {
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            } else if (browser.equals(CHROME_REMOTE)) {
                capabilities.setCapability("webdriver.chrome.args", Arrays.asList("--whitelisted-ips=''"));
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            } else if (browser.equals(EDGE_REMOTE)) {
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            } else if (browser.equals(IE_REMOTE)) {
                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            } else
                Assert.fail(BROWSER_CONGIG_ERR);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (PropertyLoader.loadProperty("selenium.set.resolution") == "true"){
            setScreenResolution(driver);
        }
        driver.manage().window().maximize();
        return new Browser(driver);
    }

    private static DesiredCapabilities setDefaultCapabilities(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.contains(FIREFOX)) {
            capabilities = DesiredCapabilities.firefox();
        } else
        if (browser.contains(CHROME)){
            capabilities = DesiredCapabilities.chrome();
        } else
        if (browser.contains(EDGE)){
            capabilities = DesiredCapabilities.edge();
        } else
        if (browser.contains(IE)){
            capabilities = DesiredCapabilities.internetExplorer();
        } else
            Assert.fail(NO_CONFIG_ERR);
        capabilities = setPlatform(capabilities,PropertyLoader.loadProperty("platform"));
        return capabilities;
    }

    private static DesiredCapabilities setPlatform(DesiredCapabilities capabilities, String platformName) {
        if (platformName.equals(MAC)) {
            capabilities.setPlatform(Platform.MAC);
        } else {
            capabilities.setPlatform(Platform.WINDOWS);
        }
        return capabilities;
    }

    private static void setScreenResolution(WebDriver driver) {
        int width = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.width"));
        int height = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.height"));
        driver.manage().window().setSize(new Dimension(width, height));
    }
}