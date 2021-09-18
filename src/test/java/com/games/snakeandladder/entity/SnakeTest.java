package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndingPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnakeTest {

  Snake snake = new Snake();

  @Test
  void shouldSetStartingPositionIfItIsGreaterThanZero() {
    snake.setStartingPosition(2);
    Assertions.assertEquals(2, snake.getStartingPosition());
  }

  @Test
  void shouldNotSetStartingPositionIfItIsEqualToZero() {
    snake.setStartingPosition(0);
    Assertions.assertEquals(0, snake.getStartingPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsLessThanStartingPosition() {
    snake.setStartingPosition(40);
    snake.setEndingPosition(20);
    Assertions.assertEquals(20, snake.getEndingPosition());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsGreaterThanStartingPosition() {
    snake.setStartingPosition(40);
    snake.setEndingPosition(60);
    Assertions.assertEquals(0, snake.getEndingPosition());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsEqualToStartingPosition() {
    snake.setStartingPosition(40);
    snake.setEndingPosition(40);
    Assertions.assertEquals(0, snake.getEndingPosition());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsNotGreaterThanZero() {
    Snake snake = new Snake();
    Assertions.assertThrows(InvalidSnakeStartingPositionException.class,
        () -> snake.setStartingPosition(0));
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsNotLessThanTheStartingPosition() {
    Snake snake = new Snake();
    snake.setStartingPosition(50);
    Assertions.assertThrows(InvalidSnakeEndingPositionException.class,
        () -> snake.setEndingPosition(50));
  }
}
