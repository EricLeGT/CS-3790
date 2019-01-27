;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog
;For now just answer either N or Y and the program will end
  
  
  
  
  
  ;We are resolving the time conflict issue by trying a create a more specific rule that can be used to make a decision
  (defrule TimeToEat
  (timeConflictResolve Y)
  =>
  (printout t "Which one of factors is your second priority when choosing a dining location to eat at? 
  (please type in the number to select)" crlf "1. What I have eaten in the past couple of days" crlf "2. Price" crlf
  "3. Nutrition" crlf "4. Cravings" crlf)
  (assert (priority-two (read))))
  
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
  (priority 5)
  =>
  (printout t "How long is the line at Panda Express? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (PandaLineSize (read))))
  
  (defrule assignSubwayLineSize
  (priority 5)
  =>
  (printout t "How long is the line at Subway? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (SubwayLineSize (read))))
  
  (defrule assignChickfilaLineSize
  (priority 5)
  =>
  (printout t "How long is the line at Chick-fil-a? (type a number to select)" crlf "1. Long" crlf "2. Short" crlf)
  (assert (ChickfilaLineSize (read))))
  
  (defrule nutritionDecision
  (or (priority 3) (priority-two 3))
  =>
  (printout t "Which restaurant do you think has the most nutritious food? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule recencyDecision
  (or (priority 1) (priority-two 1))
  (or (priority 1) (priority-two 1))
  =>
  (printout t "Which restaurant have you not eaten at recently? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule priceDecision
  (or (priority 2) (priority-two 2))
  =>
  (printout t "Which restaurant has the cheapest food? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule cravingsDecision
  (or (priority 4) (priority-two 4))
  =>
  (printout t "Which one of these dining options are you craving? (please type in the number to select)" crlf
  "1. Panda Express" crlf "2. Chick-fil-a" crlf "3. Subway" crlf)
  (assert (diningDecision (read))))
  
  (defrule Commitments
  (priority 5)
  =>
  (printout t "Do you have a commitment after your lunch break? (Y/N)" crlf)
  (assert (has-Commitment (read))))

  (defrule notHungry
  (or (is-hungry N)
  	  (cant-eat))
  =>
  (assert (go-and-wait))
  (printout t "You should just go eat later." crlf)
  (halt))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (printout t "Which one of these factors is your first priority when choosing a dining location to eat at? 
  (please type in the number to select)" crlf "1. Food variety" crlf "2. Price" crlf
  "3. Nutrition" crlf "4. Cravings" crlf "5. Line size"
  crlf)
  (assert (priority (read))))
  
  (defrule Begin
  =>
  (printout t "Imagine you are at the Student Center during lunch time. You have three options to choose
from for lunch: Panda Express, Chick-fil-a, and Subway.

Are you feeling hungry (Y/N)" crlf)
  (assert (is-hungry (read))))
  
  (defrule PandaChosen
  (has-Commitment Y) (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1)
  =>
  (printout t "You should eat at Panda Express.")
  (halt))

  (defrule SubwayChosen
  (has-Commitment Y) (PandaLineSize 1) (SubwayLineSize 2) (ChickfilaLineSize 1)
  =>
  (printout t "You should eat at Subway.")
  (halt))

  (defrule ChickfilaChosen
  (has-Commitment Y) (PandaLineSize 1) (SubwayLineSize 1) (ChickfilaLineSize 2)
  =>
  (printout t "You should eat at Chick-fil-a.")
  (halt))

  (defrule PandaChosen
  (diningDecision 1)
  =>
  (printout t "You should eat at Panda Express.")
  (halt))
  
  (defrule ChickfilaChosen
  (diningDecision 2)
  =>
  (printout t "You should eat at Chick-fil-a.")
  (halt))

  (defrule SubwayChosen
  (diningDecision 3)
  =>
  (printout t "You should eat at Subway.")
  (halt))
  
