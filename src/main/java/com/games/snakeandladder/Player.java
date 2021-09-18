package com.games.snakeandladder;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {
  private UUID id;
  private int numberOfTurns;
  private int currentPosition;
  private String name;

  public Player(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.currentPosition = 0;
    this.numberOfTurns = 0;
  }

  public void incrementNumberOfTurns() {
    
  }
}
