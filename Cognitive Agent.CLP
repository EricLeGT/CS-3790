;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog

;Some paths we have to use as an example: 
;  Line size: Select option 5 for line size, then choose 1-1-2 or 1-2-1 or 2-1-1, and it will give a suggestion
;  For a Line size conflict with resolution, Choose option 5 for line size, then 1-1-1-Y-Y, then after choose option for (What I have eaten in the past couple of days), then choose an option to get a suggestion

;Some of the other paths are working wierdly, but we can iron those out in the coming weeks, mainly the conflict resolution paths that go into options 3 and 4 
  
  
  ;We are resolving the time conflict issue by trying a create a more specific rule that can be used to make a decision
  (defrule TimeToEat
  (or (timeConflictResolve Y) (has-Commitment N))
  =>
  (printout t "Which one of factors is your second option when choosing a dining location to eat at? 
  (please type in the number to select)" crlf "1. What I have eaten in the past couple of days" crlf "2. Price" crlf
  "3. Nutrition" crlf "4. Cravings" crlf)
  (assert (option-two (read))))
  
  (defrule noTimeToEat
  (timeConflictResolve N)
  =>
  (assert (cant-eat)))

  ;There is a conflict when you care about the line size, you have a commitment after your break and the lines at all restaurants are too long 
  (defrule timeConflict
  (has-Commitment Y)
  (PandaLineSize 1)
  (SubwayLineSize 1)
  (ChickfilaLineSize 1)
  =>
  (printout t "You seem to be on a time crunch and all the restaurants have long lines, 
are you sure you really need to eat lunch? (Y/N)" crlf)
  (assert (timeConflictResolve (read))))
    
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
  
  (defrule nutritionDecision
  (or (option 3) (option-two 3))
  =>
  (printout t "Which restaurant do you think has the most nutritious food? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule recencyDecision
  (or (option 1) (option-two 1))
  (or (option 1) (option-two 1))
  =>
  (printout t "Which restaurant have you not eaten at recently? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule priceDecision
  (or (option 2) (option-two 2))
  =>
  (printout t "Which restaurant has the cheapest food? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule cravingsDecision
  (or (option 4) (option-two 4))
  =>
  (printout t "Which one of these dining options are you craving? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule Commitments
  (option 5)
  =>
  (printout t "Do you have a commitment after your lunch break? (Y/N)" crlf)
  (assert (has-Commitment (read))))

  (defrule notHungry
  (or (is-hungry N)
  	  (cant-eat)
	  (timeConflictResolve N))
  =>
  (assert (go-and-wait))
  (printout t "You should just go eat later." crlf)
  (halt))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (printout t "Which one of these factors is your first option when choosing a dining location to eat at? 
  (please type in the number to select)" crlf "1. Food variety" crlf "2. Price" crlf
  "3. Nutrition" crlf "4. Cravings" crlf "5. Line size"
  crlf)
  (assert (option (read))))
  
  (defrule Begin
  =>
  (printout t "Imagine you are at the Student Center during lunch time. You have three options to choose
  from for lunch: Panda Express, Chick-fil-a, and Subway.

  Are you feeling hungry (Y/N)" crlf)
  (assert (is-hungry (read))))

  (defrule PandaChosenByLineSize
  (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1)
  =>
  (printout t "You should eat at Panda Express.")
  (halt))

  (defrule SubwayChosenByLineSize
  (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 1)
  =>
  (printout t "You should eat at Subway.")
  (halt))

  (defrule ChickfilaChosenByLineSize
  (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 2)
  =>
  (printout t "You should eat at Chick-fil-a.")
  (halt))

  (defrule PandaChosen
  (diningDecision 1)
  =>
  (printout t "You should eat at Panda Express.")
  (halt))
  
  (defrule SubwayChosen
  (diningDecision 3)
  =>
  (printout t "You should eat at Subway.")
  (halt))
  
  (defrule ChickfilaChosen
  (diningDecision 3)
  =>
  (printout t "You should eat at Chick-fil-a.")
  (halt))