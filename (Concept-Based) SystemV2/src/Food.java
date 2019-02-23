public class Food {
    String name;
    Price price;
    Double priceVal;
    Type type;
    NutritionalValue nutritionalValue;
    int calories;

    public Food(String name, Price price, Double priceVal, Type type, NutritionalValue nutritionalValue, int calories) {
        this.name = name;
        this.price = price;
        this.priceVal = priceVal;
        this.type = type;
        this.nutritionalValue = nutritionalValue;
        this.calories = calories;
    }

    public String toString() {
        return this.name;
    }

}
