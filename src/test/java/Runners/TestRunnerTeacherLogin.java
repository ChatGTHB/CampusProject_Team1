package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/TeacherLogin.feature"},
        glue = {"StepDefinitions"}
)

public class TestRunnerTeacherLogin extends AbstractTestNGCucumberTests{
}
