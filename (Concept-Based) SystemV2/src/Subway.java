import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subway extends Restaurant {

    String name;
    Menu menu;
    Line lineSize;
    public int tasteRank = 3;
    public int nutritionRank = 1 ;

    public Subway() {
        this.name = "Subway";
        this.menu = new Menu(true, createFoodList());
    }

    @Override
    public ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food turkeyBreast = new Sandwich("Turkey Breast Sub", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 560, DietPref.None);
        Food roastBeef = new Sandwich("Roast Beef Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.High, 640, DietPref.None);
        Food subwayClub = new Sandwich("Subway Club Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 620, DietPref.None);
        Food veggieDelite = new Sandwich("Veggie Delite Sub", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 560, DietPref.Vegan);
        Food blackForestHam = new Sandwich("Black Forest Ham Sub", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 580, DietPref.None);
        Food sweetOnionChickenTeriyaki = new Sandwich("Sweet Onion Chicken Teriyaki Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.High, 740, DietPref.None);
        Food rotisserieChicken = new Sandwich("Rotisserie-Style Chicken Sub", Price.Medium,7.79, Type.Sandwich, NutritionalValue.High, 700, DietPref.None);
        Food ovenChicken = new Sandwich("Oven Roasted Chicken", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 640, DietPref.None);
        Food chickenBaconRanch = new Sandwich("Chicken & Bacon Ranch Melt Sub", Price.Medium,8.00, Type.Sandwich, NutritionalValue.Low, 1220, DietPref.None);
        Food coldCutCombo = new Sandwich("Cold Cut Combo", Price.Medium,5.59, Type.Sandwich, NutritionalValue.High, 720, DietPref.None);
        Food italianBMT = new Sandwich("Italian B.M.T. Sub", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 820, DietPref.None);
        Food meatballMarinara = new Sandwich("Meatball Marinara Sub", Price.Medium,5.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.None);
        Food spicyItalian = new Sandwich("Spicy Italian Sub", Price.Medium,5.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.None);
        Food steakAndCheese = new Sandwich("Steak and Cheese Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 706, DietPref.None);
        Food tuna = new Sandwich("Tuna", Price.Medium,7.00, Type.Sandwich, NutritionalValue.High, 960, DietPref.Pescatarian);
        Food subwayMelt = new Sandwich("Subway Melt Sub", Price.Medium,7.50, Type.Sandwich, NutritionalValue.High, 820, DietPref.None);
        Food turkeyAndBacon = new Sandwich("Turkey and Bacon Guacamole Sub", Price.Medium,8.75, Type.Sandwich, NutritionalValue.High, 880, DietPref.None);
        Food buffaloChicken = new Sandwich("Buffalo Chicken Sub", Price.Medium,7.75, Type.Sandwich, NutritionalValue.High, 840, DietPref.None);
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

    public int getTasteRank() {
        return 3;
    }

    public int getNutritionRank() {
        return 1;
    }

    public String toString() {
        return name;
    }

    public Food chooseItem () {
        return menu.foodItems.get(0); //need to add some more logic to this, this is just a default value for now
    }

    public void setLineSize(Line lineSize) {
        this.lineSize = lineSize;
    }

    public Line getLineSize() {return lineSize;}

    public String getName() {
        return name;
    }

    @Override
    public Food chooseFoodItem(NutritionPreference userpref, Budget budget, DietPref dietPref, Hunger hunger) {
        Random r = new Random();
        System.out.println("Restaurant: Filter options based on budget and preferences");
        List<Food> potentialOrders = FoodPredicates.filterFood(this.menu.foodItems,
                FoodPredicates.nutritional(userpref), FoodPredicates.price(budget),
                FoodPredicates.dietaryRestriction(dietPref), FoodPredicates.hungerCaloric(hunger));
        if (potentialOrders.size() == 0) {
            potentialOrders = FoodPredicates.filterFood(this.menu.foodItems, FoodPredicates.dietaryRestriction(dietPref));
            if (potentialOrders.size() == 0) {
                return null;
            }
        }
        return potentialOrders.get(r.nextInt(potentialOrders.size()));
    }
}
