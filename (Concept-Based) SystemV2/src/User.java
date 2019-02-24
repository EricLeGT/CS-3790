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
        int budgetScanner = scanner.nextInt();
        if (budgetScanner == 1) {
            this.budget = (Budget.Poor);
        } else if (budgetScanner == 2) {
            this.budget = (Budget.Medium);
        } else {
            this.budget = (Budget.Mad_Rich);
        }
    }

    public void sendUserToResturant (Student_Center student_center) {
        //put some more logic to choosing a place to eat here, Panda is set to default
        Scanner scanner = new Scanner(System.in);
        int pandaLine;
        int subwayLine;
        int chickFilaLine;
        int twistedTacoLine;
        System.out.println("How long is Panda Express' line? (1 = short, 2 = long) ");
        pandaLine = scanner.nextInt();

        System.out.println("How long is Subway's line? (1 = short, 2 = long) ");
        subwayLine = scanner.nextInt();

        System.out.println("How long is Chick Fila's line? (1 = short, 2 = long) ");
        chickFilaLine = scanner.nextInt();

        System.out.println("How long is Twisted Taco's line? (1 = short, 2 = long) ");
        twistedTacoLine = scanner.nextInt();

        if (chickFilaLine == 1) {
            chosenRestaurant = student_center.chickFila;
        } else if (pandaLine == 1) {
            chosenRestaurant = student_center.pandaExpress;
        } else if (twistedTacoLine == 1) {
            chosenRestaurant = student_center.twistedTaco;
        } else if (subwayLine == 1) {
            chosenRestaurant = student_center.subway;
        } else {
            System.out.println("All lines are long, forcing user to Chick Fila");
            chosenRestaurant = student_center.chickFila;
        }
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
