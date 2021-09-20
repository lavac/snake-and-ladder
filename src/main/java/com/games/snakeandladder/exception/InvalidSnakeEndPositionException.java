package com.games.snakeandladder.exception;

public class InvalidSnakeEndPositionException extends RuntimeException {
  public InvalidSnakeEndPositionException(int startPosition, int endPosition) {
    super(String.format("Error :- Invalid Snake's end position:%d, it should be less than the start position:%d " +
            "and should not be less than one", endPosition, startPosition));
  }
}
