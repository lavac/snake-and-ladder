package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidSnakeStartingPositionException;

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

  public int getNewPosition(int rolledNumber, int currentPosition) {
    Snake snake;
    int newPosition = rolledNumber + currentPosition;
    Cell cell = getCell(newPosition);
    if (cell == null) {
      return currentPosition;
    }
    else {
      snake = cell.getSnake();
      if (snake != null) {
        return snake.getEndingPosition();
      }
      return newPosition;
    }
  }

  public void addSnake(Snake snake) {
    int startingPosition = snake.getStartingPosition();
      Cell cell = getCell(startingPosition);
    if (cell != null) {
      cell.setSnake(snake);
    } else {
      throw new InvalidSnakeStartingPositionException(startingPosition, size);
    }
  }

  public Cell getCell(int id) {
    return  (id < size) ? cells[id]: null;
  }
}
