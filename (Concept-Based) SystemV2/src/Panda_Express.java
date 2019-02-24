import java.util.ArrayList;

public class Panda_Express extends Restaurants {
    String name;
    Menu menu;


    public Panda_Express() {
        this.name = "Panda Express";
        this.menu = new Menu(true, createFoodList());
    }

    private ArrayList<Food> createFoodList() {
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

    public Food chooseItem () {
        return menu.foodItems.get(0); //need to add some more logic to this, this is just a default value for now
    }

}
