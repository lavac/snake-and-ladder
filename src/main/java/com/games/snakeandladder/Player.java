package com.games.snakeandladder;

import java.util.UUID;

public class Player {
  private UUID id;
  private int currentPosition;
  private String name;

  public Player(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.currentPosition = 0;
  }
}
