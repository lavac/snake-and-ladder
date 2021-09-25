package com.games.snakeandladder.exception;

import static com.games.snakeandladder.Constants.DEFAULT_SIZE;

public class InvalidLadderEndPositionException extends Throwable {
  public InvalidLadderEndPositionException(int startPosition, int endPosition) {
    super(String.format("Error :- Invalid Snake's end position:%d, it should be greater than the start position:%d " +
        "and less than or equal to board size %d", endPosition, startPosition, DEFAULT_SIZE));
  }
}
