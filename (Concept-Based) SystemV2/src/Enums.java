/*
this class is meant to house all of our enums
 */
public class Enums {
}

enum Budget {
        Poor(5.00), Medium(12.00), Mad_Rich(25.00);
        public double limit;
        Budget(double lim) {
            limit = lim;
        }
}

enum Cravings {

}

enum Emotion {
    Positive, Negative;
}

enum DietPref{
    Vegetarian, Pescatarian, None, Vegan;
}

enum NutritionPreference {
        Nutrition, NoNutrition;

}

enum Commitment {
    Yes, No;
}

enum Hunger {
        Pants_OnFire_Hungry(2000, 1000), Moderately_Hungry (1200, 700), Slightly_Hungry (800, 0);

        public int upper, lower;
        Hunger(int upperCal, int lowerCal) {
            upper = upperCal;
            lower = lowerCal;
        }

}

enum Line {
        Short, Medium, Long;
}

enum Price {
        Cheap, Medium, Expensive;
}

 enum Type {
        Sandwich, Combo, Pizza, Pasta, Taco, BurritoBowl, Nachos,
     Quesadilla, Salad, Fries, Nuggets, Drink, Side;
}

enum NutritionalValue {
        Low, Medium, High;
}

enum Size {
    Small, Medium, Large;
}

enum Sauce {
    ChickFilASauce, BarbequeSauce;
}

enum PastaType {
    Penne, Lasagna, Spaghetti;
}

enum PastaSauce {
    Ragu;
}

enum BlackBeans {
    Yes, No;
}

enum Cheese {
    Mozzarella, Goat, Cheddar;
}

enum Rice {
    Yellow, White, Brown, Spanish, Fried;
}

enum Toppings {
    Lettuce, PicoDeGallo, SourCream, Jalapeno, Cilantro, Salsa;
}

enum Protein {
    Chicken, GrilledChicken, Tofu, Pork, Beef;
}

enum DrinkSize {
    small, medium, large;
}

enum Temperature {
    hot, cold;
}

enum Chips {
    corn;
}

enum Crust {
    thin, thick;
}

enum PizzaSauce {
    red, white, pesto;
}

enum Tortilla {
    flour, corn;
}

enum SaladGreens {
    spinach, lettuce, mix;
}

enum SaladDressing {
    BalsamicVinagrette, Italian, Ranch;
}

enum Bread {
    Italian, White, WholeWheat;
}

