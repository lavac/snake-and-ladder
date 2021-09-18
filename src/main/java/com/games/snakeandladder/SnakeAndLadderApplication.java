package com.games.snakeandladder;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    final int DEFAULT_SIZE = 100;

    Player player = new Player("Player1");
    Dice dice = new Dice();
    SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(DEFAULT_SIZE);

    SnakeAndLadderGame game = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);
    game.start();
  }
}
