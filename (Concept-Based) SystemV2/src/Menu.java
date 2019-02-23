import java.util.ArrayList;
import java.util.List;

public class Menu {
    boolean hasNutritionalInfo;
    List<Food> foodItems = new ArrayList<Food>();

    public Menu(boolean hasNutritionalInfo, List<Food> foodItems) {
        this.hasNutritionalInfo = hasNutritionalInfo;
        this.foodItems = foodItems;
    }
}
