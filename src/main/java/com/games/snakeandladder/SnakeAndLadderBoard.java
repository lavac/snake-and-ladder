package com.games.snakeandladder;

public class SnakeAndLadderBoard {
  Cell[] cells;

  public SnakeAndLadderBoard(int size) {
    cells = new Cell[size];

    for (int id =0; id < size; id++) {
      cells[0] = new Cell(id);
    }
  }

  public int getNewPosition(int rolledNumber, int currentPosition) {
    return rolledNumber + currentPosition;
  }
}
