package com.vytrack.stepDef;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDef {
    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String title) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(title));
    }
}
