package net.homework

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import Direction._
import Movement._

@RunWith(classOf[JUnitRunner])
class LawnTest extends Specification{
	
  "A lawn" should{
    "throws an IllegalArgumentException when created wiht a negaitve X for its upperRight corner" in{
      Lawn(Coordinates(-1,0)) must throwA[IllegalArgumentException]
    }
    
    "throws an IllegalArgumentException when created wiht a negaitve Y for its upperRight corner" in{
      Lawn(Coordinates(0,-1)) must throwA[IllegalArgumentException]
    }
    
    "give new Coordinates on the border with same Y when given negative X Coordinates" in {
      val lawn = Lawn(Coordinates(5,5))
      val given = Coordinates(-1,3)
      val corrected = lawn.keepCoordinateOnTheLawn(given)
      corrected.x == 0 &&
      corrected.y == given.y
    }
    "give new Coordinates on the border with same X when given negative Y Coordinates" in {
      val lawn = Lawn(Coordinates(5,5))
      val given = Coordinates(2,-1)
      val corrected = lawn.keepCoordinateOnTheLawn(given)
      corrected.y == 0 &&
      corrected.x == given.x
    }
    
        "give new Coordinates on the border with same Y when given beyond lawn limit X Coordinates" in {
      val mostRightLimit = 5
      val lawn = Lawn(Coordinates(mostRightLimit,5))
      val given = Coordinates(6,3)
      val corrected = lawn.keepCoordinateOnTheLawn(given)
      corrected.x == mostRightLimit &&
      corrected.y == given.y
    }
    "give new Coordinates on the border with same X when given beyond lawn limit Y Coordinates" in {
      val mostUpperLimit = 5
      val lawn = Lawn(Coordinates(5,mostUpperLimit))
      val given = Coordinates(2,6)
      println (given)
      val corrected = lawn.keepCoordinateOnTheLawn(given)
      println(corrected)
      corrected.y == mostUpperLimit &&
      corrected.x == given.x
    }
    
  }
}

