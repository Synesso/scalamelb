package scalamelb.intro

class Duck {
  def walk():Unit = println("~~waddle~~")
  def quack():Unit = println("quack")
}

class Graph {
  def walk():Unit = println("walking each node")
}

class Doctor {
  def quack():Unit = println("hmmm, you need exhaustive surgery!")
}



object DucksOnlyPlease extends Application {
  type DuckType = { def quack():Unit; def walk():Unit; }

  def roastAndPutIntoDeliciousPancakes(duck: DuckType) = {
    println("About to roast this delicious looking duck ")
    duck.quack
    println("Quiet you!")
    duck.walk
    println("Hey, come back here!")
  }

  roastAndPutIntoDeliciousPancakes(new Duck)
//  roastAndPutIntoDeliciousPancakes(new Graph)  // will not compile
//  roastAndPutIntoDeliciousPancakes(new Doctor) // will not compile
}