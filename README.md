# snake-and-ladder

## Assumptions and Rules:

### Board:
* Board size is 100, it has 100 cells from id 1 to 100.
* Size is configurable.

### Dice:
There are two types of Dice, 
* Straight - it can through any number from one to six on a roll.
* Crooked - it can through only even number which can be 2, 4 or 6 on a roll.

### Snake:
* Start position should be greater than one and less than board size which is 100.
* End position should be less than start size and should not be less than one.
* When Player reaches the cell where snake's start position is located, he will move down to the end position of the snake.

### Player:
* Only one player exists and hardcoded the name as "Player1" as of now, we can take it as input if we introduce more players.
* Player's current position is set to 0.
* Player has 10 chances (MAXIMUM_TURNS) to win the game, after that game will get completed with the appropriate message and MAXIMUM_TURNS is configurable number.
* Player wins the game if he manages to reach the 100th cell within 10 turns.

###  Validations:
* if either start or end position of snake is not valid, it will through the exception and corresponding message will be printed on the console
and then game will get terminated.
* If Dice type is invalid, it will through the exception and game will get terminated.

## Steps to Run the application
* Run `./gradlew clean build` to build the application
* Start the main Application:
* Give valid start and end position to the Snake.
 Valid Start Position = 2 to 99
 Valid End Position = less than the start position and equal/greater than one
* Give Valid Dice type.
  Valid values: Straight or Crooked (Case insensitive)
* Game will get completed if player reaches the maximum turns which is 10 as of now or if player reaches the end of the board which is 100.
* Game will get terminated with error message if any input parameter is invalid.


### Note:
To print messages on the console, I have used System.out.println() instead of adding logger just to keep it simple.




