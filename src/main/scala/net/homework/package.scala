package net

package object homework {
object Direction extends Enumeration{
	type Direction = Value
  val NORTH = Value("N")
  val EAST = Value("E")
  val SOUTH = Value("S")
  val WEST = Value("O")
}
object Movement extends Enumeration{
  type Movement = Value
   val FORWARD = Value ("A")
  val LEFT = Value("G")
  val RIGHT = Value("D")
}
}
