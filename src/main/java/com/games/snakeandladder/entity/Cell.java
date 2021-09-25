package com.games.snakeandladder.entity;

import lombok.Data;

@Data
public class Cell {
  private int id;
  private Obstacle obstacle;

  public Cell(int id) {
    this.id = id;
  }
}
