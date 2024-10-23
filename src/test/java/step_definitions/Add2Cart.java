package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Add2Cart {

    public WebDriver driver;



    @When("User clicks on AddToCart button present in ProductPage")
    public void user_clicks_on_AddToCart_button_present_in_ProductPage(){
      driver.findElement(By.cssSelector("div.button-group > button:nth-child(1)")).click();
    }


    @Then("User is re-directed to AddToCartPage")
    public void user_is_redirected_to_AddToCartPage(){

    }

    @When("User confirms quantity as one")
    public void user_confirms_quantity_as_one(){

    }

    @And("User clicks on AddToCart button again in this page")
    public void user_clicks_on_addTocart_button_again_in_this_page(){

    }

    @Then("User receives a Success Message")
    public void user_receives_a_success_message(){

    }

    @And("The Cart symbol increments with one item")
    public void the_cart_symbol_increments_with_one_item(){

    }
}