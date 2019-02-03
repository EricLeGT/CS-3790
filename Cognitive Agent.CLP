;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog

;Some paths we have to use as an example: 


  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Place selection
  
  (defrule Commitments
  (option 5)
  =>
  (printout t "Do you have a commitment after your lunch break? (Y/N)" crlf)
  (assert (has-Commitment (read))))
  
  (defrule assignPandaLineSize
  (option 5)
  =>
  (printout t "How long is the line at Panda Express? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (PandaLineSize (read))))
  
  (defrule assignSubwayLineSize
  (option 5)
  =>
  (printout t "How long is the line at Subway? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (SubwayLineSize (read))))
  
  (defrule assignChickfilaLineSize
  (option 5)
  =>
  (printout t "How long is the line at Chick-fil-a? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (ChickfilaLineSize (read))))
  
  (defrule notHungry
  (or (is-hungry N)
  	  (cant-eat)
	  (and (has-Commitment Y) (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 1)))
  =>
  (assert (go-and-wait))
  (printout t "You should just go eat later." crlf)
  (halt))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (assert (option 5)))
  
  (defrule Begin
  =>
  (printout t "Imagine you are at the Student Center during lunch time. You have three options to choose
  from for lunch: Panda Express, Chick-fil-a, and Subway.

  Are you feeling hungry (Y/N)" crlf)
  (assert (is-hungry (read))))
  
  ;using nutrition to choose between restaurants with short lines 
  (defrule nutritionConflictRes
  (or (and (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 2))
	  (and (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 1)))
  => 
  (printout t "Do you care about the nutrition value of your food? (Y/N)" crlf)
  (assert (nutrition-value (read))))
  
  ;trying to resolve a conflict by figuring out where the user has eaten most recently 
  
  (defrule recencySubwayChickFila
  (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 2)
  =>
  (printout t "Which place did you eat at most recently? (type a number to select)" crlf "1. Subway" crlf "2. Chick-fil-a" crlf)
  (assert (SubwayVsChickfila (read))))
  
  (defrule recencyPandaChickFila
  (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 2)
  =>
  (printout t "Which place did you eat at most recently? (type a number to select)" crlf "1. Panda" crlf "2. Chick-fil-a" crlf)
  (assert (PandaVsChickfila (read))))
  
  (defrule recencyPandaSubway
  (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 1)
  =>
  (printout t "Which place did you eat at most recently? (type a number to select)" crlf "1. Panda" crlf "2. Subway" crlf)
  (assert (PandaVsSubway (read))))

  (defrule PandaChosenByLineSizeOrRecency
  (or (and (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1) 
      (nutrition-value Y))
      (PandaVsChickfila 2)
      (PandaVsSubway 2))  
  =>
  (assert (eatAtPanda)))

  (defrule SubwayChosenByLineSizeOrRecency
  (or (and (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 1))
      (SubwayVsChickfila 2)
      (PandaVsSubway 1))
  =>
  (assert (eatAtSubway)))

  ;people tended to go here since lines are quick
  (defrule ChickfilaChosenByLineSizeOrRecency
  (or (and (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 2))
  	  (nutrition-value N)
  	  (SubwayVsChickfila 1)
  	  (PandaVsChickfila 2))
  =>
  (assert (eatAtChickfila)))

  (defrule PandaChosen
  (eatAtPanda)
  =>
  (printout t "Sending you to Panda Express." crlf)
  (assert (PlaceChosen)))
  
  (defrule SubwayChosen
  (eatAtSubway)
  =>
  (printout t "Sending you to Subway." crlf)
  (assert (PlaceChosen)))
  
  (defrule ChickfilaChosen
  (eatAtChickfila)
  =>
  (printout t "Sending you to Chick-fil-a." crlf)
  (assert (PlaceChosen)))
  
  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Preference questions   the chooseFoodItemNow makes sure we dont select an item before gatherin all necessary info
  
  (defrule veggies
  (PlaceChosen)
  =>
  (printout t "Are you a vegatarian? (Y/N)" crlf)
  (assert (vegatarian (read))))
  
  (defrule veggiesOptionSelected
  (vegatarian Y)
  =>
  (assert (chooseFoodItemNow)))
  
  (defrule meal-size
  (PlaceChosen)
  =>
  (printout t "Do you want a heavy meal? (Y/N)" crlf)
  (assert (large-meal (read))))
  
  (defrule chickens
  (PlaceChosen)
  =>
  (printout t "Are you feeling some chicken? (Y/N)" crlf)
  (assert (chickens (read))))
  
  (defrule sandwiches
  (PlaceChosen)
  =>
  (printout t "Do you like sandwiches? (Y/N)" crlf)
  (assert (sandwiches (read)) (chooseFoodItemNow)))
  
  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Food Rules
  
  ;---------------
  ;Subway items
  
  (defrule subwayDefault
  (eatAtSubway) (large-meal Y)
  =>
  (printout t "You should get the Meal of the Day" crlf)
  (halt))
  
  (defrule subway-smallmeal
  (eatAtSubway) (large-meal N)
  =>
  (printout t "You should get a chopped salad" crlf)
  (halt))
  
  (defrule subwayVeggie
  (eatAtSubway) (vegatarian Y) (chooseFoodItemNow)
  =>
  (printout t "You should get the Veggie Delight" crlf)
  (halt))
  
  
  
  ;---------------
  ;Panda Express items
  
  (defrule PandaExpressDefault
  (eatAtPanda) (large-meal N)
  =>
  (printout t "You should get some egg rolls" crlf)
  (halt))
  
  (defrule PandaLargeMeal
  (eatAtPanda) (large-meal Y)
  =>
  (printout t "You should get fried rice with a side of honey walnut shrimp and orange chicken" crlf)
  (halt))
  
  (defrule PandaExpressVeggie
  (eatAtPanda) (vegatarian Y) (chooseFoodItemNow)
  =>
  (printout t "You should get fried rice and chow mein" crlf)
  (halt))
  
  
  ;---------------
  ;Chick Fila items
  
  (defrule chickfilaDefault
  (eatAtChickfila) (sandwiches Y) (large-meal Y)
  =>
  (printout t "You should get a chicken sandwich with a side of fries" crlf)
  (halt))
  
  (defrule chickfilaSmallSandwich
  (eatAtChickfila) (sandwiches Y) (large-meal N)
  =>
  (printout t "You should get a chicken sandwich" crlf)
  (halt))
  
  (defrule chickfilaNuggets
  (eatAtChickfila) (chickens Y) (sandwiches N) (large-meal Y)
  =>
  (printout t "You should get the chicken nuggets" crlf)
  (halt))
  
  (defrule chickfilaSmallMealNoSandwich
  (eatAtChickfila) (chickens Y) (sandwiches N) (large-meal N)
  =>
  (printout t "You should get a Market Salad" crlf)
  (halt))
  
  (defrule chickfilaVeggiesMaybe...
  (eatAtChickfila) (vegatarian Y)
  =>
  (printout t "You should get a milk shake with fries" crlf)
  (halt))
