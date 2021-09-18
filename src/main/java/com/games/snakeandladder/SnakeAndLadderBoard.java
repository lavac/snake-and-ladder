package com.games.snakeandladder;

public class SnakeAndLadderBoard {
  private int size;
  private Cell[] cells;

  public SnakeAndLadderBoard(int size) {
    this.size = size;
    cells = new Cell[size];

    for (int id =0; id < size; id++) {
      cells[0] = new Cell(id);
    }
  }

  public int getNewPosition(int rolledNumber, int currentPosition) {
    int newPosition = rolledNumber + currentPosition;
    return (newPosition < size)? newPosition: currentPosition;
  }
}
