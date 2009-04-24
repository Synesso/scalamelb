package scalamelb.intro

class Persian(age: Double, val name: String) {
  def this(name: String) = this(1.0, name)
  def meow= { println("Meow")  }
}

object Cat extends Application {
  val mixxy = new Persian(2.0, "Mixxy")
  println(mixxy.name + " is about to say something ... ")
  mixxy.meow
// println(mixxy.age)  // will not compile
// mixxy = new Persian(6.5, "Bernard")  // will not compile
  var cat = mixxy
  cat = new Persian(6.5, "Bernard")
}

