package scalamelb.intro.chess

trait Role
trait Orientation
case object King extends Role with Orientation
case object Queen extends Role with Orientation
case object Rook extends Role
case object Bishop extends Role
case object Knight extends Role
case object Pawn extends Role

trait Colour
case object White extends Colour with Orientation
case object Black extends Colour with Orientation

object ChessTime extends Application {
  def moveHorizontallyTo(side: Role with Orientation) = println("Moving to the " + side + "'s side")
  def moveVerticallyTo(side: Colour with Orientation) = println("Moving to the " + side + " side")
  def moveDiagonallyTo(colour: Colour with Orientation, role: Role with Orientation) = 
    println("Moving diagonally toward the " + colour + " " + role)
  moveHorizontallyTo(King)
//  moveHorizontallyTo(Rook)
//  moveHorizontallyTo(White)
  moveVerticallyTo(Black)
  moveDiagonallyTo(Black, Queen)
}