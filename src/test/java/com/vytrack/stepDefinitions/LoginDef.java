package com.vytrack.stepDefinitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginDef {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        LoginPage loginPage= new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
        String expectedTitle="Dashboard";
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {
        LoginPage loginPage= new LoginPage();
        loginPage.login(ConfigurationReader.get("sales_manager_username"),ConfigurationReader.get("sales_manager_password"));
    }


    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username= ConfigurationReader.get("store_manager_username");
        String password= ConfigurationReader.get("store_manager_password");
        LoginPage loginPage= new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title should be Dashboard")
    public void the_title_should_be_Dashboard() {
        BrowserUtils.waitFor(3);
        String expectedTitle="Dashboard";
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage= new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String page) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(page));
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage= new LoginPage();
        String username="";
        String password="";
        switch (userType){
            case "driver":
                username= ConfigurationReader.get("driver_username");
                password= ConfigurationReader.get("driver_password");
                break;
            case "store manager":
                username= ConfigurationReader.get("store_manager_username");
                password= ConfigurationReader.get("store_manager_password");
                break;
            case "sales manager":
                username= ConfigurationReader.get("sales_manager_username");
                password= ConfigurationReader.get("sales_manager_password");
                break;
        }
        loginPage.login(username,password);
    }



}
