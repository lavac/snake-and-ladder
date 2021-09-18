package com.games.snakeandladder.entity;

import lombok.Data;

@Data
public class Cell {
  private int id;
  private Snake snake;

  public Cell(int id) {
    this.id = id;
  }
}
