package com.games.snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderBoard {
  List<Cell> cells = new ArrayList();

  public SnakeAndLadderBoard(int size) {
    for (int id =0; id < size; id++) {
      cells.add(new Cell(id));
    }
  }
}
