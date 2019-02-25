import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subway extends Restaurant {

    String name;
    Menu menu;

    public Subway() {
        this.name = "Subway";
        this.menu = new Menu(true, createFoodList());
    }

    @Override
    public ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food turkeyBreast = new Food("Turkey Breast Sub", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 560, DietPref.None);
        Food roastBeef = new Food("Roast Beef Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.High, 640, DietPref.None);
        Food subwayClub = new Food("Subway Club Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 620, DietPref.None);
        Food veggieDelite = new Food("Veggie Delite Sub", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 560, DietPref.Vegan);
        Food blackForestHam = new Food("Black Forest Ham Sub", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 580, DietPref.None);
        Food sweetOnionChickenTeriyaki = new Food("Sweet Onion Chicken Teriyaki Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.High, 740, DietPref.None);
        Food rotisserieChicken = new Food("Rotisserie-Style Chicken Sub", Price.Medium,7.79, Type.Sandwich, NutritionalValue.High, 700, DietPref.None);
        Food ovenChicken = new Food("Oven Roasted Chicken", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 640, DietPref.None);
        Food chickenBaconRanch = new Food("Chicken & Bacon Ranch Melt Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.Low, 1220, DietPref.None);
        Food coldCutCombo = new Food("Cold Cut Combo", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 720, DietPref.None);
        Food italianBMT = new Food("Italian B.M.T. Sub", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 820, DietPref.None);
        Food meatballMarinara = new Food("Meatball Marinara Sub", Price.Medium,5.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.None);
        Food spicyItalian = new Food("Spicy Italian Sub", Price.Medium,5.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.None);
        Food steakAndCheese = new Food("Steak and Cheese Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 706, DietPref.None);
        Food tuna = new Food("Tuna", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.Pescatarian);
        Food subwayMelt = new Food("Subway Melt Sub", Price.Medium,7.50, Type.Sandwich, NutritionalValue.High, 820, DietPref.None);
        Food turkeyAndBacon = new Food("Turkey and Bacon Guacamole Sub", Price.Medium,8.75, Type.Sandwich, NutritionalValue.High, 880, DietPref.None);
        Food buffaloChicken = new Food("Buffalo Chicken Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 840, DietPref.None);
        foodList.add(turkeyBreast);
        foodList.add(roastBeef);
        foodList.add(subwayClub);
        foodList.add(veggieDelite);
        foodList.add(blackForestHam);
        foodList.add(sweetOnionChickenTeriyaki);
        foodList.add(rotisserieChicken);
        foodList.add(ovenChicken);
        foodList.add(chickenBaconRanch);
        foodList.add(coldCutCombo);
        foodList.add(italianBMT);
        foodList.add(meatballMarinara);
        foodList.add(spicyItalian);
        foodList.add(steakAndCheese);
        foodList.add(tuna);
        foodList.add(subwayMelt);
        foodList.add(turkeyAndBacon);
        foodList.add(buffaloChicken);
        return foodList;
    }

    public String toString() {
        return name;
    }

    public Food chooseItem () {
        return menu.foodItems.get(0); //need to add some more logic to this, this is just a default value for now
    }


    @Override
    public Food chooseFoodItem(NutritionPreference userpref, Budget budget) {
        Random r = new Random();
        List<Food> potentialOrders = FoodPredicates.filterFood(this.menu.foodItems,
                FoodPredicates.nutritional(userpref), FoodPredicates.price(budget));
        return potentialOrders.get(r.nextInt(potentialOrders.size()));
    }
}
