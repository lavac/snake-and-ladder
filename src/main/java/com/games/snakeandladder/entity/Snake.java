package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
import lombok.Data;

@Data
public class Snake {
  private int startPosition;
  private int endPosition;

  public void setStartPosition(int startPosition) {
    if (startPosition > 0 ) {
      this.startPosition = startPosition;
    }
    else throw new InvalidSnakeStartPositionException();
  }

  public void setEndPosition(int endPosition) {
    if (endPosition < startPosition && endPosition >= 0 ) {
      this.endPosition = endPosition;
    }
    else throw new InvalidSnakeEndPositionException(startPosition, endPosition);
  }
}
