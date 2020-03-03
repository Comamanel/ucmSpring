package be.ucm.cucumber.steps;

import be.ucm.BL.ShopService;
import be.ucm.models.Client;
import be.ucm.models.Meal;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WhatToEatSteps {

    private Client client;
    private Meal meal;
    private List<Meal> meals;
    private Meal lowestMeal;
    private ShopService shopService = new ShopService();

    @Given("a {string} at {float} euros")
    public void a_good_burger_at_euros(String name, double price) {
        this.meal = new Meal(price, name);
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("a client with a budget of {float} euros")
    public void a_client_with_a_budget_of_euros(double budget) {
        // Write code here that turns the phrase above into concrete actions
        this.client = new Client(budget);
    }

    @When("I buy the burger")
    public void i_buy_the_burger() {

        shopService.achat(this.client, this.meal);
    }

    @Then("the budget is {float} euros")
    public void the_budget_is_euros(double budget) {
        Assert.assertEquals(budget, client.getBudget(), 0.01);
    }

    @Given("a list of meals")
    public void listOfMeals(List<Map<String, String>> datas){
        this.meals = datas.stream()
                .map(d -> new Meal(Double.parseDouble(d.get("price")), d.get("name")))
                .collect(Collectors.toList());
    }

    @When("I ask the cheapest meal")
    public void iAskTheCheapestMeal(){
        this.lowestMeal = shopService.getLowestMeal(this.meals);
    }
    @Then("i get the {string} at {float} euros")
    public void iGetTheMealAtEuros(String name, double price){
        Assert.assertEquals(name, lowestMeal.getName());
        Assert.assertEquals(price, lowestMeal.getPrice(), 0.01);
    }
}
