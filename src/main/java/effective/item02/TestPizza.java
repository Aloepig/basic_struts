package effective.item02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

public class TestPizza {


    @Test
    public void testPizza() {
        Pizza pizza = this.getNyPizza();
        Set<Pizza.Topping> pizzaTopping = EnumSet.allOf(Pizza.Topping.class);
        pizzaTopping.remove(Pizza.Topping.HAM);
        Assertions.assertEquals(pizza.toppings, pizzaTopping);
    }

    public Pizza getNyPizza() {
        return new NyPizza.Builder().addToppings(Pizza.Topping.PEPPER).addToppings(Pizza.Topping.ONION).build();
    }
}
