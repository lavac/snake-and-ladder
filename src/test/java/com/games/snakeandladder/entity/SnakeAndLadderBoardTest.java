package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnakeAndLadderBoardTest {

  SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(100);

  @Test
  void shouldGetTheUpdatedPosition() {
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 14);
    Assertions.assertEquals(18, newPosition);
  }

  @Test
  void shouldGiveTheCurrentPositionIfNewPositionIsGreaterThanTheBoardSize() {
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(5, 97);
    Assertions.assertEquals(97, newPosition);
  }

  @Test
  void shouldAddSnakeToTheParticularCell() {
    Snake snake = new Snake();
    snake.setStartingPosition(56);
    snake.setEndingPosition(20);
    snakeAndLadderBoard.addSnake(snake);
    Snake actualSnake = snakeAndLadderBoard.getCell(56).getSnake();
    Assertions.assertEquals(snake, actualSnake);
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsOutOfTheBoard() {
    Snake snake = new Snake();
    snake.setStartingPosition(100);
    snake.setEndingPosition(49);
    Assertions.assertThrows(InvalidSnakeStartingPositionException.class,
        () -> snakeAndLadderBoard.addSnake(snake));
  }

  @Test
  void shouldGetTheSnakeEndingPositionAsNewPositionAfterGoingThroughTheSnake() {
    Snake snake = new Snake();
    snake.setStartingPosition(68);
    snake.setEndingPosition(49);
    snakeAndLadderBoard.addSnake(snake);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64);
    Assertions.assertEquals(49, newPosition);
  }
}