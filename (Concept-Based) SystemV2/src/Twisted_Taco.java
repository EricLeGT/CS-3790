import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Twisted_Taco extends Restaurant {
    String name;
    Menu menu;
    Line lineSize;
    public int tasteRank = 2;
    public int nutritionRank = 4;


    public Twisted_Taco() {
        this.name = "Twisted Taco";
        this.menu = new Menu(true, createFoodList());
    }

    @Override
    public ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food carneAsada = new Taco("Carne Asada Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 220, DietPref.None);
        Food philly = new Taco("Philly Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300, DietPref.None);
        Food argentinian = new Taco("Argentinian Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food hillsBeef = new Taco("The Hills Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320, DietPref.None);
        Food greek = new Taco("Greek Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 240, DietPref.None);
        Food buffalo = new Taco("Buffalo Bill Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 330, DietPref.None);
        Food sierraMadre = new Taco("Sierra Madre Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320, DietPref.None);
        Food hillsChicken = new Taco("The Hills Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food tombstone = new Taco("Tombstone Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 240, DietPref.None);
        Food cuban = new Taco("Cuban Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 430, DietPref.None);
        Food pulledPork = new Taco("Pulled Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food alamo = new Taco("Alamo Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 350, DietPref.None);
        Food baja = new Taco("Baja Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 270, DietPref.Pescatarian);
        Food boomboom = new Taco("Boom Boom Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 390, DietPref.Pescatarian);
        Food friedAvocado = new Taco("Fried Avocado Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300, DietPref.Vegetarian);
        Food falafel = new Taco("Falafel Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 150, DietPref.Vegan);
        Food veggieBurritoBowl = new BurritoBowl("Vegetarian Burrito Bowl", Price.Medium, 6.49, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.None);
        Food chickenBurritoBowl = new BurritoBowl("Grilled Chicken Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 690, DietPref.None);
        Food tofuBurritoBowl = new BurritoBowl("Tofu Burrito Bowl", Price.Medium, 6.79, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.Vegan);
        Food beefBurritoBowl = new BurritoBowl("Seasoned Beef Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 790, DietPref.None);
        Food carnitasBurritoBowl = new BurritoBowl("Carnitas Burrito Bowl", Price.Medium, 7.79, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.None);
        Food steakBurritoBowl = new BurritoBowl("Grilled Steak Burrito Bowl", Price.Medium, 8.29, Type.BurritoBowl, NutritionalValue.Medium, 770, DietPref.None);
        Food vegetarianNachos = new Nachos("Vegetarian Nachos", Price.Medium, 6.49, Type.Nachos, NutritionalValue.Low, 690, DietPref.Vegetarian);
        Food chickenNachos = new Nachos("Grilled Chicken Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 820, DietPref.None);
        Food steakNachos = new Nachos("Grilled Steak Nachos", Price.Medium, 8.29, Type.Nachos, NutritionalValue.Low, 910, DietPref.None);
        Food beefNachos = new Nachos("Seasoned Ground Beef Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 790, DietPref.None);
        Food veggieQuesadilla = new Quesadilla("Vegetarian Quesadilla", Price.Medium, 6.49, Type.Quesadilla, NutritionalValue.Medium, 770, DietPref.Vegetarian);
        Food chickenQuesadilla = new Quesadilla("Grilled Chicken Quesadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 910, DietPref.None);
        Food steakQuesadilla = new Quesadilla("Grilled Steak Quesadilla", Price.Medium, 8.29, Type.Quesadilla, NutritionalValue.Medium, 990, DietPref.None);
        Food beefQuesadilla = new Quesadilla("Seasoned Ground Beef Quesadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 790, DietPref.None);
        Food veggieSalad = new Salad("Vegetarian Fajita Salad", Price.Medium, 6.49, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
        Food chickenSalad = new Salad("Grilled Chick Salad", Price.Medium, 7.29, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
        Food steakSalad = new Salad("Grilled Steak Salad", Price.Medium, 8.29, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
        foodList.add(carneAsada);
        foodList.add(pulledPork);
        foodList.add(alamo);
        foodList.add(baja);
        foodList.add(falafel);
        foodList.add(beefBurritoBowl);
        foodList.add(argentinian);
        foodList.add(hillsBeef);
        foodList.add(greek);
        foodList.add(buffalo);
        foodList.add(sierraMadre);
        foodList.add(hillsChicken);
        foodList.add(tombstone);
        foodList.add(cuban);
        foodList.add(philly);
        foodList.add(boomboom);
        foodList.add(friedAvocado);
        foodList.add(veggieBurritoBowl);
        foodList.add(chickenBurritoBowl);
        foodList.add(tofuBurritoBowl);
        foodList.add(carnitasBurritoBowl);
        foodList.add(steakBurritoBowl);
        foodList.add(vegetarianNachos);
        foodList.add(chickenNachos);
        foodList.add(steakNachos);
        foodList.add(beefNachos);
        foodList.add(veggieQuesadilla);
        foodList.add(chickenQuesadilla);
        foodList.add(steakQuesadilla);
        foodList.add(beefQuesadilla);
        foodList.add(veggieSalad);
        foodList.add(chickenSalad);
        foodList.add(steakSalad);
        return foodList;
    }

    public int getTasteRank() {
        return 2;
    }

    public int getNutritionRank() {
        return 4;
    }

    public String toString() {
        return name;
    }

    public void setLineSize(Line lineSize) {
        this.lineSize = lineSize;
    }

    public Line getLineSize() {return lineSize;}

    public String getName() {
        return this.name;
    }

    @Override
    public Food chooseFoodItem(NutritionPreference userpref, Budget budget, DietPref dietPref, Hunger hunger) {
        Random r = new Random();
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
