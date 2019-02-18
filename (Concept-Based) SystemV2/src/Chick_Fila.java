public class Chick_Fila extends Restaurants {
    String name = "Chick-Fil-a";
    public Food chickenSandwich = new Food("Chicken Sandwich", Price.Medium, Type.Sandwich, NutritionalValue.Low);
    public Food fries = new Food("Fries", Price.Cheap, Type.Sandwich, NutritionalValue.Low);

    public String toString() {
        return name;
    }
}
