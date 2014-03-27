package net.homework

import scala.util.parsing.combinator._
import Direction._
import Movement._
import scala.io.Source
import java.io.FileNotFoundException

class InstructionFileParser extends JavaTokenParsers{

	def file : Parser[MowersOnLawnManager] = 
	  upperRightLawnCornerCoordinate~rep(mowerInitAndInstructions) ^^ {
	  		case coor~mii => MowersOnLawnManager(coor,mii)
	  		}

	def upperRightLawnCornerCoordinate : Parser[Coordinates] = 
			wholeNumber~wholeNumber ^^ {case x~y => Coordinates(x.toInt,y.toInt)}

	def mowerInitAndInstructions : Parser[(Position,List[Movement.Value])] = 
	  mowerPosition~instructions ^^ {
		  case mower~instr => (mower,instr)
		}
	  
	
	def mowerPosition : Parser[Position] = 
			wholeNumber~wholeNumber~direction ^^ {case  x~y~p => Position(Coordinates(x.toInt,y.toInt),p)}

	def direction : Parser[Direction.Value] = 
	  """N|S|E|O""".r ^^ {case s => Direction.withName(s)}
	
	def instruct: Parser[Movement.Value] = 
	  """A|G|D""".r ^^ {case s => Movement.withName(s)}
	
	def instructions : Parser[List[Movement.Value]] = rep(instruct)
}

object InstructionExecutor extends InstructionFileParser with App {
  
	def parseInstructions(instructions:String):MowersOnLawnManager={
			parseAll(file, instructions) match {
			  case Success(m, _)		=> m
			  case  NoSuccess(msg,_)	=> throw new IllegalArgumentException(
                                     s"Could not parse '$instructions': $msg")
			}
	}
	try{
	val fileContent = Source.fromFile(args(0)).mkString

	val elem = parseInstructions(fileContent)
	elem .printMowerEndPositions()
	} catch{
	  case e: ArrayIndexOutOfBoundsException => println("veuillez indiquez un fichier à utiliser.")
	  case e: FileNotFoundException => println(s"le fichier '${args(0)}' n'existe pas.")
	  case e: IllegalArgumentException => println(s"le fichier d'instructions '${args(0)}' n'est pas correctement formé.")
	}
	
}
