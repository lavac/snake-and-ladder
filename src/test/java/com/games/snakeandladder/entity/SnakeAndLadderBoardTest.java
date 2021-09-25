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
  void shouldAddLadderToTheParticularCell() {
    Ladder ladder = new Ladder();
    ladder.setStartPosition(56);
    ladder.setEndPosition(78);
    snakeAndLadderBoard.addLadder(ladder);
    Ladder actualLadder = snakeAndLadderBoard.getCell(56).getLadder();
    Assertions.assertEquals(ladder, actualLadder);
  }

  @Test
  void shouldBeAbleToAddMoreLaddersToTheBoard() {
    Ladder ladder1 = new Ladder();
    ladder1.setStartPosition(56);
    ladder1.setEndPosition(76);
    Ladder ladder2 = new Ladder();
    ladder2.setStartPosition(46);
    ladder2.setEndPosition(68);
    snakeAndLadderBoard.addLadder(ladder1);
    snakeAndLadderBoard.addLadder(ladder2);
    Ladder actualLadder1 = snakeAndLadderBoard.getCell(56).getLadder();
    Ladder actualLadder2 = snakeAndLadderBoard.getCell(46).getLadder();
    Assertions.assertEquals(ladder1, actualLadder1);
    Assertions.assertEquals(ladder2, actualLadder2);
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
  void shouldGetThLadderEndingPositionAsNewPositionAfterGoingThroughTheLadder() {
    Ladder ladder = new Ladder();
    ladder.setStartPosition(30);
    ladder.setEndPosition(60);
    snakeAndLadderBoard.addLadder(ladder);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 26, UUID.randomUUID());
    Assertions.assertEquals(60, newPosition);
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
  void shouldReplaceTheExistingLadderWhenNewLadderIsAddedToTheSameCell() {
    Ladder ladder1 = new Ladder();
    ladder1.setStartPosition(20);
    ladder1.setEndPosition(56);
    Ladder ladder2 = new Ladder();
    ladder2.setStartPosition(20);
    ladder2.setEndPosition(78);
    snakeAndLadderBoard.addLadder(ladder1);
    snakeAndLadderBoard.addLadder(ladder2);
    Ladder actualLadder2 = snakeAndLadderBoard.getCell(20).getLadder();
    Assertions.assertEquals(ladder2, actualLadder2);
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

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughMultipleLaddersBackToBack() {
    Ladder ladder1 = new Ladder();
    ladder1.setStartPosition(49);
    ladder1.setEndPosition(68);
    Ladder ladder2 = new Ladder();
    ladder2.setStartPosition(68);
    ladder2.setEndPosition(74);
    Ladder ladder3 = new Ladder();
    ladder3.setStartPosition(74);
    ladder3.setEndPosition(100);
    snakeAndLadderBoard.addLadder(ladder1);
    snakeAndLadderBoard.addLadder(ladder2);
    snakeAndLadderBoard.addLadder(ladder3);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 45, UUID.randomUUID());
    Assertions.assertEquals(100, newPosition);
  }

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughBothLaddersAndSnakesBackToBack() {
    Ladder ladder1 = new Ladder();
    ladder1.setStartPosition(49);
    ladder1.setEndPosition(68);
    Ladder ladder2 = new Ladder();
    ladder2.setStartPosition(68);
    ladder2.setEndPosition(74);
    Snake snake1 = new Snake();
    snake1.setStartPosition(74);
    snake1.setEndPosition(34);
    snakeAndLadderBoard.addLadder(ladder1);
    snakeAndLadderBoard.addLadder(ladder2);
    snakeAndLadderBoard.addSnake(snake1);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 45, UUID.randomUUID());
    Assertions.assertEquals(34, newPosition);
  }
}