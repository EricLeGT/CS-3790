import java.util.ArrayList;

public class Twisted_Taco extends Restaurants {
    String name;
    Menu menu;


    public Twisted_Taco(String name, Menu menu) {
        this.name = "Twisted Taco";
        this.menu = new Menu(true, createFoodList());
    }

    private ArrayList<Food> createFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        Food carneAsada = new Food("Carne Asada Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 220);
        Food philly = new Food("Philly Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300);
        Food argentinian = new Food("Argentinian Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 250);
        Food hillsBeef = new Food("The Hills Beef Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320);
        Food greek = new Food("Greek Beef Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 240);
        Food buffalo = new Food("Buffalo Bill Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 330);
        Food sierraMadre = new Food("Sierra Madre Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 320);
        Food hillsChicken = new Food("The Hills Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250);
        Food tombstone = new Food("Tombstone Chicken Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 240);
        Food cuban = new Food("Cuban Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 430);
        Food pulledPork = new Food("Pulled Pork Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 250);
        Food alamo = new Food("Alamo Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 350);
        Food baja = new Food("Baja Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 270);
        Food boomboom = new Food("Boom Boom Seafood Taco", Price.Cheap, 3.69, Type.Taco, NutritionalValue.Medium, 390);
        Food friedAvocado = new Food("Fried Avocado Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 300);
        Food falafel = new Food("Falafel Taco", Price.Cheap, 3.39, Type.Taco, NutritionalValue.Medium, 150);
        Food veggieBurritoBowl = new Food("Vegetarian Burrito Bowl", Price.Medium, 6.49, Type.BurritoBowl, NutritionalValue.Medium, 550);
        Food chickenBurritoBowl = new Food("Grilled Chicken Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 690);
        Food tofuBurritoBowl = new Food("Tofu Burrito Bowl", Price.Medium, 6.79, Type.BurritoBowl, NutritionalValue.Medium, 550);
        Food beefBurritoBowl = new Food("Seasoned Beef Burrito Bowl", Price.Medium, 7.29, Type.BurritoBowl, NutritionalValue.Medium, 790);
        Food carnitasBurritoBowl = new Food("Carnitas Burrito Bowl", Price.Medium, 7.79, Type.BurritoBowl, NutritionalValue.Medium, 550);
        Food steakBurritoBowl = new Food("Grilled Steak Burrito Bowl", Price.Medium, 8.29, Type.BurritoBowl, NutritionalValue.Medium, 770);
        Food vegetarianNachos = new Food("Vegetarian Nachos", Price.Medium, 6.49, Type.Nachos, NutritionalValue.Low, 690);
        Food chickenNachos = new Food("Grilled Chicken Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 820);
        Food steakNachos = new Food("Grilled Steak Nachos", Price.Medium, 8.29, Type.Nachos, NutritionalValue.Low, 910);
        Food beefNachos = new Food("Seasoned Ground Beef Nachos", Price.Medium, 7.29, Type.Nachos, NutritionalValue.Low, 790);
        Food veggieQuesadilla = new Food("Vegetarian Quessadilla", Price.Medium, 6.49, Type.Quesadilla, NutritionalValue.Medium, 770);
        Food chickenQuesadilla = new Food("Grilled Chicken Quessadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 910);
        Food steakQuesadilla = new Food("Grilled Steak Quessadilla", Price.Medium, 8.29, Type.Quesadilla, NutritionalValue.Medium, 990);
        Food beefQuesadilla = new Food("Seasoned Ground Beef Quessadilla", Price.Medium, 7.29, Type.Quesadilla, NutritionalValue.Medium, 790);
        Food veggieSalad = new Food("Vegetarian Fajita Salad", Price.Medium, 6.49, Type.Salad, NutritionalValue.Medium, 610);
        Food chickenSalad = new Food("Grilled Chick Salad", Price.Medium, 7.29, Type.Salad, NutritionalValue.Medium, 610);
        Food steakSalad = new Food("Grilled Steak Salad", Price.Medium, 8.29, Type.Salad, NutritionalValue.Medium, 610);
        foodList.add(carneAsada);
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
        foodList.add(beefQuesadilla);
        foodList.add(veggieSalad);
        foodList.add(chickenSalad);
        foodList.add(steakSalad);
        return foodList;
    }
}
