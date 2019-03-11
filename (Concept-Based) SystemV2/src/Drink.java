public class Drink extends Food{
    DrinkSize drinkSize;
    Temperature temperature;

    public Drink(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        super(name, price, priceVal, type, nutritionalValue, calories, dietPref);
    }
}
