package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public enum WebDriverProvider {
    CHROME {
        @Override
        public WebDriver create(boolean isPrivateModeRequired) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            if (isPrivateModeRequired) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("incognito");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            }
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_BINARY_PATH_STRING);
            return new ChromeDriver(capabilities);
        }

        @Override
        public WebDriver create() {
            return create(false);
        }
    },
    FIREFOX {
        @Override
        public WebDriver create(boolean isPrivateModeRequired) {
            WebDriver driver;
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            if (isPrivateModeRequired) {
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
                driver = new FirefoxDriver(firefoxProfile);
            } else {
                driver = new FirefoxDriver(capabilities);
            }
            return driver;
        }

        @Override
        public WebDriver create() {
            return create(false);
        }
    },
    EDGE {
        @Override
        public WebDriver create(boolean isPrivateModeRequired) {
            WebDriver driver;
            DesiredCapabilities capabilities = DesiredCapabilities.edge();
            if (isPrivateModeRequired) {
                // Not implemented
            }
            System.setProperty("webdriver.chrome.driver", EDGE_DRIVER_BINARY_PATH_STRING);
            return new EdgeDriver(capabilities);
        }

        @Override
        public WebDriver create() {
            return create(false);
        }
    },
    IE {
        @Override
        public WebDriver create(boolean isPrivateModeRequired) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            if (isPrivateModeRequired) {
                capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            }
            System.setProperty("webdriver.ie.driver", IEDRIVER_BINARY_PATH_STRING);
            return new InternetExplorerDriver(capabilities);
        }

        @Override
        public WebDriver create() {
            return create(false);
        }
    };


    private static String projDir = new File(System.getProperty("user.dir")).getAbsolutePath();
    public static final String CHROME_DRIVER_BINARY_PATH_STRING = projDir + "/src/test/resources/drivers/chromedriver.exe";
    public static final String EDGE_DRIVER_BINARY_PATH_STRING = "/src/test/resources/drivers/MicrosoftWebDriver.exe";
    public static final String IEDRIVER_BINARY_PATH_STRING = "/src/test/resources/drivers/IEDriverServer.exe";

    public abstract WebDriver create(boolean isPrivateModeRequired);

    public abstract WebDriver create();

    private static void setScreenResolution(WebDriver driver) {
        int width = Integer.parseInt(PropertyLoader.getInstanse().getPropertyValue("selenium.screen.width"));
        int height = Integer.parseInt(PropertyLoader.getInstanse().getPropertyValue("selenium.screen.height"));
        driver.manage().window().setSize(new Dimension(width, height));
    }

}
