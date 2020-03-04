package be.ucm.cucumber.steps;

import be.ucm.BL.MathService;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


public class MathSteps {
    private double nb1;
    private double nb2;
    private double result;

    @Autowired
    private MathService mathService;

    @Given("the first number {float}")
    public void theFirstNumber(double nb1){
        this.nb1 = nb1;
    }

    @Given("the second number {float}")
    public void theSecondNumber(double nb2){
        this.nb2 = nb2;
    }

    @When("i multiply them")
    public void iMultiplyThem(){
        this.result = mathService.multiplication(nb1, nb2);
    }

    @Then("the result is {float}")
    public void theResultIs(double expected){
        Assert.assertEquals(expected, result, 0.01);
    }

}
