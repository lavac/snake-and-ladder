package com.games.snakeandladder;

import com.games.snakeandladder.entity.*;
import com.games.snakeandladder.exception.InvalidDiceTypeException;
import com.games.snakeandladder.exception.InvalidSnakeEndingPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;
import java.util.Scanner;
import static com.games.snakeandladder.Constants.DEFAULT_SIZE;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      int startingIndex = scanner.nextInt();
      int endingIndex = scanner.nextInt();
      Snake snake = new Snake();
      snake.setStartingPosition(startingIndex);
      snake.setEndingPosition(endingIndex);
      SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);
      snakeAndLadderBoard.addSnake(snake);
      Player player = new Player("Player1");
      String diceType = scanner.next();
      DiceType diceType1 = DiceType.getDiceType(diceType);
      Dice dice = DiceFactory.get(diceType1);
      SnakeAndLadderGame game = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);
      game.start();
    } catch (InvalidSnakeStartingPositionException
        | InvalidSnakeEndingPositionException
        | InvalidDiceTypeException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
