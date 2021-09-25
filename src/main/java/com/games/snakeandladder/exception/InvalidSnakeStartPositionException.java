package com.games.snakeandladder.exception;

public class InvalidSnakeStartPositionException extends InvalidObstaclePositionException {

  public InvalidSnakeStartPositionException(int startPosition, int size) {
    super(String.format("Error :- Invalid Snake's Start position:%d, it should be greater than one and" +
            " less than the board size:%d", startPosition, size));
  }
}
