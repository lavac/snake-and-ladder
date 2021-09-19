package com.games.snakeandladder.exception;

public class InvalidSnakeEndPositionException extends RuntimeException {
  public InvalidSnakeEndPositionException(int startingPosition, int endingPosition) {
    super(String.format("ending position %d should be less than the starting position %d", endingPosition, startingPosition));
  }
}
