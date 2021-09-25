package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidLadderEndPositionException;
import com.games.snakeandladder.exception.InvalidLadderStartPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderTest {

  Ladder ladder = new Ladder();
  
  @Test
  void shouldSetStartingPositionIfItIsGreaterThanOne() {
    ladder.setStartPosition(2);
    ladder.setEndPosition(10);
    Assertions.assertEquals(2, ladder.getStartPosition());
    Assertions.assertEquals(10, ladder.getEndPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsGreaterThanStartingPositionAndLessThanOrEqualToSize() {
    ladder.setStartPosition(30);
    ladder.setEndPosition(99);
    Assertions.assertEquals(30, ladder.getStartPosition());
    Assertions.assertEquals(99, ladder.getEndPosition());
  }

  @Test
  void shouldSetEndingPositionIfItIsEqualToBoardSize() {
    ladder.setStartPosition(40);
    ladder.setEndPosition(100);
    Assertions.assertEquals(40, ladder.getStartPosition());
    Assertions.assertEquals(100, ladder.getEndPosition());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsGreaterThanSize() {
    ladder.setStartPosition(40);
    InvalidLadderEndPositionException exception = Assertions.assertThrows(InvalidLadderEndPositionException.class,
        () -> ladder.setEndPosition(101));
    Assertions.assertEquals("Error :- Invalid ladder's end position:101, it should be greater than" +
        " the start position:40 and should not be more than board size:100", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIfItIsLessThanStartingPosition() {
    ladder.setStartPosition(40);
    InvalidLadderEndPositionException exception = Assertions.assertThrows(InvalidLadderEndPositionException.class,
        () -> ladder.setEndPosition(20));
    Assertions.assertEquals("Error :- Invalid ladder's end position:20, it should be greater than" +
        " the start position:40 and should not be more than board size:100", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenEndingPositionIsEqualToStartingPosition() {
    ladder.setStartPosition(40);
    InvalidLadderEndPositionException exception = Assertions.assertThrows(InvalidLadderEndPositionException.class,
        () -> ladder.setEndPosition(40));
    Assertions.assertEquals("Error :- Invalid ladder's end position:40, it should be greater than" +
        " the start position:40 and should not be more than board size:100", exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsOne() {
    InvalidLadderStartPositionException exception = Assertions.assertThrows(InvalidLadderStartPositionException.class,
        () -> ladder.setStartPosition(1));
    Assertions.assertEquals("Error :- Invalid ladder's Start position:1, it should be greater than one and" +
            " less than the board size:100",
        exception.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsEqualToBoardSize() {
    InvalidLadderStartPositionException exception = Assertions.assertThrows(InvalidLadderStartPositionException.class,
        () -> ladder.setStartPosition(100));
    Assertions.assertEquals("Error :- Invalid ladder's Start position:100," +
        " it should be greater than one and less than the board size:100", exception.getMessage());
  }
}
