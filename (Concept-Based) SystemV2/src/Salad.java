import java.util.ArrayList;

public class Salad extends Food{
    SaladGreens saladGreens;
    ArrayList<Toppings> toppings;
    SaladDressing saladDressing;

    public Salad(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
