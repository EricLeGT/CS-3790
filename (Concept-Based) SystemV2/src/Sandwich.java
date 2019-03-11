import java.util.ArrayList;

public class Sandwich extends Food{
    Bread bread;
    Protein protein;
    Sauce sauce;
    ArrayList<Toppings> toppings;
    Cheese cheese;

    public Sandwich(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
