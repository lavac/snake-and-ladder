package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeEndPositionException;
import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SnakeTest {

  Snake snake = new Snake();

  @Test
  void shouldSetStartingPositionIfItIsGreaterThanOne() {
    snake.setStartPosition(2);
    snake.setEndPosition(1);
    Assertions.assertEquals(2, snake.getStartPosition());
    Assertions.assertEquals(1, snake.getEndPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsLessThanStartingPositionAndGreaterThanOrEqualToOne() {
    snake.setStartPosition(99);
    snake.setEndPosition(20);
    Assertions.assertEquals(99, snake.getStartPosition());
    Assertions.assertEquals(20, snake.getEndPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsEqualToOne() {
    snake.setStartPosition(40);
    snake.setEndPosition(1);
    Assertions.assertEquals(40, snake.getStartPosition());
    Assertions.assertEquals(1, snake.getEndPosition());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIfItIsLessThanOne() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(0));
    Assertions.assertEquals("Error :- Invalid Snake's end position:0, it should be less than" +
        " the start position:40 and should not be less than one", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIfItIsGreaterThanStartingPosition() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(60));
    Assertions.assertEquals("Error :- Invalid Snake's end position:60, it should be less than" +
    " the start position:40 and should not be less than one", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsEqualToStartingPosition() {
    snake.setStartPosition(40);
    InvalidSnakeEndPositionException exception = Assertions.assertThrows(InvalidSnakeEndPositionException.class,
        () -> snake.setEndPosition(40));
    Assertions.assertEquals("Error :- Invalid Snake's end position:40, it should be less than" +
        " the start position:40 and should not be less than one", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsOne() {
    Snake snake = new Snake();
    InvalidSnakeStartPositionException exception = Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snake.setStartPosition(1));
    Assertions.assertEquals("Error :- Invalid Snake's Start position:1, it should be greater than one and" +
            " less than the board size:100",
        exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsEqualToBoardSize() {
    Snake snake = new Snake();
    InvalidSnakeStartPositionException exception = Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snake.setStartPosition(100));
    Assertions.assertEquals("Error :- Invalid Snake's Start position:100," +
            " it should be greater than one and less than the board size:100", exception.getMessage());
  }
}
