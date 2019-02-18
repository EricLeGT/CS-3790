public class Panda_Express extends Restaurants {
    String name = "Panda Express";
    public Food comboMeal = new Food("Chow mein with beef broccoli", Price.Expensive, Type.Combo, NutritionalValue.Medium);

    public String toString() {
        return name;
    }
}
