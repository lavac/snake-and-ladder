package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;
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
    snake.setStartPosition(56);
    snake.setEndPosition(20);
    snakeAndLadderBoard.addSnake(snake);
    Snake actualSnake = snakeAndLadderBoard.getCell(56).getSnake();
    Assertions.assertEquals(snake, actualSnake);
  }

  @Test
  void shouldThrowExceptionWhenStartingPositionIsOutOfTheBoard() {
    Snake snake = new Snake();
    snake.setStartPosition(100);
    snake.setEndPosition(49);
    Assertions.assertThrows(InvalidSnakeStartPositionException.class,
        () -> snakeAndLadderBoard.addSnake(snake));
  }

  @Test
  void shouldGetTheSnakeEndingPositionAsNewPositionAfterGoingThroughTheSnake() {
    Snake snake = new Snake();
    snake.setStartPosition(68);
    snake.setEndPosition(49);
    snakeAndLadderBoard.addSnake(snake);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64);
    Assertions.assertEquals(49, newPosition);
  }
}