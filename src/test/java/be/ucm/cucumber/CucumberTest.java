package be.ucm.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        features = "src/test/java/be/ucm/cucumber/features",
        extraGlue = "be.ucm.BL"
        ,tags = "@todo"
)

public class CucumberTest {

}
