package com.Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sunWingFlights extends PageObject {

    @FindBy(xpath = "//a[@id='tab-flights']/span[2]")
    private WebElement Flight;

    @FindBy(xpath = "//*[text()='One way']")
    private WebElement OneWay;

    @FindBy(xpath = "//form[@id='search-box-form-flights']/div/div/div[2]/div/i")
    private WebElement DepartingFrom;

    @FindBy(xpath = "//form[@id='search-box-form-flights']/div/div/div[3]/div/i")
    private WebElement GoingTo;

    @FindBy(xpath = "//input[@id='flights_date_dep']")
    private WebElement DepartingOn;

    @FindBy(xpath = "//select[@id='flights_nb_adult']")
    private WebElement Adult;

    @FindBy(xpath = "//select[@id='flights_nb_child']")
    private WebElement Child;

    @FindBy(xpath = "//select[@id='flights_promo-flights-childage1']")
    private WebElement ChildAge;

    @FindBy(xpath = "(//button[@type='submit'])[4]")
    private WebElement Search;



    public sunWingFlights(WebDriver driver) {
        super(driver);
    }

    public void enterFlightInfo(String departingFrom,
                                String goingTo,
                                String departingOn,
                                String adult,
                                String child,
                                String childAge) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        this.Flight.click();
        this.OneWay.click();
        Actions builder = new Actions(driver);
        builder.click(this.DepartingFrom).perform();
        String departingFromString =  "//*[(text()='" + departingFrom + "' or . = '" + departingFrom + "')]";
        WebElement elementFlyFrom = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath( departingFromString )));
        elementFlyFrom.click();
        this.GoingTo.click();
        String goingToString = "//*[(text() = '" + goingTo + "' or . = '" + goingTo + "')]";
        WebElement elementFlyTo = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath( goingToString )));
        elementFlyTo.click();
        this.DepartingOn.click();
        String departingOnString = "//*[(text() = '" + departingOn + "' or . = '" + departingOn + "')]";
        WebElement elementDepDate = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath( departingOnString )));
        elementDepDate.click();
        Select selectAdult = new Select(this.Adult);
        selectAdult.selectByValue(adult);
        Select selectChild = new Select(this.Child);
        selectChild.selectByValue(child);
        Select selectAge = new Select(this.ChildAge);
        selectAge.selectByValue(childAge);
        this.Search.click();

    }
}
