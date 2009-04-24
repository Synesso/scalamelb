package scalamelb.intro

trait Television {
  def turnOn = println("powered on")
}

trait Colour {
  def adjustBrightness = println("brightness adjusted")
}

trait FlatScreen {
  def mountOnWall = println("mounted on wall")
}

class Bravia extends Television with Colour with FlatScreen 

object MyBravia extends Application {
  val tele = new Bravia
  tele.mountOnWall
  tele.turnOn
  tele.adjustBrightness
}