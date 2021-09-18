package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndingPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;
import lombok.Data;

@Data
public class Snake {
  private int startingPosition;
  private int endingPosition;

  public void setStartingPosition(int startingPosition) {
    if (startingPosition > 0 ) {
      this.startingPosition = startingPosition;
    }
    else throw new InvalidSnakeStartingPositionException("Starting position should be greater than zero");
  }

  public void setEndingPosition(int endingPosition) {
    if (endingPosition < startingPosition && endingPosition >= 0 ) {
      this.endingPosition = endingPosition;
    }
    else throw new InvalidSnakeEndingPositionException(startingPosition, endingPosition);
  }
}
