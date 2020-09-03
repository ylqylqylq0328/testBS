package com.Web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        //WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    public void setUp(){

        //driver = new ChromeDriver();
        driver = new EdgeDriver();

    }

    @AfterEach
    public void cleanUp(){

        //driver.close();
    }

}
