package TestRunner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(ListenerTest.class)
@CucumberOptions(
    features = "Features",
    glue = "StepDefinitions"
//	tags ="@Cart or @Order or @Wishlist or HeaderMenu or @LeftMenu or Search"
//	tags = "@HeaderMenu"
)
public class TestRunner extends AbstractTestNGCucumberTests {}
