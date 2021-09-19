package com.games.snakeandladder.exception;

public class InvalidSnakeStartPositionException extends RuntimeException {
  private String message;

  public InvalidSnakeStartPositionException(int startingPosition, int size) {
    this.message = String.format("Starting position %d should be greater than zero and less than the board size %d",
        startingPosition, size);
  }

  public InvalidSnakeStartPositionException() {
    this.message = "Starting position should be greater than zero";
  }
}
