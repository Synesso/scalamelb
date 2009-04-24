package scalamelb.intro

object CheckTheLunches extends Application {

  def checkForPeanuts(condiments: List[String]) = 
    for (condiment <- condiments; if condiment contains "peanut") yield condiment
  
  val condiments = "peanut butter" :: "vegemite" :: "jam" :: Nil
  val withPeanuts = checkForPeanuts(condiments)
  
  println(condiments)
  println(withPeanuts)
  
  def checkFor(condiments: List[String], checklist: List[String]) = {
    for (
      condiment <- condiments; 
      checkitem <- checklist;
      if condiment contains checkitem
    ) yield condiment
  }
  
  val gemsOrButts = checkFor(condiments, "butt" :: "gem" :: Nil)
  println(gemsOrButts)
  
}
