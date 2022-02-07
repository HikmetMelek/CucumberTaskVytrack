package com.vytrack.stepDef;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setUp(){
    System.out.println("before method");
    Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown(){
        BrowserUtils.waitFor(1);
        Driver.closeDriver();
    }
}
