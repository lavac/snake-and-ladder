package com.games.snakeandladder;

import com.games.snakeandladder.entity.Dice;
import com.games.snakeandladder.entity.Player;
import com.games.snakeandladder.entity.Snake;
import com.games.snakeandladder.entity.SnakeAndLadderBoard;

import java.util.Scanner;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    final int DEFAULT_SIZE = 100;

    Scanner scanner = new Scanner(System.in);
    int startingIndex = scanner.nextInt();
    int endingIndex = scanner.nextInt();
    Snake snake = new Snake();
    snake.setStartingPosition(startingIndex);
    snake.setEndingPosition(endingIndex);
    SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);
    snakeAndLadderBoard.addSnake(snake);
    Player player = new Player("Player1");
    Dice dice = new Dice();
    SnakeAndLadderGame game = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);
    game.start();
  }
}
