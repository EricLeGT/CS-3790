;Start CLIPS
;load up into CLIPS 
;click on the gear icon
;click on "load buffer" 
;type in (run) in the dialog
;For now just answer either N or Y > (some number) and the program will end


  (deftemplate Time (slot hour))
;just a base start for the Cog agent

  (defrule Begin
  =>
  (printout t "Are you feeling hungry (Y/N)" crlf)
  (assert (is-hungry (read))))
  
  (defrule notHungry
  (is-hungry N)
  =>
  (assert (go-and-wait))
  (printout t "Just go eat later LOL"))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (printout t "What time is it (Enter just the hour ex. 3 for 3 PM)" crlf)
  (bind ?hour (read))
  (assert (Time (hour ?hour))))
  
  (defrule DietaryRestriction
  (is-hungry Y)
  =>
  (printout t "Are you pescatarian (Y/N)" crlf)
  (assert (is-pescatarian (read))))
  
  (defrule isPescatarian
  (is-pescatarian Y)
  =>
  (printout t "Go eat at Subway" crlf) 
  (assert (end)))
  
  (defrule notPescatarian
  (is-Pescatarian N) 
  => 
  (printout t "Go eat at Chick-fil-a") crlf
  (assert (end)))
  
  (defrule End
  (end)
  =>
  (printout t "This is as far as we got LOL")(halt))
  
