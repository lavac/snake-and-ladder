package com.games.snakeandladder.exception;

import static com.games.snakeandladder.Constants.DEFAULT_SIZE;

public class InvalidLadderEndPositionException extends InvalidObstaclePositionException {
  public InvalidLadderEndPositionException(int startPosition, int endPosition) {
    super(String.format("Error :- Invalid ladder's end position:%d, it should be greater than the start position:%d " +
        "and should not be more than board size:%d", endPosition, startPosition, DEFAULT_SIZE));
  }
}
