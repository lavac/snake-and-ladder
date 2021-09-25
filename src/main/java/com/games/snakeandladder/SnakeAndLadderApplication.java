package com.games.snakeandladder;

import com.games.snakeandladder.entity.*;
import com.games.snakeandladder.exception.InvalidDiceTypeException;
import com.games.snakeandladder.exception.InvalidSnakeEndPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
import java.util.Scanner;
import static com.games.snakeandladder.Constants.DEFAULT_SIZE;
import static com.games.snakeandladder.Constants.PLAYER_NAME;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);

      SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);

      System.out.println("How many snakes you want to add ");
      int numberOfSnakes = scanner.nextInt();
      for(int i=0; i < numberOfSnakes; i++) {
        System.out.println("Enter Snake's start position (from 2 to 99) and end position (less than start position)");
        int startPosition = scanner.nextInt();
        int endPosition = scanner.nextInt();

        Snake snake = new Snake();
        snake.setStartPosition(startPosition);
        snake.setEndPosition(endPosition);
        snakeAndLadderBoard.addSnake(snake);
      }
      Player player = new Player(PLAYER_NAME);

      System.out.println("Enter Dice type: Valid values are Straight and Crooked");
      String diceTypeInString = scanner.next();

      DiceType diceType = DiceType.getDiceType(diceTypeInString);
      Dice dice = DiceFactory.get(diceType);
      SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);

      snakeAndLadderGame.start();
    } catch (InvalidSnakeStartPositionException
        | InvalidSnakeEndPositionException
        | InvalidDiceTypeException exception) {
      System.out.println(exception.getMessage());
    } catch (Exception ex) {
      System.out.println("Unexpected error occurred with message: " + ex.getMessage());
    }
  }
}
