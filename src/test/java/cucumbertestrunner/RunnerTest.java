package cucumbertestrunner;

import cucumber.api.CucumberOptions;
import cucumber.runtime.arquillian.ArquillianCucumber;
import org.junit.runner.RunWith;


//@Features("none/cukes-in-belly.feature:3")
//@Glues({CommonStepdef.class, Hooks.class, })
@RunWith(ArquillianCucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-htmlreport"},
        features = "src/test/resources/features",
        glue = "stepdefs"
)
public class RunnerTest {

}
