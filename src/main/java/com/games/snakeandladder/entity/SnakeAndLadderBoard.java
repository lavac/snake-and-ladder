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
    int newPosition = rolledNumber + currentPosition;
    return (newPosition < size)? newPosition: currentPosition;
  }

  public void addSnake(Snake snake) {
    int startingPosition = snake.getStartingPosition();
    if (startingPosition < size-1) {
      Cell cell = getCell(startingPosition);
      cell.setSnake(snake);
    } else throw new InvalidSnakeStartingPositionException(startingPosition, size);
  }

  public Cell getCell(int id) {
    return cells[id];
  }
}
