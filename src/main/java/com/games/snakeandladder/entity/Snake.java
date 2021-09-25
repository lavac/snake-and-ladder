package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.games.snakeandladder.Constants.DEFAULT_SIZE;

@Data
@EqualsAndHashCode(callSuper=false)
public class Snake extends Obstacle {
  private int startPosition;
  private int endPosition;

  public void setStartPosition(int startPosition) {
    if (startPosition > 1 && startPosition < DEFAULT_SIZE) {
      this.startPosition = startPosition;
    }
    else throw new InvalidSnakeStartPositionException(startPosition, DEFAULT_SIZE);
  }

  public void setEndPosition(int endPosition) {
    if (endPosition < startPosition && endPosition >= 1 ) {
      this.endPosition = endPosition;
    }
    else throw new InvalidSnakeEndPositionException(startPosition, endPosition);
  }
}
