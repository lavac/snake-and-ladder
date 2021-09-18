package com.games.snakeandladder.exception;

public class InvalidSnakeStartingPositionException extends RuntimeException {

  public InvalidSnakeStartingPositionException(int startingPosition, int size) {
    super(String.format("starting position %d should be less than the board size %d", startingPosition, size));
  }

  public InvalidSnakeStartingPositionException(String message) {
    super(message);
  }
}
