import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class main {

    public static void groupLunchDecision() throws IOException{
        //userdata csv userline format: budget ,nutritional preference,dietary preference ,hunger,emotion,panda ls,twisted ls,cfa ls ,rays ls ,subway ls,bad ex,has commitment ,EF trait ,leadership ,deferred gratification ,altruism ,#times at panda ,#times at twisted,#time at cfa,#times at rays ,#times at subway,panda opinion ,twisted opinion ,chickfila opinion,rays opinion ,subway opinion

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
        reader.close();

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
            //Leader selection
            System.out.println("--- Choosing the leader ---");
            User groupLeader;
            List<User> leaderCandidates = new ArrayList<>();

            Random rand = new Random();
            for (User user : users) {
                if (user.leadership == Leadership.Yes) {
                    leaderCandidates.add(user);
                }
            }
            if (leaderCandidates.isEmpty()) {
                groupLeader = users.get(rand.nextInt(users.size()));
            } else {
                groupLeader = leaderCandidates.get(rand.nextInt(leaderCandidates.size()));
            }

            System.out.println("Individual-" + groupLeader.userNum + " has been chosen as the leader because they " +
                    "show the most leadership like qualities.\n");

            //Restaurant discussion
            System.out.println("Individual-" + groupLeader.userNum + ": \"Where does everyone want to go?\"");

            Map<User, UserModel> entireGroup = new HashMap<>();

            for (User user : users) {

                user.filterEverything();

                //fix up how the usermodel is created

                UserModel userModel = new UserModel(user.restaurantChosen, user.getReason(), user.getDegree());
                entireGroup.put(user, userModel);

                //if an individual is very altruistic and the don't have a need to
                // assert their opinion based on deferred gratification
                if (user.altruism >= 0.7 && user.deferredGratification <= 2) {
                    System.out.println("Individual-" + user.userNum + ": \"I don't particularly care where I go so, you it's up to you guys to choose where we go.");
                    user.setDegree(0);
                } else {
                    System.out.println("Individual-" + user.userNum + ": \"I want to go to " + user.restaurantChosen.getName()
                            + " because " + user.getReason().getReason());
                }
                //update method call
                for (User otherUser: users) {
                    if (otherUser != user) {
                        user.userModelMap.put(user, userModel);
                    }
                }

                //System.out.println("--- All users are updating their model of" + " Individual-" + user.userNum + " ---");

                if (user.EFfactor > 0.5) {
                    System.out.println();
                }
            }


            Map<String, Integer> Votebank = new HashMap<>();
            for (int i = 0; i < restaurants.size(); i++) {
                Votebank.put(restaurants.get(i).getName(), 0);
            }

            for (User user: users) {
                Votebank.put(user.restaurantChosen.getName(),
                        (int) (user.getDegree() + Votebank.get(user.restaurantChosen.getName())));
            }

            Restaurant groupRestaurant = groupLeader.findGroupRestaurant(Votebank);

            for(User user: users) {

                user.setGroupRestaurant(groupRestaurant);
                user.setFoodItemChosen(user.restaurantChosen.chooseFoodItem(user.nutritionPreference, user.budget, user.dietPref, user.hunger));
            }

            System.out.println("Individual-" + groupLeader.userNum + ": Based on the group's preferences, let's go to " + groupRestaurant.getName());

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                Food eatThis = groupRestaurant.chooseFoodItem(user.nutritionPreference, user.budget, user.dietPref, user.hunger);
                int u = i + 1;
                if (eatThis == null) {
                    System.out.println("\nIndividual-" + u + " has chosen not to eat as there is nothing for him/her right now.");
                } else {
                    System.out.println("\nIndividual-" + u + " has chosen to eat " + eatThis);
                }
            }

            for (User u: users) {
                u.updateOpinion();
                u.updateDeferredGratification();
                u.updateRestaurantTimes();
            }


            /*Restaurant groupChoice;
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
            }*/
            updateUserData(userdata, users);
        }
    }

    public static synchronized void main(String args[]) {

        for (int i = 0; i < 20; i++) {
            try {
                groupLunchDecision();
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void updateUserData(File userdata, List<User> users) throws IOException {
        try (PrintWriter writer = new PrintWriter(userdata)) {
            for (User user : users) {
                writer.write(user.composeUserString());
            }
            writer.close();
        }
    }

}
