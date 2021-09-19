package com.games.snakeandladder.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {
  private UUID id;
  private String name;
  private int numberOfTurns;
  private int currentPosition;

  public Player(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.currentPosition = 0;
    this.numberOfTurns = 0;
  }

  public void incrementNumberOfTurns() {
    numberOfTurns = numberOfTurns + 1;
  }

  public void move(int positionToBeMoved) {
    this.currentPosition = positionToBeMoved;
  }
}
