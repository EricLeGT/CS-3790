import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class main {
    public static void main(String args[]) throws FileNotFoundException {


        File userdata = new File("./src/userdata.csv");
        Scanner reader = new Scanner(userdata);
        List<User> users = new ArrayList<>();
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Panda_Express());
        restaurants.add(new Twisted_Taco());
        restaurants.add(new Chick_Fila());
        restaurants.add(new Rays());
        restaurants.add(new Subway());

        while (reader.hasNext()) {
            String userLine = reader.nextLine();
            String[] userInfo = userLine.split(",");
            users.add(new User(userInfo));
        }

        if (users.size() == 1) {
            User user1 = users.get(0);
            System.out.println("Main: Calling User to filter everything");
            user1.filterEverything();

            //System.out.println(user1.restaurantChosen);

            System.out.println("Main: Choosing Restaurant");
            Food eatThis = user1.restaurantChosen.chooseFoodItem(user1.nutritionPreference, user1.budget, user1.dietPref, user1.hunger);
            if (eatThis == null) {
                System.out.println("Come back later. There's nothing available for you right now.");
            } else {
                System.out.println("Go eat some " + eatThis + " at " + user1.restaurantList.get(0));
            }
        } else {
            Restaurant groupChoice;
            int budgets = 0;
            Map<Restaurant, Double> groupRestaurantSelections = new HashMap<>();
            for (Restaurant restaurant : restaurants) {
                groupRestaurantSelections.put(restaurant, 0.0);
            }

            for (User user : users) {
                budgets += user.getBudget().getChoice();
            }
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                //calculating group influenced budget
                int u = i + 1;
                System.out.println("Calculating budget for User-" + u + " based on the other group members' budgets.");
                int ch = (int) (user.getBudget().choice * 0.5 +
                        (budgets - user.getBudget().choice) / (users.size() - 1));
                Budget newBudget = Budget.getBudget(ch);
                user.setBudget(newBudget);

                //calculates collective restaurant scores
                for (Restaurant restaurant : restaurants) {
                    //System.out.print("user " + i);
                    groupRestaurantSelections.put(restaurant,
                            (groupRestaurantSelections.get(restaurant) +
                                    user.getRestaurantScore(restaurant)));
                }
            }
            System.out.println("Calculating collective restaurant choice based on group preferences.");
            groupChoice = argmax(groupRestaurantSelections);
            System.out.println("Group has selected to go to " + groupChoice.getName());

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                Food eatThis = groupChoice.chooseFoodItem(user.nutritionPreference, user.budget, user.dietPref, user.hunger);
                int u = i + 1;
                if (eatThis == null) {
                    System.out.println("\nUser-" + u + " has chosen not to eat as there is nothing for him/her right now.");
                } else {
                    System.out.println("\nUser-" + u + " has chosen to eat " + eatThis);
                }
            }
        }
    }

    public static Restaurant argmax(Map<Restaurant, Double> groupRS) {
        Map.Entry<Restaurant, Double> maxEntry = null;
        for (Map.Entry<Restaurant, Double> entry : groupRS.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        Restaurant argmax = maxEntry.getKey();
        return argmax;
    }

}
