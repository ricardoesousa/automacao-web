package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "",
        glue = {"hooks", "steps"},
        plugin = {"pretty",
                "html:target/cucumber-reports/html-cucumber-reports.html",
                "json:target/json-cucumber-reports/cucumber.json",
                "junit:target/xml-junit/junit.xml"},
        features = {"src/test/resources/features/"})
public class TestRunner { }
