package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidDiceTypeException;

public enum DiceType {
  STRAIGHT, CROOKED;

  public static DiceType getDiceType(String diceType) {
    for(DiceType type : values()) {
      if(type.toString().equalsIgnoreCase(diceType)) {
        return type;
      }
    }
    throw new InvalidDiceTypeException("Entered invalid dice type, valid types are Straight and Crooked");
  }
}
