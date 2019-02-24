import java.util.ArrayList;

public class Twisted_Taco extends Restaurants {
    String name;
    Menu menu;


    public Twisted_Taco() {
        this.name = "Twisted Taco";
        this.menu = new Menu(true, createFoodList());
    }

    private ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food carneAsada = new Food("Carne Asada Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 220, DietPref.None);
        Food philly = new Food("Philly Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300, DietPref.None);
        Food argentinian = new Food("Argentinian Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food hillsBeef = new Food("The Hills Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320, DietPref.None);
        Food greek = new Food("Greek Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 240, DietPref.None);
        Food buffalo = new Food("Buffalo Bill Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 330, DietPref.None);
        Food sierraMadre = new Food("Sierra Madre Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320, DietPref.None);
        Food hillsChicken = new Food("The Hills Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food tombstone = new Food("Tombstone Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 240, DietPref.None);
        Food cuban = new Food("Cuban Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 430, DietPref.None);
        Food pulledPork = new Food("Pulled Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250, DietPref.None);
        Food alamo = new Food("Alamo Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 350, DietPref.None);
        Food baja = new Food("Baja Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 270, DietPref.Pescatarian);
        Food boomboom = new Food("Boom Boom Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 390, DietPref.Pescatarian);
        Food friedAvocado = new Food("Fried Avocado Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300, DietPref.Vegetarian);
        Food falafel = new Food("Falafel Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 150, DietPref.Vegan);
        Food veggieBurritoBowl = new Food("Vegetarian Burrito Bowl", Price.Medium, 6.49, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.None);
        Food chickenBurritoBowl = new Food("Grilled Chicken Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 690, DietPref.None);
        Food tofuBurritoBowl = new Food("Tofu Burrito Bowl", Price.Medium, 6.79, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.Vegan);
        Food beefBurritoBowl = new Food("Seasoned Beef Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 790, DietPref.None);
        Food carnitasBurritoBowl = new Food("Carnitas Burrito Bowl", Price.Medium, 7.79, Type.BurritoBowl, NutritionalValue.Medium, 550, DietPref.None);
        Food steakBurritoBowl = new Food("Grilled Steak Burrito Bowl", Price.Medium, 8.29, Type.BurritoBowl, NutritionalValue.Medium, 770, DietPref.None);
        Food vegetarianNachos = new Food("Vegetarian Nachos", Price.Medium, 6.49, Type.Nachos, NutritionalValue.Low, 690, DietPref.Vegetarian);
        Food chickenNachos = new Food("Grilled Chicken Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 820, DietPref.None);
        Food steakNachos = new Food("Grilled Steak Nachos", Price.Medium, 8.29, Type.Nachos, NutritionalValue.Low, 910, DietPref.None);
        Food beefNachos = new Food("Seasoned Ground Beef Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 790, DietPref.None);
        Food veggieQuesadilla = new Food("Vegetarian Quessadilla", Price.Medium, 6.49, Type.Quesadilla, NutritionalValue.Medium, 770, DietPref.Vegetarian);
        Food chickenQuesadilla = new Food("Grilled Chicken Quessadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 910, DietPref.None);
        Food steakQuesadilla = new Food("Grilled Steak Quessadilla", Price.Medium, 8.29, Type.Quesadilla, NutritionalValue.Medium, 990, DietPref.None);
        Food beefQuesadilla = new Food("Seasoned Ground Beef Quessadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 790, DietPref.None);
        Food veggieSalad = new Food("Vegetarian Fajita Salad", Price.Medium, 6.49, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
        Food chickenSalad = new Food("Grilled Chick Salad", Price.Medium, 7.29, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
        Food steakSalad = new Food("Grilled Steak Salad", Price.Medium, 8.29, Type.Salad, NutritionalValue.Medium, 610, DietPref.None);
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

    public String toString() {
        return name;
    }

    public Food chooseItem () {
        return menu.foodItems.get(0); //need to add some more logic to this, this is just a default value for now
    }
}
