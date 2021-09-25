package com.games.snakeandladder.exception;

public class InvalidLadderStartPositionException extends InvalidObstaclePositionException {
  public InvalidLadderStartPositionException(int startPosition, int boardSize) {
    super(String.format("Error :- Invalid ladder's Start position:%d, it should be greater than one and" +
        " less than the board size:%d", startPosition, boardSize));
  }
}
