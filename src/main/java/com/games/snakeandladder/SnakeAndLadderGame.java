package com.games.snakeandladder;

import com.games.snakeandladder.entity.Dice;
import com.games.snakeandladder.entity.Player;
import com.games.snakeandladder.entity.SnakeAndLadderBoard;
import static com.games.snakeandladder.Constants.DEFAULT_SIZE;
import static com.games.snakeandladder.Constants.MAXIMUM_TURNS;

public class SnakeAndLadderGame {
  private SnakeAndLadderBoard board;
  private Player player;
  private Dice dice;

  public SnakeAndLadderGame(SnakeAndLadderBoard snakeAndLadderBoard, Dice dice, Player player) {
    this.board = snakeAndLadderBoard;
    this.dice = dice;
    this.player = player;
  }

  public void start() {
    while (!isGameOver()) {
      int diceRolledNumber = dice.roll();
      int positionToBeMoved = board.getThePositionToBeMoved(diceRolledNumber,
          player.getCurrentPosition(),
          player.getId());
      player.incrementNumberOfTurns();
      player.move(positionToBeMoved);
    }
  }

  public boolean isGameOver() {
    if (player.getCurrentPosition() == DEFAULT_SIZE) {
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
