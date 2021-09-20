package com.games.snakeandladder.entity;

import java.util.UUID;

public class SnakeAndLadderBoard {
  private int size;
  private Cell[] cells;

  public SnakeAndLadderBoard(int size) {
    this.size = size;
    cells = new Cell[size];

    for (int id =0; id < size; id++) {
      cells[id] = new Cell(id+1);
    }
  }

  public int getThePositionToBeMoved(int rolledNumber, int currentPosition, UUID id) {
    int positionToBeMoved = rolledNumber + currentPosition;
    Cell cellToBeMoved = getCell(positionToBeMoved);
    return (cellToBeMoved == null)
        ? currentPosition
        : getTheUpdatedPositionAfterGoingThroughTheSnake(positionToBeMoved, cellToBeMoved, id);
  }

  private int getTheUpdatedPositionAfterGoingThroughTheSnake(int positionToBeMoved, Cell cellToBeMoved, UUID playerId) {
    Snake snake = cellToBeMoved.getSnake();
    if (snake != null) {
      System.out.printf("Player with Id:%s got bitten by snake at position %d%n",
          playerId, snake.getStartPosition());
      return snake.getEndPosition();
    } else return positionToBeMoved;
  }

  public void addSnake(Snake snake) {
    int startingPosition = snake.getStartPosition();
    Cell cell = getCell(startingPosition);
    if (cell != null) {
      cell.setSnake(snake);
    }
  }

  public Cell getCell(int id) {
    return  (id <= size) ? cells[id-1]: null;
  }
}
