import java.util.ArrayList;

public abstract class Restaurant {
    public String restaurantName;
    public Menu restaurantMenu;
    public Line lineSize;
    public int tasteRank;
    public int nutritionRank;
    public abstract ArrayList<Food> createFoodList();
    public abstract Food chooseFoodItem(NutritionPreference userpref, Budget budget, DietPref dietPref, Hunger hunger);

    public String getName() {
        return restaurantName;
    }

    public void setLineSize(Line lineSize) {
        this.lineSize = lineSize;
    }

    public Line getLineSize() {return lineSize;}

    public int getTasteRank() {
        return tasteRank;
    }

    public int getNutritionRank() {
        return nutritionRank;
    }

}
