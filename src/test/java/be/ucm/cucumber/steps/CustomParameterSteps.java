package be.ucm.cucumber.steps;

import be.ucm.models.Meal;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParameterSteps {

    private Meal meal;

    @Given("a Meal {meal}")
    public void a_Meal(Meal meal) {
        this.meal = meal;
    }

    @When("I do something")
    public void i_do_something() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the name is {string} and the price is {float}")
    public void i_get_something(String name, double price) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(price, meal.getPrice(), 0.01);
        Assert.assertEquals(name, meal.getName());
    }
}
