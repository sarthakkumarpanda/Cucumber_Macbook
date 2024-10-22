package step_definitions;

import com.Utilities.Util;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class Register {

    public WebDriver driver;


    @Given("User navigates to RegisterPage")
    public void user_navigates_to_register_page() {
        driver = DriverFactory.getDriver();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @And("User enters the below mandatory details")
    public void user_enters_the_below_mandatory_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @Given("User selects Privacy Policy checkbox")
    public void user_selects_privacy_policy_checkbox() {
       driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("User account gets created successfully")
    public void user_account_gets_created_successfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'Congratulations! Your new account has been successfully created!']")).isDisplayed());
    }

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
    }

    @And("User enters the below all details")
    public void user_enters_the_below_all_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @And("User enters below fields with existing email")
    public void user_enters_below_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }

    @Then("User gets warning message of duplicate email")
    public void user_gets_warning_message_of_duplicate_email() {
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @And("User enters below fields with incorrect password")
    public void user_enters_below_fields_with_incorrect_password(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }
    @Then("User gets warning message of incorrectConfirmPassword")
    public void user_gets_warning_message_of_incorrect_confirm_password() {
        String actualWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-confirm']/following-sibling::div")).getText();
        String expectedWarningMessage = "Password confirmation does not match password!";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @And("User enters below fields with less than four characters for password")
    public void user_enters_below_fields_with_less_than_four_digits_for_password(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
    }
    @Then("User gets warning message of password cannot be less than certain characters")
    public void user_gets_warning_message_of_password_cannot_be_less_than_certain_characters() {
       driver.findElement(By.xpath("//div[text() = 'Password must be between 4 and 20 characters!']")).isDisplayed();
    }

    @Then("User gets warning message for every mandatory field")
    public void user_gets_warning_message_for_every_mandatory_field() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));
    }

}
