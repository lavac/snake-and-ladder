package com.games.snakeandladder.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class SnakeAndLadderBoardTest {

  SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard(100);

  @Test
  void shouldGetTheUpdatedPosition() {
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 14, UUID.randomUUID());
    Assertions.assertEquals(18, newPosition);
  }

  @Test
  void shouldGiveTheCurrentPositionIfNewPositionIsGreaterThanTheBoardSize() {
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(5, 97, UUID.randomUUID());
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
  void shouldGetTheSnakeEndingPositionAsNewPositionAfterGoingThroughTheSnake() {
    Snake snake = new Snake();
    snake.setStartPosition(68);
    snake.setEndPosition(49);
    snakeAndLadderBoard.addSnake(snake);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64, UUID.randomUUID());
    Assertions.assertEquals(49, newPosition);
  }

  @Test
  void shouldBeAbleToAddMoreSnakesToTheBoard() {
    Snake snake1 = new Snake();
    snake1.setStartPosition(56);
    snake1.setEndPosition(20);
    Snake snake2 = new Snake();
    snake2.setStartPosition(46);
    snake2.setEndPosition(23);
    snakeAndLadderBoard.addSnake(snake1);
    snakeAndLadderBoard.addSnake(snake2);
    Snake actualSnake1 = snakeAndLadderBoard.getCell(56).getSnake();
    Snake actualSnake2 = snakeAndLadderBoard.getCell(46).getSnake();
    Assertions.assertEquals(snake1, actualSnake1);
    Assertions.assertEquals(snake2, actualSnake2);
  }

  @Test
  void shouldReplaceTheExistingSnakeWhenNewSnakeIsAddedToTheSameCell() {
    Snake snake1 = new Snake();
    snake1.setStartPosition(56);
    snake1.setEndPosition(20);
    Snake snake2 = new Snake();
    snake2.setStartPosition(56);
    snake2.setEndPosition(23);
    snakeAndLadderBoard.addSnake(snake1);
    snakeAndLadderBoard.addSnake(snake2);
    Snake actualSnake2 = snakeAndLadderBoard.getCell(56).getSnake();
    Assertions.assertEquals(snake2, actualSnake2);
  }

  @Test
  void shouldGetTheCorrectUpdatedPositionAfterGoingThroughASnakeAndWhenBoardHasMultipleSnakes() {
    Snake snake1 = new Snake();
    snake1.setStartPosition(68);
    snake1.setEndPosition(49);
    Snake snake2 = new Snake();
    snake2.setStartPosition(54);
    snake2.setEndPosition(34);
    Snake snake3 = new Snake();
    snake3.setStartPosition(34);
    snake3.setEndPosition(23);
    snakeAndLadderBoard.addSnake(snake1);
    snakeAndLadderBoard.addSnake(snake2);
    snakeAndLadderBoard.addSnake(snake3);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64, UUID.randomUUID());
    Assertions.assertEquals(49, newPosition);
  }

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughMultipleSnakesBackToBack() {
    Snake snake1 = new Snake();
    snake1.setStartPosition(68);
    snake1.setEndPosition(49);
    Snake snake2 = new Snake();
    snake2.setStartPosition(49);
    snake2.setEndPosition(34);
    Snake snake3 = new Snake();
    snake3.setStartPosition(34);
    snake3.setEndPosition(23);
    snakeAndLadderBoard.addSnake(snake1);
    snakeAndLadderBoard.addSnake(snake2);
    snakeAndLadderBoard.addSnake(snake3);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64, UUID.randomUUID());
    Assertions.assertEquals(23, newPosition);
  }
}