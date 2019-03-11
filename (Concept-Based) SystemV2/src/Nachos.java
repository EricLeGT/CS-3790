import java.util.ArrayList;

public class Nachos extends Food{
    Cheese cheese;
    Chips chips;
    ArrayList<Toppings> toppings;

    public Nachos(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
