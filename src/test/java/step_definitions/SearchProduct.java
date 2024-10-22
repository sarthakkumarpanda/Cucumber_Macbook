package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProduct {

    public WebDriver driver;


    @Given("User opens the application")
    public void user_opens_the_application() {
        driver = DriverFactory.getDriver();
        Assert.assertTrue(driver.findElement(By.name("search")).isEnabled());
    }

    @When("User enters valid product {string}")
    public void user_enters_valid_product(String validProduct) {
        driver.findElement(By.name("search")).sendKeys(validProduct);
    }

    @And("User clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
    }

    @Then("User gets valid product info display in search page")
    public void user_gets_valid_product_info_display_in_search_page() {
        driver.findElement(By.linkText("HP LP3065")).isDisplayed();
    }

    @When("User enters invalid product {string}")
    public void user_enters_invalid_product(String invalidProduct){
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).sendKeys(invalidProduct);
    }

    @Then("User gets warning message no product found")
    public void user_gets_warning_message_no_product_found(){
        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());
    }
}
