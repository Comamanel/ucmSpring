package be.ucm.cucumber.steps;

import be.ucm.BL.MathService;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;


public class Math2Steps {

    private double number1;
    private double number2;
    private double result;

    @Autowired
    private MathService mathService;

    @Given("number {float}")
    public void number(double nb1) {
        this.number1 = nb1;
    }

    @Given("another number {float}")
    public void another_number(double nb2) {
        this.number2 = nb2;
    }
    @When("multiplied")
    public void multiplied() {
        this.result = mathService.multiplication(number1, number2);
    }
    @Then("i get {double}")
    public void i_get(double result) {
        Assert.assertEquals(result, this.result, 0.01);
    }
}
