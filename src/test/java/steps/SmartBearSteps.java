package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SmartBearHomePage;
import pages.SmartBearLoginPage;
import utils.Driver;
import utils.Waiter;


public class SmartBearSteps {


    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearHomePage smartBearHomePage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearHomePage = new SmartBearHomePage();
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        smartBearLoginPage.username.click();
        smartBearLoginPage.username.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void user_enters_password_as(String password) {
        smartBearLoginPage.password.click();
        smartBearLoginPage.password.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearLoginPage.submitButton.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String errorMessage) {
       Assert.assertEquals(errorMessage,smartBearLoginPage.credentialError.getText());
    }

    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }




    @And("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertEquals(dataTable.asList().get(i), smartBearHomePage.menuBar.get(i).getText());
        }
    }




}
