public class Subway extends Restaurants {

    String name = "Subway";
    public Food veggieDelight = new Food("Veggie Delight", Price.Medium, Type.Sandwich, NutritionalValue.High);

    public String toString() {
        return name;
    }

}
