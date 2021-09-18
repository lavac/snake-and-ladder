package com.games.snakeandladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnakeAndLadderBoardTest {

  SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(10);

  @Test
  void shouldGetTheUpdatedPosition() {
    int newPosition = snakeAndLadderBoard.getNewPosition(14, 4);
    Assertions.assertEquals(18, newPosition);
  }
}