package cucumbertestrunner;

import cucumber.api.CucumberOptions;
import cucumber.runtime.arquillian.ArquillianCucumber;
import org.junit.runner.RunWith;

@RunWith(ArquillianCucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-htmlreport"},
        features = "src/test/resources/features",
        glue = {"stepdefs/mobile","stepdefs/shared"}
)
public class MobileRunnerTest {}
