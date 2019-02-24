import java.util.Scanner;

public class User {

    Budget budget;
    Preferences preferences;
    Hunger hunger;
    Cravings cravings;
    Restaurants chosenRestaurant;
    Food chosenFoodItem;

    public User() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you care about nutrition? (Type in Y or N)");
        if (scanner.nextLine().equals("Y")) {
            this.preferences = (Preferences.Nutrition);
        } else {
            this.preferences = (Preferences.NoNutrition);
        }

        System.out.println("What is your budget? Type in 1, 2 or 3 (1 = low, 2 = medium, 3 = high");
        if (scanner.nextLine().equals("1")) {
            this.budget = (Budget.Poor);
        } else if (scanner.nextLine().equals("2")) {
            this.budget = (Budget.Medium);
        } else {
            this.budget = (Budget.Mad_Rich);
        }
    }

    public void sendUserToResturant (Student_Center student_center) {
        //put some more logic to choosing a place to eat here, Panda is set to default
        chosenRestaurant = student_center.pandaExpress;
    }

    public void chooseItem () {
        //call the chosen resturaunt's chooseItem method
        chosenFoodItem = chosenRestaurant.chooseItem();
    }




    public void eat () {
        if (chosenFoodItem == null) {
            System.out.println("Nothing to eat");
        } else {
            System.out.println("Go nom on " + chosenFoodItem);
        }
    }

    public void waitInLine(Restaurants restaurants) {
        //to be implemented later
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
        System.out.println("Setting the user's budget");
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
        System.out.println("Setting the user's preference");
    }

    public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    public Cravings getCravings() {
        return cravings;
    }

    public void setCravings(Cravings cravings) {
        this.cravings = cravings;
    }
}
