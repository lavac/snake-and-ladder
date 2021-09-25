package com.games.snakeandladder.exception;

public class InvalidLadderStartPositionException extends Throwable {
  public InvalidLadderStartPositionException(int startPosition, int boardSize) {
    super(String.format("Error :- Invalid Ladder's Start position:%d, it should be greater than one and" +
        " less than the board boardSize:%d", startPosition, boardSize));
  }
}
