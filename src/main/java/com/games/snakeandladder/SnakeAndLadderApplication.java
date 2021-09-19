package com.games.snakeandladder;

import com.games.snakeandladder.entity.*;
import com.games.snakeandladder.exception.InvalidDiceTypeException;
import com.games.snakeandladder.exception.InvalidSnakeEndingPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;

import java.util.Scanner;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    final int DEFAULT_SIZE = 100;
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
    } catch (InvalidSnakeStartingPositionException ex) {
      System.out.println("Starting position of the snake should be greater than zero and less than the board size");
    } catch (InvalidSnakeEndingPositionException ex) {
      System.out.println("Ending position should be less than the starting position and greater than or equal to zero");
    } catch (InvalidDiceTypeException exception) {
      System.out.println(exception.getMessage());
    }
  }
}
