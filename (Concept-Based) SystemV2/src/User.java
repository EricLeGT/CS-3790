import java.util.ArrayList;
import java.util.List;

public class User {

    Budget budget;
    NutritionPreference preferences;
    Hunger hunger;
    Cravings cravings;
    String badExperience;
    List<Restaurant> restaurantList = new ArrayList<>();
    DietPref dietPref;
    Emotion emotion;

    public User(String[] userString) {
        restaurantList.add(new Panda_Express());
        restaurantList.add(new Twisted_Taco());
        restaurantList.add(new Chick_Fila());
        restaurantList.add(new Rays());
        restaurantList.add(new Subway());

        if (userString[0].equals("1")) {
            System.out.println("setting budget");
            this.budget = Budget.Poor;
        } else if(userString[1].equals("2")) {
            this.budget = Budget.Medium;
        } else {
            this.budget = Budget.Mad_Rich;
        }

        if (userString[1].equals("N")) {
            this.preferences = NutritionPreference.NoNutrition.NoNutrition;
        } else {
            this.preferences = NutritionPreference.Nutrition;
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
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[5].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        if (userString[6].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[6].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        if (userString[7].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[7].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        if (userString[8].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[8].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        if (userString[9].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
        } else if (userString[9].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
        }

        badExperience = userString[10];

    }

    public User(Budget budget, NutritionPreference preferences, Hunger hunger, Cravings cravings) {
        this.budget = budget;
        this.preferences = preferences;
        this.hunger = hunger;
        this.cravings = cravings;
        this.restaurantList = new ArrayList<>();
        restaurantList.add(new Panda_Express());
        restaurantList.add(new Twisted_Taco());
        restaurantList.add(new Subway());
        restaurantList.add(new Rays());
        restaurantList.add(new Chick_Fila());

    }

    public void removeBadExperience() {
        System.out.println(restaurantList.size());
        for(int i = restaurantList.size() - 1;  i > -1; i--) {
            //System.out.println(badExperience);
            //System.out.println(restaurantList.get(i).getName());
            if (badExperience.equals(restaurantList.get(i).getName())) {
                System.out.printf("%s has been removed from the list of restaurant " +
                        "options based on the User's past experiences.", restaurantList.get(i).getName());
                restaurantList.remove(i);
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
        return preferences;
    }

    public void setPreferences(NutritionPreference preferences) {
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
