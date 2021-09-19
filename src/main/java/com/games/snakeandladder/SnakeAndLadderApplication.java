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
      int startPosition = scanner.nextInt();
      int endPosition = scanner.nextInt();
      Snake snake = new Snake();
      snake.setStartPosition(startPosition);
      snake.setEndPosition(endPosition);
      SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);
      snakeAndLadderBoard.addSnake(snake);
      Player player = new Player(PLAYER_NAME);
      String diceTypeInString = scanner.next();
      DiceType diceType = DiceType.getDiceType(diceTypeInString);
      Dice dice = DiceFactory.get(diceType);
      SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);
      snakeAndLadderGame.start();
    } catch (InvalidSnakeStartPositionException
        | InvalidSnakeEndPositionException
        | InvalidDiceTypeException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
