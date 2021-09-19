package com.games.snakeandladder.exception;

public class InvalidSnakeStartingPositionException extends RuntimeException {
  private String message;

  public InvalidSnakeStartingPositionException(int startingPosition, int size) {
    this.message = String.format("Starting position %d should be greater than zero and less than the board size %d",
        startingPosition, size);
  }

  public InvalidSnakeStartingPositionException() {
    this.message = "Starting position should be greater than zero";
  }
}
