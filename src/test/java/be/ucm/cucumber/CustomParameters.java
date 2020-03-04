package be.ucm.cucumber;

import be.ucm.models.Meal;
import io.cucumber.java.ParameterType;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class CustomParameters {
    @ParameterType("name:.*\\|price:.*")
    public Meal meal(String mealRegex){
        Meal meal = null;
        Pattern pattern = Pattern.compile("name:(.*)\\|price:(4\\.8)");
        Matcher matcher = pattern.matcher(mealRegex);
        if (matcher.find()){
            String name = matcher.group(1);
            double price = Double.parseDouble(matcher.group(2));
            meal = new Meal(price, name);
        }
        else {
            System.out.println("CA MARCHE PASSSS : " + mealRegex);
        }
        //meal = new Meal(4.8, mealRegex);
        return meal;
    }
}
