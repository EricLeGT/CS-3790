import java.util.ArrayList;

public class Quesadilla extends Food{
    Tortilla tortilla;
    Cheese cheese;
    Protein protein;
    ArrayList<Toppings> toppings;

    public Quesadilla(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
