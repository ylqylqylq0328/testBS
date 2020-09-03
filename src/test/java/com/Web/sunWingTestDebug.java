package com.Web;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sunWingTestDebug extends FunctionalTest{

    final String urlInit = "https://www.sunwing.ca/";

    /*
    Only for Debugging.
     */
    @Test
    @Disabled
    public void testSunWingDebug() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get(urlInit);
        driver.manage().window().maximize();
        //Flight
        driver.findElement(By.xpath("//a[@id='tab-flights']/span[2]")).click();
        //One Way
        driver.findElement(By.xpath("//*[text()='One way']")).click();
        //Depart From
        Actions builder = new Actions(driver);
        builder.click(driver.findElement(By.xpath("//form[@id='search-box-form-flights']/div/div/div[2]/div/i"))).perform();
        WebElement elementFlyFrom = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(text() = 'Montreal (YUL)' or . = 'Montreal (YUL)')]")));
        elementFlyFrom.click();
        //Going To
        driver.findElement(By.xpath("//form[@id='search-box-form-flights']/div/div/div[3]/div/i")).click();

        WebElement elementFlyTo = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(text() = '- Miami/Fort Lauderdale, Florida, USA (MIA)' or . = '- Miami/Fort Lauderdale, Florida, USA (MIA)')]")));
        elementFlyTo.click();
        //Departing on
        driver.findElement(By.xpath("//input[@id='flights_date_dep']")).click();
        WebElement elementDepDate = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(text() = '30' or . = '30')]")));
        elementDepDate.click();
        //1 Adult
        Select selectAdult = new Select(driver.findElement(By.xpath("//select[@id='flights_nb_adult']")));
        selectAdult.selectByValue("1");
        //1 Child
        Select selectChild = new Select(driver.findElement(By.xpath("//select[@id='flights_nb_child']")));
        selectChild.selectByValue("1");
        //Child Age 10
        Select selectAge = new Select(driver.findElement(By.xpath("//select[@id='flights_promo-flights-childage1']")));
        selectAge.selectByValue("10");
        //Search
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();

        //Search List No 2
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("//div[@id='content']/form/div/div/div[2]/label[2]")).click();

        //Commit
        //driver.findElement(By.xpath("//input[@name='1b_select_flight_submit']")).click();

        //Regular Class
        //driver.findElement(By.xpath("//input[@id='package1price1']")).click();

        //Continue
        //input[@name='package1_submit']

        //Continue to Payment
        //section[@id='booking_summary_container']/div[3]/button

        //ADULT Info
        //input[@id='FIRST_NAME1']
        //input[@id='LAST_NAME1']
        //select[@id='dob1month']
        //select[@id='dob1day']
        //select[@id='dob1year']

        //Child Info
        //input[@id='FIRST_NAME2']
        //input[@id='LAST_NAME2']
        //select[@id='dob2month']
        //select[@id='dob2day']
        //select[@id='dob2year']

    }

}
