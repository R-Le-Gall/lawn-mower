## Lawn mower

### Requirements 

This is the simulation of an automatic lawn mower used on a rectangular field.
The mower is programmed using an instruction file. Those instructions give the coordinates of the upper left corner of the Lawn, the position of the mower on the lawn and the moves to be executed by the mower.

#### Coordinates
The different coordinate (upper left corner and for the mower) are a pair of positive integers (minimum is 0) and separated by a space. The first Integer is the abscissa or X and the second is the ordinate or Y.

*example :*

	12 3

#### Mower position
The position of a mower is defined by its coordinate on the lawn and its direction.
The direction is a letter refering a cardinality :

* N for North
* E for East
* W for West
* S for South.

*example :*

	0 0 N

for a mower in the lower right corner and heading to the North.

#### Mower Moves
A serie of letters controls the mower moves. There are 3 letters corresponding to french words. 

* A for "Avancer" i.e. move Forward.
* D for "Droite" i.e. a 90° rotation on the right.
* G for "Gauche" i.e. a 90 ° rotation on the left.

Those letters are set in sequence without space.

*example :*
 
	AADAG 

for 2 forward move, a rotation on the right, a forward move and finaly a rotation on the  

#### Instruction File

The first line is dedicated to the definition of the upper left corner.
Then there are 2 lines for the target/scala-2.10/lawn mower instructions. There can be several couple line for several lawn mower instructions on the same lawn.
The first line of this pair of lines is dedicated to the position of the lawn mower.
The second one is a string of mower movs.

*example :*

	5 5
	1 2 N
	GAGAGAGAA
	3 3 E
	AADAADADDA

#### Result
When the instructions have been computed each mower give its final posistion(coordinate and direction).

*The result expected for the previous example is :*

	1 3 N
	5 1 E

### Notes
For simplicity, a set of lawn + mower is computed as if each mower is put on the lawn, followes its instruction and then rewoved. There is no management of collision or supporosition.

### Needed

* scala 2.10 +
* sbt 0.12 +

### Usage

#### Jar creation
    > sbt package

#### Utilisation
    > scala target/scala-2.10/lawn-mower_2.10-0.1.jar LawnMowerInstructions.txt
    > 4 8 N
    > 5 10 S
    > 8 4 S

where `LawnMowerInstructions.txt` is the instruction file, The following lines are returned by the program.

# TODO

* convert tests to Scala Test.
* set some logs and use something else than println.