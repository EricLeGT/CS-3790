import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws FileNotFoundException {


        File file = new File("./src/users.csv");
        Scanner userFile = new Scanner(file);
        String userLine = userFile.nextLine();
        String delimiter = ",";
        String[] userInfo = userLine.split(delimiter);

        //Subgoal 1: picking the restaurant for the user to go to

        //this method call has the user filter out its own preferences
        User user1 = new User(userInfo);
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
    }
}
