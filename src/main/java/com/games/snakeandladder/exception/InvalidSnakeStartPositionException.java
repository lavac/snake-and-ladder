package com.games.snakeandladder.exception;

public class InvalidSnakeStartPositionException extends RuntimeException {

  public InvalidSnakeStartPositionException(int startPosition, int size) {
    super(String.format("Error :- Invalid Snake's Start position:%d, it should be greater than zero and" +
            " less than the board size:%d", startPosition, size));
  }

  public InvalidSnakeStartPositionException() {
    super("Error :- Invalid Snake's Start position, it should be greater than zero");
  }
}