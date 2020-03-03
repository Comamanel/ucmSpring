package be.ucm.BL;

import be.ucm.models.Client;
import be.ucm.models.Meal;

import java.util.List;

public class ShopService {
    public void achat(Client client, Meal meal){
        client.setBudget(client.getBudget()-meal.getPrice());
    }

    public Meal getLowestMeal(List<Meal> meals){
        return meals.stream().min((a,b) -> (int)(a.getPrice() - b.getPrice())).orElse(null);
    }
}
