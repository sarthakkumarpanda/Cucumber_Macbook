package step_definitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

    public WebDriver driver;


    @Given("User navigates to login page")
    public void user_navigates_to_login_page(){
        driver = DriverFactory.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("^User enters valid email (.+)$")
    public void user_enters_valid_email(String validEmailText){
        driver.findElement(By.id("input-email")).sendKeys(validEmailText);
    }

    @And("^User enters valid password (.+)$")
    public void user_enters_valid_password(String validPasswordText){
        driver.findElement(By.id("input-password")).sendKeys(validPasswordText);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button(){
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("User is redirected to Account Page")
    public void user_is_redirected_to_account_page() {
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
    }

    @When("User enters invalid email {string}")
    public void user_enters_invalid_email(String invalidEmailText) {
        driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);
    }
    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String invalidPasswordText) {
        driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
    }
    @Then("User gets warning message about credentials mismatch")
    public void user_gets_warning_message_about_credentials_mismatch() {
        String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

}
