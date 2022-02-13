package com.vytrack.stepDefinitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDef {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(3);
        System.out.println(menuOptions.size());
        System.out.println("expectedMenuOptions = " + menuOptions);
        //get the list of webElements.convert them to list of string and assert
        List<String> actualMenuOfOptions= BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        System.out.println("actualMenuOptions = " + actualMenuOfOptions);

        Assert.assertEquals(menuOptions,actualMenuOfOptions);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> expectedCredentials) {
        System.out.println(expectedCredentials);
        // login with map info
        new LoginPage().login(expectedCredentials.get("username"), expectedCredentials.get("password"));

        BrowserUtils.waitForPageToLoad(10);
        //verify firstname and lastname
        String expectedFullName= expectedCredentials.get("firstname")+" "+ expectedCredentials.get("lastname");
        System.out.println("expectedFullName = " + expectedFullName);

        String actualFullName= new DashboardPage().getUserName();
        System.out.println("actualFullName = " + actualFullName);

        Assert.assertEquals(expectedFullName,actualFullName);
    }
}
