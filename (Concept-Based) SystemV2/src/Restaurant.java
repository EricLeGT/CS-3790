import java.util.ArrayList;

public abstract class Restaurant {
    public String restaurantName;
    public Menu restaurantMenu;
    public Line restaurantLine;
    public abstract ArrayList<Food> createFoodList();
    public abstract Food chooseFoodItem(NutritionPreference userpref, Budget budget);
}
