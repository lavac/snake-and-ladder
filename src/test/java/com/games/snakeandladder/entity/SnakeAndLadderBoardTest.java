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
  void shouldAddObstacleToTheParticularCell() {
    Obstacle snake = new Snake();
    snake.setStartPosition(56);
    snake.setEndPosition(20);
    snakeAndLadderBoard.addObstacle(snake);
    Obstacle actualSnake = snakeAndLadderBoard.getCell(56).getObstacle();
    Assertions.assertEquals(snake, actualSnake);
  }

  @Test
  void shouldBeAbleToAddMoreObstaclesToTheBoard() {
    Obstacle ladder1 = new Ladder();
    ladder1.setStartPosition(56);
    ladder1.setEndPosition(76);
    Obstacle ladder2 = new Ladder();
    ladder2.setStartPosition(46);
    ladder2.setEndPosition(68);
    Obstacle snake = new Snake();
    snake.setStartPosition(68);
    snake.setEndPosition(49);
    snakeAndLadderBoard.addObstacle(ladder1);
    snakeAndLadderBoard.addObstacle(ladder2);
    snakeAndLadderBoard.addObstacle(snake);
    Obstacle actualLadder1 = snakeAndLadderBoard.getCell(56).getObstacle();
    Obstacle actualLadder2 = snakeAndLadderBoard.getCell(46).getObstacle();
    Obstacle actualSnake = snakeAndLadderBoard.getCell(68).getObstacle();
    Assertions.assertEquals(ladder1, actualLadder1);
    Assertions.assertEquals(ladder2, actualLadder2);
    Assertions.assertEquals(snake, actualSnake);
  }

  @Test
  void shouldGetTheSnakeEndingPositionAsNewPositionAfterGoingThroughTheSnake() {
    Obstacle snake = new Snake();
    snake.setStartPosition(68);
    snake.setEndPosition(49);
    snakeAndLadderBoard.addObstacle(snake);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64, UUID.randomUUID());
    Assertions.assertEquals(49, newPosition);
  }

  @Test
  void shouldGetThLadderEndingPositionAsNewPositionAfterGoingThroughTheLadder() {
    Obstacle ladder = new Ladder();
    ladder.setStartPosition(30);
    ladder.setEndPosition(60);
    snakeAndLadderBoard.addObstacle(ladder);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 26, UUID.randomUUID());
    Assertions.assertEquals(60, newPosition);
  }

  @Test
  void shouldReplaceTheExistingObstacleWhenNewObstacleIsAddedToTheSameCell() {
    Obstacle snake = new Snake();
    snake.setStartPosition(56);
    snake.setEndPosition(20);
    Obstacle ladder = new Ladder();
    ladder.setStartPosition(56);
    ladder.setEndPosition(96);
    snakeAndLadderBoard.addObstacle(snake);
    snakeAndLadderBoard.addObstacle(ladder);
    Obstacle obstacle = snakeAndLadderBoard.getCell(56).getObstacle();
    Assertions.assertEquals(ladder, obstacle);
  }

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughMultipleSnakesBackToBack() {
    Obstacle snake1 = new Snake();
    snake1.setStartPosition(68);
    snake1.setEndPosition(49);
    Obstacle snake2 = new Snake();
    snake2.setStartPosition(49);
    snake2.setEndPosition(34);
    Obstacle snake3 = new Snake();
    snake3.setStartPosition(34);
    snake3.setEndPosition(23);
    snakeAndLadderBoard.addObstacle(snake1);
    snakeAndLadderBoard.addObstacle(snake2);
    snakeAndLadderBoard.addObstacle(snake3);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 64, UUID.randomUUID());
    Assertions.assertEquals(23, newPosition);
  }

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughMultipleLaddersBackToBack() {
    Obstacle ladder1 = new Ladder();
    ladder1.setStartPosition(49);
    ladder1.setEndPosition(68);
    Obstacle ladder2 = new Ladder();
    ladder2.setStartPosition(68);
    ladder2.setEndPosition(74);
    Obstacle ladder3 = new Ladder();
    ladder3.setStartPosition(74);
    ladder3.setEndPosition(100);
    snakeAndLadderBoard.addObstacle(ladder1);
    snakeAndLadderBoard.addObstacle(ladder2);
    snakeAndLadderBoard.addObstacle(ladder3);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 45, UUID.randomUUID());
    Assertions.assertEquals(100, newPosition);
  }

  @Test
  void shouldGetTheUpdatedPositionAfterGoingThroughBothLaddersAndSnakesBackToBack() {
    Obstacle ladder1 = new Ladder();
    ladder1.setStartPosition(49);
    ladder1.setEndPosition(68);
    Obstacle ladder2 = new Ladder();
    ladder2.setStartPosition(68);
    ladder2.setEndPosition(74);
    Obstacle snake1 = new Snake();
    snake1.setStartPosition(74);
    snake1.setEndPosition(34);
    snakeAndLadderBoard.addObstacle(ladder1);
    snakeAndLadderBoard.addObstacle(ladder2);
    snakeAndLadderBoard.addObstacle(snake1);
    int newPosition = snakeAndLadderBoard.getThePositionToBeMoved(4, 45, UUID.randomUUID());
    Assertions.assertEquals(34, newPosition);
  }
}