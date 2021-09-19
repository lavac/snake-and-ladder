package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeStartPositionException;

public class SnakeAndLadderBoard {
  private int size;
  private Cell[] cells;

  public SnakeAndLadderBoard(int size) {
    this.size = size;
    cells = new Cell[size];

    for (int id =0; id < size; id++) {
      cells[id] = new Cell(id);
    }
  }

  public int getThePositionToBeMoved(int rolledNumber, int currentPosition) {
    int positionToBeMoved = rolledNumber + currentPosition;
    Cell cellToBeMoved = getCell(positionToBeMoved);
    return  (cellToBeMoved == null)
        ? currentPosition
        : getTheUpdatedPositionAfterGoingThroughTheSnake(positionToBeMoved, cellToBeMoved);
  }

  private int getTheUpdatedPositionAfterGoingThroughTheSnake(int positionToBeMoved, Cell cellToBeMoved) {
    Snake snake = cellToBeMoved.getSnake();
    return  (snake != null) ? snake.getEndPosition() : positionToBeMoved;
  }

  public void addSnake(Snake snake) {
    int startingPosition = snake.getStartPosition();
      Cell cell = getCell(startingPosition);
    if (cell != null) {
      cell.setSnake(snake);
    } else {
      throw new InvalidSnakeStartPositionException(startingPosition, size);
    }
  }

  public Cell getCell(int id) {
    return  (id < size) ? cells[id]: null;
  }
}
