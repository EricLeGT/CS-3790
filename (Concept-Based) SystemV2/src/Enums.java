/*
this class is meant to house all of our enums
 */
public class Enums {
}

enum Budget {
        Poor(5.00, 1), Medium(12.00, 2), Mad_Rich(25.00, 3);
        public double limit;
        public int choice;
        Budget(double lim, int ch) {
            limit = lim;
            choice = ch;
        }

        public int getChoice() {
            return choice;
        }

        public static Budget getBudget(int ch) {
            for (Budget b : Budget.values()) {
                if (b.choice == ch) {
                    return b;
                }
            }
            return null;
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
    Lettuce, PicoDeGallo, SourCream, Jalapeno, Cilantro, Salsa,
    Avocado, Pepperoni, Peppers, Olives, Corn;
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

enum Leadership {
    Yes, No;
}

enum Opinion {
    Low, Medium, High;
}

enum Reason {
    Nutrition("I care about my food's nutrition"),
    DietaryPref("I really care about my dietary preference"),
    //Budget("I'm a little tight on money."),
    DeferredGratification("we haven't eaten at a place I've wanted for a while."),
    Familiarity("I feel like eating at my go-to restaurant."),
    Exploration("I feel like trying something new."),
    MentalState("I'm feeling kind of stressed, so that's what I'm craving."),
    Craving("I'm craving their food.");


    String reason;

    Reason (String reason) {
        this.reason = reason;
    }

    public String getReason(){
        return reason;
    }
}

enum FoodReason {
    Nutrition("I wanted something healthy to eat."),
    Vegetarian("I'm vegetarian and this was the best option."),
    Budget("I wanted something cheap to eat."),
    Emotion("I'm feeling down and needed this to pick me up."),
    Craving("I was just craving this");


    String foodReason;

    FoodReason(String foodReason) {
        this.foodReason = foodReason;
    }

    public String getFoodReason() {
        return foodReason;
    }
}

