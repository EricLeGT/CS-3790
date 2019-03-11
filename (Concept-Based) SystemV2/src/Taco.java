import java.util.ArrayList;

public class Taco extends Food{
    Tortilla shellType;
    Protein protein;
    ArrayList<Toppings> toppings;
    Sauce sauce;

    public Taco(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
