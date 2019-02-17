public class User {

    Budget budget;
    Preferences preferences;
    Hunger hunger;
    Cravings cravings;

    public User(Budget budget, Preferences preferences, Hunger hunger, Cravings cravings) {
        this.budget = budget;
        this.preferences = preferences;
        this.hunger = hunger;
        this.cravings = cravings;
    }

    public void eat () {

    }

    public void waitInLine(Restaurants restaurants) {
        //to be implemented later
    }
}
