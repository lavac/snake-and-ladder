package com.games.snakeandladder.entity;

import lombok.Data;

@Data
public abstract class Obstacle {
  public int startPosition;
  public int endPosition;

  public abstract void setStartPosition(int startPosition);
  public abstract void setEndPosition(int endPosition);
}
