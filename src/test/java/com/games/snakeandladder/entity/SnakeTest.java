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
  void shouldSetEndingPositionIfItIsLessThanStartingPosition() {
    snake.setStartPosition(40);
    snake.setEndPosition(20);
    Assertions.assertEquals(20, snake.getEndPosition());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsLessThanZero() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(-6));
    Assertions.assertEquals("Error :- Invalid Snake's end position:-6, it should be less than" +
        " the start position:40 and should not be less than zero", exception.getMessage());
  }

  @Test
  void shouldNotSetEndingPositionIfItIsGreaterThanStartingPosition() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(60));
    Assertions.assertEquals("Error :- Invalid Snake's end position:60, it should be less than" +
    " the start position:40 and should not be less than zero", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsEqualToStartingPosition() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(40));
    Assertions.assertEquals("Error :- Invalid Snake's end position:40, it should be less than" +
        " the start position:40 and should not be less than zero", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsZero() {
    Snake snake = new Snake();
    InvalidSnakeStartPositionException exception = Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snake.setStartPosition(0));
    Assertions.assertEquals("Error :- Invalid Snake's Start position, it should be greater than zero",
        exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsLessThanZero() {
    Snake snake = new Snake();
    InvalidSnakeStartPositionException exception = Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snake.setStartPosition(-5));
    Assertions.assertEquals("Error :- Invalid Snake's Start position, it should be greater than zero",
        exception.getMessage());
  }
}
