package com.games.snakeandladder.entity;

import com.games.snakeandladder.entity.SnakeAndLadderBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnakeAndLadderBoardTest {

  SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(100);

  @Test
  void shouldGetTheUpdatedPosition() {
    int newPosition = snakeAndLadderBoard.getNewPosition(4, 14);
    Assertions.assertEquals(18, newPosition);
  }

  @Test
  void shouldGiveTheCurrentPositionIfNewPositionIsGreaterThanTheBoardSize() {
    int newPosition = snakeAndLadderBoard.getNewPosition(5, 97);
    Assertions.assertEquals(97, newPosition);
  }
}