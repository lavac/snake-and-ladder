package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnakeTest {

  Snake snake = new Snake();

  @Test
  void shouldSetStartingPositionIfItIsGreaterThanZero() {
    snake.setStartPosition(2);
    Assertions.assertEquals(2, snake.getStartPosition());
  }

  @Test
  void shouldNotSetStartingPositionIfItIsEqualToZero() {
    snake.setStartPosition(0);
    Assertions.assertEquals(0, snake.getStartPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsLessThanStartingPosition() {
    snake.setStartPosition(40);
    snake.setEndPosition(20);
    Assertions.assertEquals(20, snake.getEndPosition());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsGreaterThanStartingPosition() {
    snake.setStartPosition(40);
    snake.setEndPosition(60);
    Assertions.assertEquals(0, snake.getEndPosition());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsEqualToStartingPosition() {
    snake.setStartPosition(40);
    snake.setEndPosition(40);
    Assertions.assertEquals(0, snake.getEndPosition());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsNotGreaterThanZero() {
    Snake snake = new Snake();
    Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snake.setStartPosition(0));
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsNotLessThanTheStartingPosition() {
    Snake snake = new Snake();
    snake.setStartPosition(50);
    Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(50));
  }
}
