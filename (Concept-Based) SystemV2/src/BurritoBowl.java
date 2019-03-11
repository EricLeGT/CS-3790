import java.util.ArrayList;

public class BurritoBowl extends Food{
    String name;
    BlackBeans blackBeans;
    Cheese cheese;
    Rice rice;
    ArrayList<Toppings> toppings;
    Protein protein;

    public BurritoBowl(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }

    public String toString() {
        return this.name;
    }
}
