import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        User user = new User(Budget.Poor, null, null, null);

        Restaurants[] restaurants = {new Panda_Express(), new Subway(), new Chick_Fila(), new Twisted_Taco()};
        Student_Center student_center = new Student_Center();
        student_center.setRestaurants(restaurants);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you care about nutrition? (Type in Y or N)");
        if (scanner.nextLine().equals("Y")) {
            user.setPreferences(Preferences.Nutrition);
        } else {
            user.setPreferences(Preferences.NoNutrition);
        }

        System.out.println("What is your budget? Type in 1, 2 or 3 (1 = low, 2 = medium, 3 = high");
        if (scanner.nextLine().equals("1")) {
            user.setBudget(Budget.Poor);
        } else if (scanner.nextLine().equals("2")) {
            user.setBudget(Budget.Medium);
        } else {
            user.setBudget(Budget.Mad_Rich);
        }

        if (user.budget.equals(Budget.Mad_Rich)) {
            Panda_Express restaurantChosen = new Panda_Express();
            System.out.println("You should get " + restaurantChosen.comboMeal + " from " + restaurantChosen);
        } else if (user.preferences == Preferences.Nutrition) {
            Subway restaurantChosen = new Subway();
            System.out.println("You should get " + restaurantChosen.veggieDelight + " from " + restaurantChosen);
        } else {
            Chick_Fila restaurantChosen = new Chick_Fila();
            System.out.println("You should get " + restaurantChosen.chickenSandwich + " from " + restaurantChosen);
        }


        System.out.println("Thats as far as we got : D");
    }
}
