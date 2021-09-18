package com.games.snakeandladder.exception;

public class InvalidSnakeEndingPositionException extends RuntimeException {
  public InvalidSnakeEndingPositionException(int startingPosition, int endingPosition) {
    super(String.format("ending position %d should be less than the starting position %d", endingPosition, startingPosition));
  }
}
