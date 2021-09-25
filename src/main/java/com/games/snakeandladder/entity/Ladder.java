package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidLadderEndPositionException;
import com.games.snakeandladder.exception.InvalidLadderStartPositionException;
import lombok.Data;

import static com.games.snakeandladder.Constants.DEFAULT_SIZE;

@Data
public class Ladder {
  private int startPosition;
  private int endPosition;

  public void setStartPosition(int startPosition) {
    if (startPosition > 1 && startPosition < DEFAULT_SIZE) {
      this.startPosition = startPosition;
    }
    else throw new InvalidLadderStartPositionException(startPosition, DEFAULT_SIZE);
  }

  public void setEndPosition(int endPosition) {
    if (endPosition > startPosition && endPosition <= DEFAULT_SIZE ) {
      this.endPosition = endPosition;
    }
    else throw new InvalidLadderEndPositionException(startPosition, endPosition);
  }
}
