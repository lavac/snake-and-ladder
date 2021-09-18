package com.games.snakeandladder;

public class SnakeAndLadderApplication {

  public static void main(String[] args) {
    Player player = new Player("Player1");

    SnakeAndLadderGame game = new SnakeAndLadderGame(player);
  }
}
