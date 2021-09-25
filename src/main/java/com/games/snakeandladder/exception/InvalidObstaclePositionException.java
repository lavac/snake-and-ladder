package com.games.snakeandladder.exception;

public class InvalidObstaclePositionException extends RuntimeException{
    public InvalidObstaclePositionException(String message) {
      super(message);
    }
}
