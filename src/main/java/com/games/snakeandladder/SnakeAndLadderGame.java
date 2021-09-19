package com.games.snakeandladder;

import com.games.snakeandladder.entity.StraightDice;
import com.games.snakeandladder.entity.Player;
import com.games.snakeandladder.entity.SnakeAndLadderBoard;

public class SnakeAndLadderGame {

  static final int DEFAULT_SIZE = 100;
  static final int MAXIMUM_TURNS = 10;

  private SnakeAndLadderBoard board;
  private Player player;
  private StraightDice straightDice;

  public SnakeAndLadderGame(SnakeAndLadderBoard snakeAndLadderBoard, StraightDice straightDice, Player player) {
    this.board = snakeAndLadderBoard;
    this.straightDice = straightDice;
    this.player = player;
  }

  public void start() {
    while (!isGameOver()) {
      int diceRolledNumber = straightDice.roll();
      int positionToBeMoved = board.getNewPosition(diceRolledNumber, player.getCurrentPosition());
      player.incrementNumberOfTurns();
      player.setCurrentPosition(positionToBeMoved);
    }
  }

  public boolean isGameOver() {
    if (player.getCurrentPosition() == DEFAULT_SIZE - 1) {
      System.out.printf("Player name:%s playerId:%s Won the game%n", player.getName(), player.getId());
      return true;
    }
    else if (player.getNumberOfTurns() == MAXIMUM_TURNS) {
      System.out.printf("Game is over, reached maximum turns %s", MAXIMUM_TURNS);
      return true;
    }
    return false;
  }
}
