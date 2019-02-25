import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FoodPredicates {
    public static Predicate<Food> dietaryRestriction(DietPref dietPref) {
        return p -> p.dietPref == dietPref;
    }

    public static Predicate<Food> foodType(Type type) {
        return p -> p.type == type;
    }

    public static Predicate<Food> hungerCaloric(Hunger hunger) {
        return p -> p.calories > hunger.lower && p.calories < hunger.upper;
    }

    public static Predicate<Food> price(Budget budget) {
        return p -> p.priceVal < budget.limit;
    }

    public static Predicate<Food> nutritional(NutritionPreference pref) {
        if (pref == NutritionPreference.NoNutrition)
            return p -> true;
        else
            return p -> p.nutritionalValue == NutritionalValue.Medium || p.nutritionalValue == NutritionalValue.High;
    }

    public static List<Food> filterFood(List<Food> foodItems,
                                                  Predicate<Food> predicate1, Predicate<Food> predicate2) {
        return foodItems.stream()
                .filter(predicate1)
                .filter(predicate2)
                .collect(Collectors.<Food>toList());
    }
}
