import java.util.ArrayList;

public abstract class Restaurant {
    public String restaurantName;
    public Menu restaurantMenu;
    public Line lineSize;
    public abstract ArrayList<Food> createFoodList();
    public abstract Food chooseFoodItem(NutritionPreference userpref, Budget budget);

    public String getName() {
        return restaurantName;
    }

    public void setLineSize(Line lineSize) {
        this.lineSize = lineSize;
    }

    public Line getLineSize() {return lineSize;}

}
