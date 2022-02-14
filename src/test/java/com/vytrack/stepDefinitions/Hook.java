package com.vytrack.stepDefinitions;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setUp(){
    System.out.println("BEFORE METHOD..");
    Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.waitFor(1);
        if(scenario.isFailed()){
            final  byte[] screenshot= ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");

    }
}
