public class Food {
    String name;
    Price price;
    Double priceVal;
    Type type;
    NutritionalValue nutritionalValue;
    int calories;
    DietPref dietPref;

    public Food() {
        this.name = name;
    }

    public Food(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories, DietPref dietPref) {
        this.name = name;
        this.price = price;
        this.priceVal = priceVal;
        this.type = type;
        this.nutritionalValue = nutritionalValue;
        this.calories = calories;
        this.dietPref = dietPref;
    }

    public String toString() {
        return this.name;
    }

}
