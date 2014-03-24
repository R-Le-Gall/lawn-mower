package net.homework

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import Direction._
import Movement._

@RunWith(classOf[JUnitRunner])
class PositionTest extends Specification{

  	"A Position" should {
		"give NORTH direction when compute FORWARD move and when  inital direction is NORTH" in {
		  val position = Position(Coordinates(0,0),NORTH)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.direction == NORTH
		}
		"give WEST direction when compute LEFT move and when initial direction is NORTH" in {
		  val position = Position(Coordinates(0,0),NORTH)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.direction == WEST
		}
		"give EAST direction when compute RIGHT move and when initial direction is NORTH" in {
		  val position = Position(Coordinates(0,0), NORTH)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.direction == EAST
		}
		
	  "give SOUTH direction when compute FORWARD move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0),SOUTH)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.direction == SOUTH
		}
		"give EAST direction when compute LEFT move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0),SOUTH)
		  val fp = position.computeNextDirection(LEFT)
		  fp.direction == EAST
		}
		"give WEST direction when compute RIGHT move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0), SOUTH)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.direction == WEST
		}
		
		"give EAST direction when compute FORWARD move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0),EAST)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.direction == EAST
		}
		"give NORTH direction when compute LEFT move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0),EAST)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.direction ==  NORTH
		}
		"give SOUTH direction when compute RIGHT move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0), EAST)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.direction == SOUTH
		}
		
		"give WEST direction when compute FORWARD move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0),WEST)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.direction == WEST
		}
		"give SOUTH direction when compute LEFT move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0),WEST)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.direction == SOUTH
		}
		"give NORTH direction when compute RIGHT move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0), WEST)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.direction == NORTH
		}
		
		"add 1 in the y coordinates direction when compute FORWARD move and when  inital direction is NORTH" in {
		  val position = Position(Coordinates(0,0),NORTH)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.coordinates == Coordinates(0,1)
		}
		"keep coordinates unchanged when compute LEFT move and when initial direction is NORTH" in {
		  val position = Position(Coordinates(0,0),NORTH)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.coordinates == Coordinates(0,0)
		}
		"keep coordinates unchanged when compute RIGHT move and when initial direction is NORTH" in {
		  val position = Position(Coordinates(0,0), NORTH)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.coordinates == Coordinates(0,0)
		}
		
	  "remove 1 in the y coordinates when compute FORWARD move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0),SOUTH)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.coordinates == Coordinates(0,-1)
		}
		"keep coordinates unchanged when compute LEFT move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0),SOUTH)
		  val finalPosition = position.computeNextDirection(LEFT)
		  finalPosition.coordinates == Coordinates(0,0)
		}
		"keep coordinates unchanged when compute RIGHT move and when  inital direction is SOUTH" in {
		  val position = Position(Coordinates(0,0), SOUTH)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.coordinates == Coordinates(0,0)
		}
		
		"add 1 in the x coordinates direction when compute FORWARD move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0),EAST)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.coordinates == Coordinates(1,0)
		}
		"keep coordinates unchanged when compute LEFT move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0),EAST)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.coordinates == Coordinates(0,0)
		}
		"keep coordinates unchanged when compute RIGHT move and when  inital direction is EAST" in {
		  val position = Position(Coordinates(0,0), EAST)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.coordinates == Coordinates(0,0)
		}
		
		"remove 1 in the x coordinates when compute FORWARD move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0),WEST)
		  val finalPosition = position.computeNextDirection(FORWARD) 
		  finalPosition.coordinates == Coordinates(-1,0)
		}
		"keep coordinates unchanged when compute LEFT move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0),WEST)
		  val finalPosition = position.computeNextDirection(LEFT) 
		  finalPosition.coordinates == Coordinates(0,0)
		}
		"keep coordinates unchanged when compute RIGHT move and when  inital direction is WEST" in {
		  val position = Position(Coordinates(0,0), WEST)
		  val finalPosition = position.computeNextDirection(RIGHT)
		  finalPosition.coordinates == Coordinates(0,0)
		}
	}
  
}