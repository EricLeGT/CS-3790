import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panda_Express extends Restaurant {
    String name;
    Menu menu;
    Line lineSize;


    public Panda_Express() {
        this.name = "Panda Express";
        this.menu = new Menu(true, createFoodList());
    }

    @Override
    public ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food orangeChickFR = new Food("Orange Chicken with Fried Rice", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 1010, DietPref.None);
        Food stringBeanChickBR = new Food("String Bean Chicken Breast with Brown Steamed Rice", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 610, DietPref.None);
        Food kungPaoChickFR = new Food("Kung Pao Chicken with Fried Rice", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 810, DietPref.None);
        Food broccoliBeefCM = new Food("Broccoli Beef with Chow Mein", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 660, DietPref.None);
        Food eggplantTofuFR= new Food("Eggplant Tofu with Fried Rice", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 1010, DietPref.Vegetarian);
        Food honeyWalnutShrimpCM = new Food("Honey Walnut Shrimp with Chow Mein", Price.Medium, 6.20, Type.Combo, NutritionalValue.Medium, 870, DietPref.None);
        Food dOrangeChickFRCM = new Food("Double Orange Chicken with Fried Rice and Chow Mein", Price.Medium, 7.60, Type.Combo, NutritionalValue.Medium, 1010, DietPref.None);
        Food steakShrimpCM = new Food("Shanghai Angus Steak and Honey Walnut Shrimp with Chow Mein", Price.Medium, 7.60, Type.Combo, NutritionalValue.Medium, 1190, DietPref.None);
        Food chickenEggRoll = new Food("Chicken Egg Roll", Price.Cheap, 1.95, Type.Side, NutritionalValue.Medium, 200, DietPref.None);
        Food veggieRoll = new Food("Veggie Spring Roll", Price.Cheap, 1.95, Type.Side, NutritionalValue.Medium, 190, DietPref.Vegetarian);
        Food creamCheeseRangoon = new Food("Cream Cheese Rangoon", Price.Cheap, 1.95, Type.Side, NutritionalValue.Medium, 190, DietPref.Vegetarian);
        foodList.add(orangeChickFR);
        foodList.add(stringBeanChickBR);
        foodList.add(kungPaoChickFR);
        foodList.add(broccoliBeefCM);
        foodList.add(eggplantTofuFR);
        foodList.add(honeyWalnutShrimpCM);
        foodList.add(dOrangeChickFRCM);
        foodList.add(steakShrimpCM);
        foodList.add(chickenEggRoll);
        foodList.add(veggieRoll);
        foodList.add(creamCheeseRangoon);



        return foodList;
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



    @Override
    public Food chooseFoodItem(NutritionPreference userpref, Budget budget) {
        Random r = new Random();
        List<Food> potentialOrders = FoodPredicates.filterFood(this.menu.foodItems,
                FoodPredicates.nutritional(userpref), FoodPredicates.price(budget));
        return potentialOrders.get(r.nextInt(potentialOrders.size()));
    }
}
