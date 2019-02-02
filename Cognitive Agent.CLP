;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog

;Some paths we have to use as an example: 


  ;--------------------------------------------------------------------------------------------------------------------------------
  ;Place selection
  
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
  
  (defrule Commitments
  (option 5)
  =>
  (printout t "Do you have a commitment after your lunch break? (Y/N)" crlf)
  (assert (has-Commitment (read))))

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

  (defrule PandaChosenByLineSize
  (or (and (has-Commitment N) (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1))
	  (and (has-Commitment N) (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 1)))
  =>
  (assert (eatAtPanda)))

  (defrule SubwayChosenByLineSize
  (has-Commitment N) (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 1)
  =>
  (assert (eatAtSubway)))

  ;people tended to go here since lines are quick
  (defrule ChickfilaChosenByLineSize
  (or (and (has-Commitment N) (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 2))
	  (and (has-Commitment N) (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 2))
	  (and (has-Commitment N) (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 2))
	  (and (has-Commitment N) (PandaLineSize 2) (SubwayLineSize 2) (ChickfilaLineSize 2))
	  (and (has-Commitment N) (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 1)))
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
  
  (defrule subwayVeggie
  (eatAtSubway) (vegatarian Y) (chooseFoodItemNow)
  =>
  (printout t "You should get the Veggie Delight" crlf)
  (halt))
  
  
  ;---------------
  ;Panda Express items
  (defrule PandaExpressVeggie
  (eatAtPanda) (vegatarian Y) (chooseFoodItemNow)
  =>
  (printout t "You should get fried rice and chow mein" crlf)
  (halt))
  
  
  ;---------------
  ;Chick Fila items
  
  (defrule chickfilaNuggets
  (eatAtChickfila) (chickens Y) (sandwiches N)
  =>
  (printout t "You should get the chicken nuggets" crlf)
  (halt))
  
  (defrule chickfilaDefault
  (eatAtChickfila) (sandwiches Y)
  =>
  (printout t "You should get a chicken sandwich" crlf)
  (halt))
  
  
  