package net.homework

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import Direction._
import Movement._

@RunWith(classOf[JUnitRunner])
class MowerTest extends Specification{

  "A mower" should {
    
	  "throws an IllegalArgumentException with created with a negative X " in {
	    val lawn = Lawn(Coordinates(5,5))
	    Mower(Position(Coordinates(-1,0),NORTH),lawn) must throwA[IllegalArgumentException]
	  }
	  "throws an IllegalArgumentException with created with a negative Y " in {
	    val lawn = Lawn(Coordinates(5,5))
	    Mower(Position(Coordinates(0,-1),NORTH),lawn) must throwA[IllegalArgumentException]
	  }
	  "throws an IllegalArgumentException with created with an X beyond right lawn limit" in {
	    val lawn = Lawn(Coordinates(5,5))
	    Mower(Position(Coordinates(6,0),NORTH),lawn) must throwA[IllegalArgumentException]
	  }
	   "throws an IllegalArgumentException with created with an X beyond upper lawn limit" in {
	    val lawn = Lawn(Coordinates(5,5))
	    Mower(Position(Coordinates(0,6),NORTH),lawn) must throwA[IllegalArgumentException]
	  }
    
	  "when following its instructions move" in {
	    val lawn = Lawn(Coordinates(5,13))
	    val mower = Mower(Position(Coordinates(0,0),NORTH),lawn)
	   val instructions = List(FORWARD
			   				,FORWARD
			   				,LEFT
			   				,LEFT)
	   val finalPosition = mower.executeInstructions(instructions)
	   finalPosition == Position(Coordinates(0,2),SOUTH)
	  }
	  "following its instructions should stay in the left limit of the lawn" in {
	    val lawn = Lawn(Coordinates(5,13))
	    val mower = Mower(Position(Coordinates(0,0),NORTH),lawn)
	   val instructions = List(LEFT
			   					,FORWARD
			   					,FORWARD
			   					,LEFT)
	   val finalPosition = mower.executeInstructions(instructions)
	   finalPosition == Position(Coordinates(0,0),SOUTH)
	  }
	  "following its instructions should stay in the bottom limit of the lawn" in {
	    val lawn = Lawn(Coordinates(5,13))
	    val mower = Mower(Position(Coordinates(0,0),NORTH),lawn)
	   val instructions = List(LEFT
			   					,LEFT
			   					,FORWARD
			   					,FORWARD)
	   val finalPosition = mower.executeInstructions(instructions)
	   finalPosition == Position(Coordinates(0,0),SOUTH)
	  }
	  "following its instruction should stay under the upper limit of the lawn" in {
	    val upperLeftLimitOfTheLawn = Coordinates(5,13)
	    
	    val lawn = Lawn(upperLeftLimitOfTheLawn)
	    val mower = Mower(Position(upperLeftLimitOfTheLawn,NORTH),lawn)
	   val instructions = List(FORWARD
			   					,FORWARD
			   					,LEFT
			   					,LEFT)
	   val finalPosition = mower.executeInstructions(instructions)
	   finalPosition == Position(upperLeftLimitOfTheLawn,SOUTH)
	  }
	
	  "following its instruction should stay under the most right limit of the lawn" in {
	    val upperLeftLimitOfTheLawn = Coordinates(5,13)
	    
	    val lawn = Lawn(upperLeftLimitOfTheLawn)
	    val mower = Mower(Position(upperLeftLimitOfTheLawn,NORTH),lawn)
	    val instructions = List(RIGHT
	    						,RIGHT
	    						,FORWARD
	    						,FORWARD)
	   val finalPosition = mower.executeInstructions(instructions)
	   finalPosition == Position(Coordinates(5,11),SOUTH)
	  }

  }
  
}