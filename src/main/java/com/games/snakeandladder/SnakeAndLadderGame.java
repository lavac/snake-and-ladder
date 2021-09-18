package com.games.snakeandladder;

public class SnakeAndLadderGame {

  static final int DEFAULT_SIZE = 100;
  static final int MAXIMUM_TURNS = 10;

  private SnakeAndLadderBoard board;
  private Player player;
  private Dice dice;

  public SnakeAndLadderGame(SnakeAndLadderBoard snakeAndLadderBoard, Dice dice, Player player) {
    this.board = snakeAndLadderBoard;
    this.dice = dice;
    this.player = player;
  }

  public void start() {
    while (!isGameCompleted()) {
      int diceRolledNumber = dice.roll();
      int positionToBeMoved = board.getNewPosition(diceRolledNumber, player.getCurrentPosition());
      player.incrementNumberOfTurns();
      player.setCurrentPosition(positionToBeMoved);
    }
  }

  public boolean isGameCompleted() {
    return  (player.getNumberOfTurns() == MAXIMUM_TURNS || player.getCurrentPosition() == DEFAULT_SIZE-1);
  }
}
