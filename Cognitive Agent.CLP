;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog

;Some paths we have to use as an example: 
;  Line size: Select option 5 for line size, then choose 1-1-2 or 1-2-1 or 2-1-1, and it will give a suggestion
;  For a Line size conflict with resolution, Choose option 5 for line size, then 1-1-1-Y-Y, then after choose option for (What I have eaten in the past couple of days), then choose an option to get a suggestion

;Some of the other paths are working wierdly, but we can iron those out in the coming weeks, mainly the conflict resolution paths that go into options 3 and 4 
  

    
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
  (has-Commitment N) (PandaLineSize 2) (SubwayLineSize 1) (ChickfilaLineSize 1)
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
  (printout t "Sending you to Express.")
  (halt))
  
  (defrule SubwayChosen
  (eatAtSubway)
  =>
  (printout t "Sending you to Subway.")
  (halt))
  
  (defrule ChickfilaChosen
  (eatAtChickfila)
  =>
  (printout t "Sending you to Chick-fil-a.")
  (halt))