package scalamelb.intro

trait Month
case object January extends Month
case object February extends Month
case object March extends Month
case object April extends Month
case object May extends Month
case object June extends Month
case object July extends Month
case object August extends Month
case object September extends Month
case object October extends Month
case object November extends Month
case object December extends Month
case object Movember extends Month

trait TimeCount
case class DayCount(count: Double) extends TimeCount
case class WeekCount(count: Double) extends TimeCount

class Months(year: Int) {
  def numberOfDaysIn(m: Month) = {
    m match {
      case September | April | June | November => DayCount(30)
      case January | March | May | July | August | October | December => DayCount(31)
      case February => {
        if (year % 4 == 0 && year % 1000 != 0) DayCount(29) else DayCount(28)
      }
      case _ => throw new IllegalArgumentException("Unknown month " + m)
    }
  }
}


object MonthsTest extends Application {
  
  val thisYear = new Months(2009)
  println("thisYear numberOfDaysIn August=" + (thisYear numberOfDaysIn August))
  println("thisYear numberOfDaysIn February=" + (thisYear numberOfDaysIn February))
  
  val lastYear = new Months(2008)
  println("lastYear numberOfDaysIn February=" + (thisYear numberOfDaysIn February))
//  println("lastYear numberOfDaysIn Movember=" + (thisYear numberOfDaysIn Movember)) // will throw illegal argument exception
  
  val countOfDaysInMarch = thisYear numberOfDaysIn March
  def numberOfHours(count: TimeCount): Double = {
    count match {
      case DayCount(n) => 24.0 * n
      case WeekCount(n) => numberOfHours(DayCount(7.0 * n))
    }
  }
  
  println("Hours in March = " + numberOfHours(countOfDaysInMarch))
}


