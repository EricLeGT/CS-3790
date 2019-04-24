import javafx.scene.effect.Effect;

import java.util.*;

public class User {

    String[] userString;
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
    Restaurant groupRestaurant;
    Reason reasonForRestaurantChosen;
    double Degree;
    
    Food foodItemChosen;

    double EFfactor;
    Leadership leadership;
    int deferredGratification;
    double altruism;
    int pandatimes;
    int twistedtimes;
    int chickfilatimes;
    int raystimes;
    int subwaytimes;
    Opinion pandaOpinion;
    Opinion twistedOpinion;
    Opinion chickfilaOpinion;
    Opinion raysOpinion;
    Opinion subwayOpinion;
    Line pandals;
    Line twistedls;
    Line chickfilals;
    Line raysls;
    Line subwayls;
    int userNum;

    FoodReason foodReason;

    int[] lineSizes = new int[5];

    Map<User, UserModel> userModelMap;

    public User(String[] userString) {
        this.userString = userString;
        restaurantList.add(new Panda_Express());
        restaurantList.add(new Twisted_Taco());
        restaurantList.add(new Chick_Fila());
        restaurantList.add(new Rays());
        restaurantList.add(new Subway());

        if (userString[0].equals("1")) {
            this.budget = Budget.Poor;
        } else if(userString[0].equals("2")) {
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
            pandals = Line.Short;
        } else if (userString[5].equals("2")) {
            restaurantList.get(0).setLineSize(Line.Medium);
            pandals = Line.Medium;
        } else {
            restaurantList.get(0).setLineSize(Line.Long);
            pandals = Line.Long;
        }

        if (userString[6].equals("1")) {
            restaurantList.get(1).setLineSize(Line.Short);
            twistedls = Line.Short;
        } else if (userString[6].equals("2")) {
            restaurantList.get(1).setLineSize(Line.Medium);
            twistedls = Line.Medium;
        } else {
            restaurantList.get(1).setLineSize(Line.Long);
            twistedls = Line.Long;
        }

        if (userString[7].equals("1")) {
            restaurantList.get(2).setLineSize(Line.Short);
            chickfilals = Line.Short;
        } else if (userString[7].equals("2")) {
            restaurantList.get(2).setLineSize(Line.Medium);
            chickfilals = Line.Medium;
        } else {
            restaurantList.get(2).setLineSize(Line.Long);
            chickfilals = Line.Long;
        }

        if (userString[8].equals("1")) {
            restaurantList.get(3).setLineSize(Line.Short);
            raysls = Line.Short;
        } else if (userString[8].equals("2")) {
            restaurantList.get(3).setLineSize(Line.Medium);
            raysls = Line.Medium;
        } else {
            restaurantList.get(3).setLineSize(Line.Long);
            raysls = Line.Long;
        }

        if (userString[9].equals("1")) {
            restaurantList.get(4).setLineSize(Line.Short);
            subwayls = Line.Short;
        } else if (userString[9].equals("2")) {
            restaurantList.get(4).setLineSize(Line.Medium);
            subwayls = Line.Medium;
        } else {
            restaurantList.get(4).setLineSize(Line.Long);
            subwayls = Line.Long;
        }

        badExperience = userString[10];

        if (userString[11].equals("Y")) {
            commitment = Commitment.Yes;
        } else {
            commitment = Commitment.No;
        }

        EFfactor = Double.parseDouble(userString[12]);

        if (userString[13].equals("Y")) {
            this.leadership = Leadership.Yes;
        } else {
            this.leadership = Leadership.No;
        }

        this.deferredGratification = Integer.parseInt(userString[14]);

        this.altruism = Double.parseDouble(userString[15]);

        pandatimes = Integer.parseInt(userString[16]);
        twistedtimes = Integer.parseInt(userString[17]);
        chickfilatimes = Integer.parseInt(userString[18]);
        raystimes = Integer.parseInt(userString[19]);
        subwaytimes = Integer.parseInt(userString[20]);

        if (userString[21].equals("1")) {
            this.pandaOpinion = Opinion.Low;
        } else if(userString[21].equals("2")) {
            this.pandaOpinion = Opinion.Medium;
        } else {
            this.pandaOpinion = Opinion.High;
        }

        if (userString[22].equals("1")) {
            this.twistedOpinion = Opinion.Low;
        } else if(userString[21].equals("2")) {
            this.twistedOpinion = Opinion.Medium;
        } else {
            this.twistedOpinion = Opinion.High;
        }

        if (userString[23].equals("1")) {
            this.chickfilaOpinion = Opinion.Low;
        } else if(userString[23].equals("2")) {
            this.chickfilaOpinion = Opinion.Medium;
        } else {
            this.chickfilaOpinion = Opinion.High;
        }

        if (userString[24].equals("1")) {
            this.raysOpinion = Opinion.Low;
        } else if(userString[24].equals("2")) {
            this.raysOpinion = Opinion.Medium;
        } else {
            this.raysOpinion = Opinion.High;
        }

        if (userString[25].equals("1")) {
            this.subwayOpinion = Opinion.Low;
        } else if(userString[25].equals("2")) {
            this.subwayOpinion = Opinion.Medium;
        } else {
            this.subwayOpinion = Opinion.High;
        }
        this.userNum = Integer.parseInt(userString[26]);

        userModelMap = new HashMap<>();

//        double unnormalizedDegree = (1 - altruism) * (deferredGratification + 1);
//        this.Degree = 4 / (1 + Math.exp(unnormalizedDegree / 2)) - 1;
        this.Degree = (1-altruism) * deferredGratification;
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
                //System.out.printf("%s has been removed from the list of restaurant " +
                       // "options based on the User's past experiences.\n", restaurantList.get(i).getName());
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

    public void removeBasedOnOpinion() {
        for(int i = restaurantList.size() - 1;  i > -1; i--) {
            Opinion relevantOpinion;

            if (restaurantList.get(i).getName().equals("Panda Express")) {
                relevantOpinion = pandaOpinion;
            } else if (restaurantList.get(i).getName().equals("Rays")) {
                relevantOpinion = raysOpinion;
            } else if (restaurantList.get(i).getName().equals("Chick-fil-a")) {
                relevantOpinion = chickfilaOpinion;
            } else if (restaurantList.get(i).getName().equals("Twisted Taco")) {
                relevantOpinion = pandaOpinion;
            } else {
                relevantOpinion = subwayOpinion;
            }

            if (relevantOpinion.equals(Opinion.Low)) {
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
    }


    public NutritionPreference getPreferences() {
        return nutritionPreference;
    }

    public void setPreferences(NutritionPreference preferences) {
        this.nutritionPreference = preferences;
        //System.out.println("Setting the user's preference");
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

        //sorts based on opinion;
        Collections.sort(restaurantList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                Opinion relevantOpinion1;
                Opinion relevantOpinion2;

                if (o1.getName().equals("Panda Express")) {
                    relevantOpinion1 = pandaOpinion;
                } else if (o1.getName().equals("Rays")) {
                    relevantOpinion1 = raysOpinion;
                } else if (o1.getName().equals("Chick-fil-a")) {
                    relevantOpinion1 = chickfilaOpinion;
                } else if (o1.getName().equals("Twisted Taco")) {
                    relevantOpinion1 = twistedOpinion;
                } else {
                    relevantOpinion1 = subwayOpinion;
                }

                if (o2.getName().equals("Panda Express")) {
                    relevantOpinion2 = pandaOpinion;
                } else if (o2.getName().equals("Rays")) {
                    relevantOpinion2 = raysOpinion;
                } else if (o2.getName().equals("Chick-fil-a")) {
                    relevantOpinion2 = chickfilaOpinion;
                } else if (o2.getName().equals("Twisted Taco")) {
                    relevantOpinion2 = twistedOpinion;
                } else {
                    relevantOpinion2 = subwayOpinion;
                }

                return relevantOpinion1.ordinal() - relevantOpinion2.ordinal();
            }
        });

        //filterDietaryPreferences();
        //System.out.println("User: Remove past bad experiences");
        removeBadExperience();

        //this method filters based on the dietary preferences
        //System.out.println("User: Filter out dietary preference");
        filterDietaryPreferences();

        //this method call takes out restaurants that have a really long line size
        //System.out.println("User: Filter out commitments");
//        if (commitment.equals(Commitment.Yes)) {
//            removeLongWaittime();
//        }

        //setting the Nutrition preference of the User based on their emotion
        //regardless of what their long-term views on nutrition are
        //System.out.println("User: Setting emotion and preferences");
        if (emotion.equals(Emotion.Negative)) {
            setPreferences(NutritionPreference.NoNutrition);
        }

        //Sorting the list based on general ranking (if user doesn't care about nutrition)
        if (this.nutritionPreference.equals(NutritionPreference.NoNutrition)) {
            restaurantList.sort(Comparator.comparingInt(Restaurant::getTasteRank));
        } else {
            //Sorting the list based on ranking (if the user does care about nutrition)
            //Sorting the list based on general ranking (if user doesn't care about nutrition)
            restaurantList.sort(Comparator.comparingInt(Restaurant::getNutritionRank));
        }

        //figure out a way to generate the reason for choosing the restaurant
        //this.reasonForRestaurantChosen = getReason();
        if (restaurantList.isEmpty()) {
            Random rand = new Random();
            restaurantList.add(new Panda_Express());
            restaurantList.add(new Twisted_Taco());
            restaurantList.add(new Subway());
            restaurantList.add(new Rays());
            restaurantList.add(new Chick_Fila());
            restaurantChosen = restaurantList.get(rand.nextInt(restaurantList.size()));
        } else {
            restaurantChosen = individualArgmax();
        }
    }

    public Reason getReason() {
        int relevantTimes;
        Opinion relevantOpinion;
        if (restaurantChosen.getName().equals("Panda Express")) {
            relevantTimes = pandatimes;
            relevantOpinion = pandaOpinion;
        } else if (restaurantChosen.getName().equals("Rays")) {
            relevantTimes = raystimes;
            relevantOpinion = raysOpinion;
        } else if (restaurantChosen.getName().equals("Chick-fil-a")) {
            relevantTimes = chickfilatimes;
            relevantOpinion = chickfilaOpinion;
        } else if (restaurantChosen.getName().equals("Twisted Taco")) {
            relevantTimes = twistedtimes;
            relevantOpinion = twistedOpinion;
        } else {
            relevantTimes = subwaytimes;
            relevantOpinion = subwayOpinion;
        }



        if (dietPref.equals(DietPref.Vegan)) {
            return Reason.DietaryPref;
        } else if (this.nutritionPreference.equals(NutritionPreference.Nutrition)) {
            return Reason.Nutrition;
        } else if (EFfactor >= 0.5 && relevantTimes == 0) {
            return Reason.Exploration;
        } else if (EFfactor < 0.5 && (relevantOpinion == Opinion.High || relevantOpinion == Opinion.Medium)) {
            return Reason.Familiarity;
        } else if (emotion == Emotion.Negative) {
            return Reason.MentalState;
        } else {
            return Reason.Craving;
        }
    }

    public double getRestaurantScore(Restaurant restaurant) {
        int num_times = (restaurant.getName().equals("Panda Express")) ? pandatimes
                      : (restaurant.getName().equals("Twisted Taco")) ? twistedtimes
                      : (restaurant.getName().equals("Chick-fil-a")) ? chickfilatimes
                      : (restaurant.getName().equals("Rays")) ? raystimes
                      : subwaytimes;
        int total_times = pandatimes + twistedtimes + chickfilatimes + raystimes + subwaytimes;
        double restaurantScore = ((1 - EFfactor) / total_times) + (EFfactor / (5 * num_times + 0.5));
        //System.out.println(" is leaning towards " + individualArgmax().getName());
        return  restaurantScore;
    }

    //returns the degree of force the User exerts on the group decision;
    public double getDegree() {
        return Degree;
    }

    public void setDegree(double degree) {
        this.Degree = degree;
    }

    public Restaurant findGroupRestaurant(Map<String, Integer> popularityVotebank, Map<User, Double> weightedVotebank,
                                          Map<User, Integer> userDG) {
        String chosenRestaurant;
        double maxValue = Double.MIN_VALUE;
        List<String> maxRestNames = new ArrayList<>();

        Boolean useDG = false;
        for (Map.Entry<User, Integer> entry: userDG.entrySet()) {
            if (entry.getValue() >= 2) {
                useDG = true;
            }
        }
//        for (Map.Entry<String, Double> entry : weightedVotebank.entrySet()) {
//            if (maxValue == Double.MIN_VALUE || maxValue == entry.getValue()) {
//                maxValue = entry.getValue();
//                maxRestNames.add(entry.getKey());
//            } else if (entry.getValue() > maxValue) {
//                maxValue = entry.getValue();
//                maxRestNames.clear();
//                maxRestNames.add(entry.getKey());
//            }
//        }

        //Random rand = new Random();
        //chosenRestaurant = maxRestNames.get(rand.nextInt(maxRestNames.size()));

        int plurality = Collections.max(popularityVotebank.values());
        chosenRestaurant = Collections.max(popularityVotebank.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        if (plurality > weightedVotebank.entrySet().size() / 2) {
            System.out.println("Individual-" + userNum + ": Let's go to "
                    + chosenRestaurant + " because a majority of us want to go there\n");
        } else {
            if (useDG) {
                List<Map.Entry<User, Double>> list = new LinkedList<>(weightedVotebank.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<User, Double>>() {
                    @Override
                    public int compare(Map.Entry<User, Double > o1, Map.Entry<User, Double> o2) {
                        if (o1.getValue() > o2.getValue()) {
                            return -1;
                        } else if (o1.getValue() == o2.getValue()) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                });

                Map.Entry<User, Double> entry = list.get(0);
                chosenRestaurant = list.get(0).getKey().restaurantChosen.toString();

                System.out.print("Individual-" + userNum + ": Let's go to "
                        + chosenRestaurant);
                System.out.println(" because Individual-" + entry.getKey().userNum + " hasn't had a chance to pick where we " +
                        "go in a while and wants to go there.\n");
            } else {
                System.out.println("Individual-" + userNum + ": Let's go to "
                        + chosenRestaurant + " because many of us want to go there\n");
            }
        }

//        int plurality = Collections.max(popularityVotebank.values());
//
//        //check if plurality is majority ==> then go by only popular vote, not weighted
//        if (plurality > (userModelMap.size() + 1) / 2) {
//            chosenRestaurant = Collections.max(popularityVotebank.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
//            System.out.println("Individual-" + userNum + ": Let's go to "
//                    + chosenRestaurant + " because most of us want to go there\n");
//        } else {
//            List<Integer> deferredUserNums = getDeferredUsers(chosenRestaurant);
//            if (deferredUserNums.isEmpty()) {
//                System.out.println("Individual-" + userNum + ": Let's go to "
//                        + chosenRestaurant + " because a plurality of us want to go there.\n");
//            } else {
//                System.out.print("Individual-" + userNum + ": Let's go to "
//                        + chosenRestaurant);
//                System.out.println(" because ");
//                for (int userNum : deferredUserNums) {
//                    System.out.print(" Individual-" + userNum + " ");
//                }
//                System.out.print("hasn't had a chance to pick where we go in a while and wants to go there.");
//            }
//        }

        /*for (UserModel u: userModelMap.values()) {
            if (u.degree == 0) {
                nzDegrees = false;
            }
            groupRestaurantChoices.add(u);
        }

        groupRestaurantChoices.sort(new Comparator<UserModel>() {
            @Override
            public int compare(UserModel o1, UserModel o2) {
                return (int) (o1.getDegree() - o2.getDegree());
            }
        });
        
        if (nzDegrees) {
            return groupRestaurantChoices.get(0).getRestaurantChosen();
        } else {
            Random rand = new Random();
            return groupRestaurantChoices.get(rand.nextInt(groupRestaurantChoices.size())).getRestaurantChosen();
        }*/

        if (chosenRestaurant.equals("Panda Express")) {
            return new Panda_Express();
        } else if (chosenRestaurant.equals("Rays")) {
            return new Rays();
        } else if (chosenRestaurant.equals("Chick-fil-a")) {
            return new Chick_Fila();
        } else if (chosenRestaurant.equals("Twisted Taco")) {
            return new Twisted_Taco();
        } else {
            return new Subway();
        }

    }

    private List<Integer> getDeferredUsers(String restaurantChosen) {
        List<Integer> userNums = new ArrayList<>();
        for (User user : userModelMap.keySet()) {
            if (userModelMap.get(user).preferred.getName().equals(restaurantChosen) && userModelMap.get(user).degree > 1) {
                userNums.add(user.userNum);
            }
        }
        return userNums;
    }

    public void setGroupRestaurant(Restaurant restaurantChosen) {
        this.groupRestaurant = restaurantChosen;
    }
    
    //sets the Food item chosen by the user 
    public void setFoodItemChosen(Food foodItemChosen) {
        this.foodItemChosen = foodItemChosen;
    }

    //updates the opinion that the user have of the restaurant that the group chose
    public String updateOpinion() {
        Line relevantLineSize;
        if (groupRestaurant.getName().equals("Panda Express")) {
            relevantLineSize = pandals;
        } else if (groupRestaurant.getName().equals("Rays")) {
            relevantLineSize = raysls;
        } else if (groupRestaurant.getName().equals("Chick-fil-a")) {
            relevantLineSize = chickfilals;
        } else if (groupRestaurant.getName().equals("Twisted Taco")) {
            relevantLineSize = twistedls;
        } else {
            relevantLineSize = subwayls;
        }

        if (foodItemChosen == null) {
            if (groupRestaurant.getName().equals("Panda Express")) {
                pandaOpinion = Opinion.Low;
            } else if (groupRestaurant.getName().equals("Rays")) {
                raysOpinion = Opinion.Low;
            } else if (groupRestaurant.getName().equals("Chick-fil-a")) {
                chickfilaOpinion = Opinion.Low;
            } else if (groupRestaurant.getName().equals("Twisted Taco")) {
                twistedOpinion = Opinion.Low;
            } else {
                subwayOpinion = Opinion.Low;
            }
            return "has decreased because they could not get anything to eat.";
        } else if (relevantLineSize.equals(Line.Long)) {
            if (groupRestaurant.getName().equals("Panda Express")) {
                pandaOpinion = decrementOpinion(pandaOpinion);
            } else if (groupRestaurant.getName().equals("Rays")) {
                raysOpinion = decrementOpinion(raysOpinion);
            } else if (groupRestaurant.getName().equals("Chick-fil-a")) {
                chickfilaOpinion = decrementOpinion(chickfilaOpinion);
            } else if (groupRestaurant.getName().equals("Twisted Taco")) {
                twistedOpinion = decrementOpinion(chickfilaOpinion);
            } else {
                subwayOpinion = decrementOpinion(subwayOpinion);
            }
            return "has decreased because there was a long line";
        } else {
            if (groupRestaurant.getName().equals("Panda Express")) {
                pandaOpinion = incrementOpinion(pandaOpinion);
            } else if (groupRestaurant.getName().equals("Rays")) {
                raysOpinion = incrementOpinion(raysOpinion);
            } else if (groupRestaurant.getName().equals("Chick-fil-a")) {
                chickfilaOpinion = incrementOpinion(chickfilaOpinion);
            } else if (groupRestaurant.getName().equals("Twisted Taco")) {
                twistedOpinion = incrementOpinion(twistedOpinion);
            } else {
                subwayOpinion = incrementOpinion(subwayOpinion);
            }
            return "has improved because they had a good experience.";
        }
    }

    //method to update deferredGratification if you didn't get to go to your specific restaurant 
    public void updateDeferredGratification() {
        if (!restaurantChosen.getName().equals(groupRestaurant.getName())) {
            deferredGratification++;
        } else {
            deferredGratification = 0;
        }

//        double unnormalizedDegree = (1 - altruism) * (this.deferredGratification + 1);
//        this.Degree = 4 / (1 + Math.exp(unnormalizedDegree / 2)) - 1;
        this.Degree = (1 - altruism) * deferredGratification;
    }
    
    //method to update the number of times a person has been to a restaurant
    public void updateRestaurantTimes() {
        if (groupRestaurant.getName().equals("Panda Express")) {
            pandatimes++;
        } else if (groupRestaurant.getName().equals("Rays")) {
            raystimes++;
        } else if (groupRestaurant.getName().equals("Chick-fil-a")) {
            chickfilatimes++;
        } else if (groupRestaurant.getName().equals("Twisted Taco")) {
            twistedtimes++;
        } else {
            subwaytimes++;
        }

    }

    public Opinion incrementOpinion (Opinion opinion) {
        if (opinion == Opinion.Medium) {
            return  Opinion.High;
        } else if(opinion == Opinion.Low) {
             return Opinion.Medium;
        }
        return opinion;
    }

    public Opinion decrementOpinion (Opinion opinion) {
        if (opinion == Opinion.Medium) {
           return Opinion.Low;
        } else if(opinion == Opinion.High) {
            return Opinion.Medium;
        }

        return opinion;
    }

    public Restaurant individualArgmax() {
        List<Double> scores = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            scores.add(getRestaurantScore(restaurant));
        }
        double max = pandatimes;
        Restaurant argmax = restaurantList.get(0);
        for (int i = 0; i < scores.size(); i++) {
            double score = scores.get(i);
            if (score > max) {
                max = score;
                argmax = restaurantList.get(i);
            }
        }
        return argmax;
    }

    public void setFoodReason() {
        if (dietPref == DietPref.Vegetarian) {
            foodReason = FoodReason.Vegetarian;
        } else if (nutritionPreference == NutritionPreference.Nutrition) {
            foodReason = FoodReason.Nutrition;
        } else if (emotion == Emotion.Negative) {
            foodReason = FoodReason.Emotion;
        } else if (budget == Budget.Poor) {
            foodReason = FoodReason.Budget;
        } else {
            foodReason = FoodReason.Craving;
        }
    }

    public String composeUserString() {
        //userdata csv userline format: budget ,nutritional preference,dietary preference ,hunger,emotion,panda ls,twisted ls,cfa ls ,rays ls ,subway ls,bad ex,has commitment ,EF trait ,leadership ,deferred gratification ,altruism ,#times at panda ,#times at twisted,#time at cfa,#times at rays ,#times at subway,panda opinion ,twisted opinion ,chickfila opinion,rays opinion ,subway opinion
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb.append(userString[i]);
            sb.append(",");
        }
        for (int i = 0; i < lineSizes.length; i++) {
            sb.append(lineSizes[i]);
            sb.append(",");
        }
        for (int i = 10; i < 14; i++) {
            sb.append(userString[i]);
            sb.append(",");
        }
        sb.append(Integer.toString(this.deferredGratification));
        sb.append(",");
        sb.append(Double.toString(this.altruism));
        sb.append(",");
        sb.append(Integer.toString(this.pandatimes));
        sb.append(",");
        sb.append(Integer.toString(this.twistedtimes));
        sb.append(",");
        sb.append(Integer.toString(this.chickfilatimes));
        sb.append(",");
        sb.append(Integer.toString(this.raystimes));
        sb.append(",");
        sb.append(Integer.toString(this.subwaytimes));
        sb.append(",");
        if (this.pandaOpinion == Opinion.Low) {
            sb.append("1,");
        } else if(this.pandaOpinion == Opinion.Medium) {
            sb.append("2,");
        } else {
            sb.append("3,");
        }
        if (this.twistedOpinion == Opinion.Low) {
            sb.append("1,");
        } else if(this.twistedOpinion == Opinion.Medium) {
            sb.append("2,");
        } else {
            sb.append("3,");
        }
        if (this.chickfilaOpinion == Opinion.Low) {
            sb.append("1,");
        } else if(this.chickfilaOpinion == Opinion.Medium) {
            sb.append("2,");
        } else {
            sb.append("3,");
        }
        if (this.raysOpinion == Opinion.Low) {
            sb.append("1,");
        } else if(this.raysOpinion == Opinion.Medium) {
            sb.append("2,");
        } else {
            sb.append("3,");
        }
        if (this.subwayOpinion == Opinion.Low) {
            sb.append("1,");
        } else if(this.subwayOpinion == Opinion.Medium) {
            sb.append("2,");
        } else {
            sb.append("3,");
        }
        sb.append(userString[26]);
        sb.append('\n');

        return sb.toString();
    }
}
