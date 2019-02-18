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
