<h1 align="center">An adventurer lost in a forest</h1>
<p>
</p>

> This Java project models the movements of a character on a map represented by characters in a UTF-8 text file. The character can move on empty spaces but cannot traverse impassable woods. The initial coordinates of the character and its movements are defined in an input file.

## Prerequisites
- Java 1.8 or later 
- Maven

## How to Use the Program

Download and Compile:

1. Clone this GitHub repository to your machine.
2. Navigate to the project directory.

Running the Program:
1. Run the following command to build the project and create an executable JAR file:
   ` mvn package `

Execute the Program :
1. Navigate to the jar directory.(By default, it will be in the target folder)
2. Make sure you have a file.txt with the adventurer coordinates and direction. 
3. Run the following command to execute the program `java -jar aventurer-1.0.jar aventurier.txt`

Results:
The program will display the final coordinates of the character after its movements.

## Example of input file

- Encodage: UTF-8
- First line :
Initial position of the adventurer : "x,y"
- Second line :
The character's movements are defined as a sequence of cardinal direction characters (N, S, E, O).
Each character corresponds to a one-cell movement.

Here is an example of an input file with the initial coordinates of the character and its movements:

```
3,0
SSSSEEEEEENN
```

By default, you can find the aventurier.txt in the same folder as the jar. 

## Testing

Run the command for testing:
- `mvn test `

