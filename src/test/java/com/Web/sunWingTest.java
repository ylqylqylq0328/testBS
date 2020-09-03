package com.Web;

import org.junit.jupiter.api.Test;

public class sunWingTest extends FunctionalTest {

    final String urlInit = "https://www.sunwing.ca/";

    @Test
    public void testSunWingFlight(){
        inputInfo();
    }

    private void inputInfo() {
        driver.get(urlInit);
        driver.manage().window().maximize();
        sunWingFlights sunWingFlightsInfo = new sunWingFlights(driver);
        sunWingFlightsInfo.enterFlightInfo("Montreal (YUL)", "- Miami/Fort Lauderdale, Florida, USA (MIA)" ,"30","1","1","10");
    }
}
