;--------------------------------------------------------------------------------------------------------------------------------
  ;Place selection
  
  (defrule Start
  =>
  (printout t "Imagine you are at the Student Center during lunch time. You have three options to choose
  from for lunch: Panda Express, Chick-fil-a, and Subway.

  Are you feeling hungry (Y/N)" crlf)
  (assert (is-hungry (read))))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (assert (option 5)))
  
  (defrule timeAvailable
  (option 5)
  =>
  (printout t "Do you have a commitment after your lunch break? (Y/N)" crlf)
  (assert (has-Time (read))))
  
  (defrule eatLater
  (or (is-Hungry N)
      (and (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 1)))
  =>
  (printout t "You should just go eat later." crlf)
  (halt))
  
  (defrule assignPandaLineSize
  (has-Time N)
  =>
  (printout t "How long is the line at Panda Express? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (PandaLineSize (read))))
  
  (defrule assignSubwayLineSize
  (has-Time N)
  =>
  (printout t "How long is the line at Subway? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (SubwayLineSize (read))))
  
  (defrule assignChickfilaLineSize
  (has-Time N)
  =>
  (printout t "How long is the line at Chick-fil-a? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (ChickfilaLineSize (read))))
  
  (defrule careNutrition
  (or (has-Time Y)
      (or (and (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 1))
	      (and (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 2))
		  (and (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 2))
		  (and (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 2))))
  =>
  (printout t "Do you care about the nutrition of the food you eat? (Y/N)" crlf)
  (assert (care-Nutrition (read))))
  
  (defrule selectNutritious_1
  (declare (salience 300))
  (and (care-Nutrition Y) (or (has-Time Y) (SubwayLineSize 2)))
  =>
  (printout t "Sending you to Subway." crlf)
  (assert (PlaceChosen 1))
  (assert (chosenPlace Subway)))
  
  (defrule selectNutritious_2
  (declare (salience 200))
  (and (care-Nutrition Y) (not (PlaceChosen 1)) (PandaLineSize 2))
  =>
  (assert (chosenPlace Panda))
  (assert (PlaceChosen 1))
  (printout t "Sending you to Panda Express." crlf))
  
  (defrule selectNutritious_3
  (declare (salience 100))
  (and (care-Nutrition Y) (not (PlaceChosen 1)) (ChickfilaLineSize 2))
  =>
  (assert (chosenPlace Chickfila))
  (assert (PlaceChosen 1))
  (printout t "Sending you to Chick-fil-a." crlf))
  
  ;conflict resolution based on price  
  (defrule lastEat_1
  (and (care-Nutrition N) (not (PlaceChosen 1)) (or (has-Time Y) 
                              (and (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 2))))
  =>
  (printout t "Where did you eat last? " crlf "1. Chick-fil-a" crlf "2. Subway" crlf "3. Panda Express" crlf)
  (if (= (read) 1)
     then
	 (assert (chosenPlace Subway))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Subway." crlf)
	 else
	 (assert (chosenPlace Chickfila))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Chick-fil-a." crlf)))
   
  (defrule lastEat_2
  (and (care-Nutrition N) (has-Time N) (not (PlaceChosen 1)) (PandaLineSize 2) (SubwayLineSize 2))
  =>
  (printout t "Where did you eat last? " crlf "1. Panda Express" crlf "2. Subway" crlf)
  (if (= (read) 1)
     then
	 (assert (chosenPlace Subway))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Subway." crlf)
	 else
	 (assert (chosenPlace Panda))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Panda Express." crlf)))
  
  (defrule lastEat_3
  (and (care-Nutrition N) (has-Time N) (not (PlaceChosen 1)) (PandaLineSize 2) (ChickfilaLineSize 2))
  =>
  (printout t "Where did you eat last? " crlf "1. Chick-fil-a" crlf "2. Panda Express" crlf)
  (if (= (read) 1)
     then
	 (assert (chosenPlace Panda))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Panda Express." crlf)
	 else
	 (assert (chosenPlace Chickfila))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Chick-fil-a." crlf)))
  
  (defrule lastEat_4
  (and (care-Nutrition N) (has-Time N) (not (PlaceChosen 1)) (SubwayLineSize 2) (ChickfilaLineSize 2))
  =>
  (printout t "Where did you eat last? " crlf "1. Chick-fil-a" crlf "2. Subway" crlf)
  (if (= (read) 1)
     then
	 (assert (chosenPlace Subway))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Subway." crlf)
	 else
	 (assert (chosenPlace Chickfila))
	 (assert (PlaceChosen 1))
     (printout t "Sending you to Chick-fil-a." crlf)))
	 
  (defrule lineSelect_1
  (and (has-Time N) (not (PlaceChosen 1)) (and (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1)))
  =>
  (assert (chosenPlace Panda))
  (assert (PlaceChosen 1))
  (printout t "Sending you to Panda Express." crlf))
  
  (defrule lineSelect_2
  (and (has-Time N) (not (PlaceChosen 1)) (and (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 1)))
  =>
  (assert (chosenPlace Subway))
  (assert (PlaceChosen 1))
  (printout t "Sending you to Subway." crlf))
  
  (defrule lineSelect_3
  (and (has-Time N) (not (PlaceChosen 1)) (and (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 2)))
  =>
  (assert (chosenPlace Chickfila))
  (assert (PlaceChosen 1))
  (printout t "Sending you to Chick-fil-a." crlf))
  
  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Preference questions   the chooseFoodItemNow makes sure we dont select an item before gatherin all necessary info
  
  (defrule vegan
  (PlaceChosen 1)
  =>
  (printout t "Are you vegan? (Y/N)" crlf)
  (assert (is-Vegan (read))))
  
  (defrule vegetarian
  (is-Vegan N)
  =>
  (printout t "Are you vegetarian? (Y/N)" crlf)
  (assert (is-Vegetarian (read))))
  
  (defrule pescatarian
  (is-Vegetarian N)
  =>
  (printout t "Are you pescatarian? (Y/N)" crlf)
  (assert (is-Pescatarian (read))))
  
  (defrule heavyLightMeal
  (or (is-Vegan Y) (is-Vegatarian Y) (is-Pescatarian Y) (is-Pescatarian N))
  =>
  (printout t "Do you want to have a heavy or light meal?" crlf "1. heavy meal" crlf "2. light meal" crlf)
  (assert (meal-size (read))))
  
  (defrule chicken
  (and (PlaceChosen 1) (is-Vegan N) (is-Vegetarian N) (is-Pescatarian N) (meal-size Y) (meal-size N))
  =>
  (printout t "Are you feeling some chicken? (Y/N)" crlf)
  (assert (chicken (read))))
  
  (defrule sandwich
  (or (meal-size 1) (meal-size 2))
  =>
  (printout t "Do you like sandwiches (Y/N)" crlf)
  (assert (sandwich (read)))
  (assert (chooseFoodItemNow 1)))
  
  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Food Rules
  
  ;---------------
  ;Subway items
  
  (defrule subwayVeggie
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Subway) (is-Vegatarian Y))
  =>
  (printout t "You should get the Veggie Delight" crlf)
  (halt))
  
  (defrule subwayVeggie
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Subway) (is-Pescatarian Y))
  =>
  (printout t "You should get the Classic Tuna sandwich" crlf)
  (halt))
  
  (defrule subwayDefault
  (and (chooseFoodItemNow 1) (chosenPlace Subway) (meal-size 1))
  =>
  (printout t "You should get the Meal of the Day" crlf)
  (halt))
  
  (defrule subway-smallmeal
  (and (chooseFoodItemNow 1) (chosenPlace Subway) (or (is-Vegan) (meal-size 2)))
  =>
  (printout t "You should get a chopped salad" crlf)
  (halt))

  ;---------------
  ;Panda Express items
  
  (defrule Panda-smallmeal
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (not (is-Vegan Y)) (chosenPlace Panda) (meal-size 2))
  =>
  (printout t "You should get some egg rolls" crlf)
  (halt))
  
  (defrule Panda-vegmeal
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (or (is-Vegatarian Y) (is-Vegan Y)) (chosenPlace Panda))
  =>
  (printout t "You should get fried rice with egglplant tofu" crlf)
  (halt))
  
  (defrule PandaPescatarianMeal
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Panda) (is-Pescatarian Y))
  =>
  (printout t "You should get fried rice with honey walnut shrimp" crlf)
  (halt))
  
  (defrule PandaChickenMeal
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Panda) (chicken Y))
  =>
  (printout t "You should get grilled teriyaki chicken and kung pao chicken" crlf)
  (halt))
  
  (defrule PandaDefaultMeal
  (and (chooseFoodItemNow 1) (chosenPlace Panda) )
  =>
  (printout t "You should get chow mein and sweetfire chicken breast" crlf)
  (halt))
  
  
  
  ;---------------
  ;Chick Fila items
  
  (defrule chickfilaDefault
  (and (chooseFoodItemNow 1) (chosenPlace Chickfila) (sandwich Y) (meal-size 1))
  =>
  (printout t "You should get a chicken sandwich with a side of fries" crlf)
  (halt))
  
  (defrule chickfilaSmallSandwich
  (declare (salience 200))
  (and (chosenPlace Chickfila) (chicken Y) (sandwich Y) (meal-size 1))
  =>
  (printout t "You should get a chicken sandwich" crlf)
  (halt))
  
  (defrule chickfilaNuggets
  (declare (salience 200))
  (and (chosenPlace Chickfila) (chicken Y) (sandwich N) (meal-size 1))
  =>
  (printout t "You should get the chicken nuggets" crlf)
  (halt))

  (defrule waffleFries
  (declare (salience 200))
  (and (chosenPlace Chickfila) (chicken N) (sandwich N) (meal-size 2))
  =>
  (printout t "You should get some waffle fries" crlf)
  (halt))

  (defrule chickfilaSmallMealNoSandwich
  (declare (salience 200))
  (and (chooseFoodItemNow 1) (chosenPlace Chickfila) (chicken Y) (or (sandwich N) (meal-size 2)))
  =>
  (printout t "You should get a Market Salad" crlf)
  (halt))
  
  (defrule chickfilaVeggies
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Chickfila) (is-Vegatarian Y))
  =>
  (printout t "You should get a milk shake with fries" crlf)
  (halt))
  
  (defrule chickfilaPescatarian
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Chickfila) (is-Pescatarian Y))
  =>
  (printout t "You should get the Chick-fil-a Fish sandwich with fries" crlf)
  (halt))
  
  (defrule chickfilaVegan
  (declare (salience 300))
  (and (chooseFoodItemNow 1) (chosenPlace Chickfila) (is-Vegan Y))
  =>
  (printout t "You should get a milk shake with fries" crlf)
  (halt))