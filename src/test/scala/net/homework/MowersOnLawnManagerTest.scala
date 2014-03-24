package net.homework

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import Direction._
import Movement._
import java.io.PipedOutputStream
import java.io.PrintStream

@RunWith(classOf[JUnitRunner])
class MowersOnLawnManagerTest extends Specification {

  "A manager of mowers on the lawn" should{
	  
    "print the final mowers position with correct instructions" in {
      
      val molm = MowersOnLawnManager(Coordinates(5,5)
            ,List((Position(Coordinates(1,2),NORTH),List(LEFT
            											,FORWARD
            											,LEFT
            											,FORWARD
            											,LEFT
            											,FORWARD
            											,LEFT
            											,FORWARD
            											,FORWARD))
                , (Position(Coordinates(3,3),EAST),List(FORWARD
                										,FORWARD
                										,RIGHT
                										,FORWARD
                										,FORWARD
                										,RIGHT
                										,FORWARD
                										,RIGHT
                										,RIGHT
                										,FORWARD))
            ))
      val stream = new java.io.ByteArrayOutputStream()
      Console.withOut(stream) {  molm.printMowerEndPositions }
      val result = stream.toString() 
        stream.close()
        result == """1 3 N
5 1 E
"""
      }
    
    "throw an error message with incorrect instructions" in {
      val molm = MowersOnLawnManager(Coordinates(5,5),List((Position(Coordinates(-1,0),NORTH),List())))
        molm.printMowerEndPositions must throwA[IllegalArgumentException]
    }
  }
}