import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chick_Fila extends Restaurant {
    String name;
    Menu menu;
    Line lineSize;
    public int tasteRank = 1;
    public int nutritionRank = 3;

    public Chick_Fila() {
        this.name = "Chick-fil-a";
        this.menu = new Menu(true, createFoodList());
    }

    @Override
    public ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food chickenSandwich = new Food("Chicken Sandwich", Price.Cheap, 3.49, Type.Sandwich, NutritionalValue.Medium, 440, DietPref.None);
        Food chickenSandwichCombo = new Food("Chicken Sandwich Combo", Price.Medium, 6.39, Type.Sandwich, NutritionalValue.Low, 970, DietPref.None);
        Food spicyChickenSandwich = new Food("Spicy Chicken Sandwich", Price.Cheap, 3.64, Type.Sandwich, NutritionalValue.Medium, 450, DietPref.None);
        Food spicyChickenSandwichCombo = new Food("Spicy Chicken Sandwich Combo", Price.Medium, 6.55, Type.Sandwich, NutritionalValue.Low, 970, DietPref.None);
        Food mediumFries = new Food("Medium Fries", Price.Cheap, 1.89, Type.Fries, NutritionalValue.Medium, 400, DietPref.Vegan);
        Food largeFries = new Food("Large Fries", Price.Cheap, 1.99, Type.Fries, NutritionalValue.Medium, 520, DietPref.Vegan);
        Food grilledMarketSalad = new Food("Grilled Market Salad", Price.Medium, 7.99, Type.Salad, NutritionalValue.High, 200, DietPref.None);
        Food grilledChickenSandwich = new Food("Grilled Chicken Sandwich", Price.Cheap, 5.15, Type.Sandwich, NutritionalValue.Medium, 310, DietPref.None);
        Food grilledChickenSandwichCombo = new Food("Grilled Chicken Sandwich Combo", Price.Medium, 7.85, Type.Sandwich, NutritionalValue.Medium, 830, DietPref.None);
        Food nuggets = new Food("Nuggets", Price.Cheap, 3.75, Type.Nuggets, NutritionalValue.Low, 250, DietPref.None);
        Food nuggetsCombo = new Food("Nuggets Combo", Price.Medium, 6.49, Type.Nuggets, NutritionalValue.Low, 770, DietPref.None);
        Food smallShake = new Food("Small Shake", Price.Cheap, 3.29, Type.Drink, NutritionalValue.Low, 520, DietPref.Vegetarian);
        Food largeShake = new Food("Large Shake", Price.Cheap, 3.75, Type.Drink, NutritionalValue.Low, 640, DietPref.Vegetarian);
        foodList.add(chickenSandwich);
        foodList.add(chickenSandwichCombo);
        foodList.add(spicyChickenSandwich);
        foodList.add(spicyChickenSandwichCombo);
        foodList.add(mediumFries);
        foodList.add(largeFries);
        foodList.add(grilledMarketSalad);
        foodList.add(grilledChickenSandwich);
        foodList.add(grilledChickenSandwichCombo);
        foodList.add(nuggets);
        foodList.add(nuggetsCombo);
        foodList.add(smallShake);
        foodList.add(largeShake);

        return foodList;
    }

    public int getTasteRank() {
        return 1;
    }

    public int getNutritionRank() {
        return 3;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setLineSize(Line lineSize) {
        this.lineSize = lineSize;
    }

    public Line getLineSize() {return lineSize;}

    @Override
    public Food chooseFoodItem(NutritionPreference userpref, Budget budget) {
        Random r = new Random();
        List<Food> potentialOrders = FoodPredicates.filterFood(this.menu.foodItems,
                FoodPredicates.nutritional(userpref), FoodPredicates.price(budget));
        return potentialOrders.get(r.nextInt(potentialOrders.size()));
    }
}
