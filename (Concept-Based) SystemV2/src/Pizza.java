import java.util.ArrayList;

public class Pizza extends Food{
    Crust crust;
    PizzaSauce pizzaSauce;
    ArrayList<Toppings> toppings;
    Cheese cheese;

    public Pizza(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
