package com.games.snakeandladder;

public class SnakeAndLadderGame {

  static final int DEFAULT_SIZE = 100;
  static final int MAXIMUM_TURNS = 10;

  SnakeAndLadderBoard board;
  Player player;

  public SnakeAndLadderGame(Player player) {
    this.board = new SnakeAndLadderBoard(DEFAULT_SIZE);
    this.player = player;
  }

  public void start() {
    while (!isGameCompleted()) {

    }
  }

  public boolean isGameCompleted() {
    return  (player.getNumberOfTurns() == MAXIMUM_TURNS || player.getCurrentPosition() == DEFAULT_SIZE-1);
  }
}
