package com.utitlity;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import com.shoppingonline.pom.POMElements;

public class DriverLib {

    static WebDriver driver;

    public WebDriver getWebDriver() {
        if (driver == null) {
            driver = startWebDriver();
        }

        return driver;
    }

    private WebDriver startWebDriver() {
        WebDriver driver;
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(POMElements.URL);
        return driver;
    }
}