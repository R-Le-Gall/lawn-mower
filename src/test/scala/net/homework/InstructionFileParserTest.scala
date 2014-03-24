package net.homework

import scala.util.Random

import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import Direction._
import Movement._

import scala.util.parsing.combinator._

@RunWith(classOf[JUnitRunner])
class InstructionFileParserTest extends Specification{
  
  case class StringInstructionParser extends InstructionFileParser
  
  "An instruction parser " should {
    "fail to parse an empty String and throw an IllegalArgumentException" in {
      val textToParse  =""
        InstructionExecutor.parseInstructions(textToParse) must throwA[IllegalArgumentException]
    }
   "throw an IllegalArgumentException when parsing random string" in {
     val textToParse =Random.alphanumeric.take(2).mkString
               InstructionExecutor.parseInstructions(textToParse) must throwA[IllegalArgumentException]
   }
   
    "generate only a UpperRight corner if there is no mower intstruction in the String" in {
      val textToParse ="5 5"
        val result = InstructionExecutor.parseInstructions(textToParse)
        result == MowersOnLawnManager(Coordinates(5,5),List())
    }
  }
  
  "generate a complete MowersOnLawnManager from a correct instructions File" in {
    val textToParse = """5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
"""
       val result = InstructionExecutor.parseInstructions(textToParse)
        result == MowersOnLawnManager(Coordinates(5,5)
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
  }
}
