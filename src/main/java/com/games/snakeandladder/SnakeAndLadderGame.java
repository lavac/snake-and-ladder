package com.games.snakeandladder;

public class SnakeAndLadderGame {

  static final int DEFAULT_SIZE = 100;

  SnakeAndLadderBoard board;
  Player player;

  public SnakeAndLadderGame(Player player) {
    this.board = new SnakeAndLadderBoard(DEFAULT_SIZE);
    this.player = player;
  }
}
