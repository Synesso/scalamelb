package scalamelb.intro

class UpperCaseCharAwareString(s: String) {
  def withoutUpperCaseChars = new String(for (c <- s.toCharArray) yield if (c.isUpperCase) '_' else c) 
}

object ReverseIt extends Application {
  println("Evian".reverse) // embedded implicit from Scala's RichString
//  println("PonyClub".withoutUpperCaseChars) // will not compile
  implicit def makeStringCharAware(s: String) = new UpperCaseCharAwareString(s)
  println("PonyClub".withoutUpperCaseChars)
}