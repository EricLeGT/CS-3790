;Start CLIPS
;load up into CLIPS then RUN
;For now just answer either N or Y > (some number) and the program will end


  (deftemplate Time (slot hour))
;just a base start for the Cog agent

  (defrule Begin
  =>
  (printout t "Are you feeling hungry (Y/N)")
  (assert (is-hungry (read))))
  
  (defrule notHungry
  (is-hungry N)
  =>
  (assert (go-and-wait))
  (printout t "Just go eat later LOL"))
  
  (defrule isHungry
  (is-hungry Y)
  =>
  (printout t "What time is it (Enter just the hour ex. 3 for 3 PM)")
  (bind ?hour (read))
  (assert (Time (hour ?hour)))
  (assert (end)))
  
  (defrule End
  (end)
  =>
  (printout t "This is as far as we got LOL")(halt))
  