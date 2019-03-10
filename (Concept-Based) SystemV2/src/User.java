import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class User {

    Budget budget;
    NutritionPreference nutritionPreference;
    Hunger hunger;
    Cravings cravings;
    String badExperience;
    List<Restaurant> restaurantList = new ArrayList<>();
    DietPref dietPref;
    Commitment commitment;
    Emotion emotion;
    Restaurant restaurantChosen;

    public User(String[] userString) {
        restaurantList.add(new Panda_Express());
        restaurantList.add(new Twisted_Taco());
        restaurantList.add(new Chick_Fila());
        restaurantList.add(new Rays());
        restaurantList.add(new Subway());

        if (userString[0].equals("1")) {
            //System.out.println("setting budget");
            this.budget = Budget.Poor;
        } else if(userString[1].equals("2")) {
            this.budget = Budget.Medium;
        } else {
            this.budget = Budget.Mad_Rich;
        }

        if (userString[1].equals("N")) {
            this.nutritionPreference = NutritionPreference.NoNutrition;
        } else {
            this.nutritionPreference = NutritionPreference.Nutrition;
        }

        if (userString[2].equals("Vegetarian")) {
            this.dietPref = DietPref.Vegetarian;
        } else if (userString[2].equals("Vegan")) {
            this.dietPref = DietPref.Vegan;
        } else if (userString[2].equals("Pescatarian")) {
            this.dietPref = DietPref.Pescatarian;
        } else {
            this.dietPref = DietPref.None;
        }

        if (userString[3].equals("Y")) {
            this.hunger = Hunger.Slightly_Hungry;
        } else {
            this.hunger = Hunger.Moderately_Hungry;
        }

        if (userString[4].equals("Positive")) {
            this.emotion = Emotion.Positive;
        } else {
            emotion = Emotion.Negative;
        }

        if (userString[5].equals("1")) {
            restaurantList.get(0).setLineSize(Line.Short);
        } else if (userString[5].equals("2")) {
            restaurantList.get(0).setLineSize(Line.Medium);
        } else {
            restaurantList.get(0).setLineSize(Line.Long);
        }

        if (userString[6].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[6].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        if (userString[7].equals("1")) {
            restaurantList.get(2).setLineSize(Line.Short);
        } else if (userString[7].equals("2")) {
            restaurantList.get(2).setLineSize(Line.Medium);
        } else {
            restaurantList.get(2).setLineSize(Line.Long);
        }

        if (userString[8].equals("1")) {
            restaurantList.get(3).setLineSize(Line.Short);
        } else if (userString[8].equals("2")) {
            restaurantList.get(3).setLineSize(Line.Medium);
        } else {
            restaurantList.get(3).setLineSize(Line.Long);
        }

        if (userString[9].equals("1")) {
            restaurantList.get(4).setLineSize(Line.Short);
        } else if (userString[9].equals("2")) {
            restaurantList.get(4).setLineSize(Line.Medium);
        } else {
            restaurantList.get(4).setLineSize(Line.Long);
        }

        badExperience = userString[10];

        if (userString[11].equals("Y")) {
            commitment = Commitment.Yes;
        } else {
            commitment = Commitment.No;
        }

    }

    public User(Budget budget, NutritionPreference preferences, Hunger hunger, Cravings cravings) {
        this.budget = budget;
        this.nutritionPreference = preferences;
        this.hunger = hunger;
        this.cravings = cravings;
        this.restaurantList = new ArrayList<>();
        restaurantList.add(new Panda_Express());
        restaurantList.add(new Twisted_Taco());
        restaurantList.add(new Subway());
        restaurantList.add(new Rays());
        restaurantList.add(new Chick_Fila());

    }

    //this method filters based on a bad experience that the user has had in the past
    public void removeBadExperience() {
        //System.out.println(restaurantList.size());
        for(int i = restaurantList.size() - 1;  i > -1; i--) {
            //System.out.println(badExperience);
            //System.out.println(restaurantList.get(i).getName());
            if (badExperience.equals(restaurantList.get(i).getName())) {
                System.out.printf("%s has been removed from the list of restaurant " +
                        "options based on the User's past experiences.\n", restaurantList.get(i).getName());
                restaurantList.remove(i);
            }
        }
    }

    /**
     * Filtering based on dietary preferences
     * If the user is vegan then they cannot go to every restaurant.
     */

    public void filterDietaryPreferences() {
        if(this.dietPref.equals(DietPref.Vegan)) {
            for(int i = restaurantList.size() - 1;  i > -1; i--) {
                if (restaurantList.get(i).getName().equals("Panda Express") ||
                        restaurantList.get(i).getName().equals("Rays")) {
                    restaurantList.remove(i);
                }
            }
        }
    }

    /** this method filters out restaurants that have a long wait time
     *  however this filter only happens if there is at least on restaurant
     *  doesn't have a long wait time
     */
    public void removeLongWaittime() {

        boolean allLong = true;

        for (Restaurant r: restaurantList) { //this is giving a null pointer here, fix it or get rid of it
            //System.out.println(r.getLineSize());
            if (!r.getLineSize().equals(Line.Long)) {
                allLong = false;
            }
        }

        if (!allLong) {
            for(int i = restaurantList.size() - 1;  i > -1; i--) {
                if (Line.Long.equals(restaurantList.get(i).getLineSize())) {
                    restaurantList.remove(i);
                }
            }
        }
    }



    public void eat () {
    }

    public void waitInLine(Restaurant restaurants) {
        //to be implemented later
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
        System.out.println("Setting the user's budget");
    }


    public NutritionPreference getPreferences() {
        return nutritionPreference;
    }

    public void setPreferences(NutritionPreference preferences) {
        this.nutritionPreference = preferences;
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

    public void filterEverything() {
        //filterDietaryPreferences();
        System.out.println("User: Remove past bad experiences");
        removeBadExperience();

        //this method filters based on the dietary preferences
        System.out.println("User: Filter out dietary preference");
        filterDietaryPreferences();

        //this method call takes out restaurants that have a really long line size
        System.out.println("User: Filter out commitments");
        if (commitment.equals(Commitment.Yes)) {
            removeLongWaittime();
        }

        //setting the Nutrition preference of the User based on their emotion
        //regardless of what their long-term views on nutrition are
        System.out.println("User: Setting emotion and preferences");
        if (emotion.equals(Emotion.Negative)) {
            setPreferences(NutritionPreference.NoNutrition);
        }

        //Sorting the list based on general ranking (if user doesn't care about nutrition)
        if (this.nutritionPreference.equals(NutritionPreference.NoNutrition)) {
            restaurantList.sort((o1, o2) -> o1.getTasteRank() - o2.getTasteRank());
        } else {
            //Sorting the list based on ranking (if the user does care about nutrition)
            //Sorting the list based on general ranking (if user doesn't care about nutrition)
            restaurantList.sort((o1, o2) -> o1.getNutritionRank() - o2.getNutritionRank());
        }

        restaurantChosen = restaurantList.get(0);

    }
}
