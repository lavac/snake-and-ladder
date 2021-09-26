package com.games.snakeandladder.exception;

public class InvalidLadderEndPositionException extends InvalidObstaclePositionException {
  public InvalidLadderEndPositionException(int startPosition, int endPosition, int size) {
    super(String.format("Error :- Invalid ladder's end position:%d, it should be greater than the start position:%d " +
        "and should not be more than board size:%d", endPosition, startPosition, size));
  }
}
