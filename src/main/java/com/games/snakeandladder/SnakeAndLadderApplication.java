package com.games.snakeandladder;

import com.games.snakeandladder.entity.*;
import com.games.snakeandladder.exception.*;

import java.io.File;
import java.util.Scanner;
import static com.games.snakeandladder.Constants.DEFAULT_SIZE;
import static com.games.snakeandladder.Constants.PLAYER_NAME;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    try {
      File file = new File("src/main/java/com/games/snakeandladder/input/inputData.csv");
      Scanner sc = new Scanner(file);
      sc.useDelimiter(",");
      SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);

      int numberOfSnakes = sc.nextInt();

      for(int i=0; i < numberOfSnakes; i++) {
        int startPosition = sc.nextInt();
        int endPosition = sc.nextInt();
        Obstacle snake = new Snake();
        snake.setStartPosition(startPosition);
        snake.setEndPosition(endPosition);
        snakeAndLadderBoard.addObstacle(snake);
      }

      int numberOfLadders = sc.nextInt();

      for(int i=0; i < numberOfLadders; i++) {
        int startPosition = sc.nextInt();
        int endPosition = sc.nextInt();

        Obstacle ladder = new Ladder();
        ladder.setStartPosition(startPosition);
        ladder.setEndPosition(endPosition);
        snakeAndLadderBoard.addObstacle(ladder);
      }

      Player player = new Player(PLAYER_NAME);

      String diceTypeInString = sc.next();

      DiceType diceType = DiceType.getDiceType(diceTypeInString);
      Dice dice = DiceFactory.get(diceType);
      SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);

      snakeAndLadderGame.start();
      sc.close();
    }
    catch (InvalidSnakeStartPositionException
        | InvalidSnakeEndPositionException
        | InvalidDiceTypeException
        | InvalidLadderStartPositionException
        | InvalidLadderEndPositionException exception) {
      System.out.println(exception.getMessage());
    } catch (Exception ex) {
      System.out.println("Unexpected error occurred with message: " + ex.getMessage());
    }
  }
}
