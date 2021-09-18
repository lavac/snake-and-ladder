package com.games.snakeandladder;

import lombok.Getter;

import java.util.UUID;

@Getter
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
