package com.games.snakeandladder;

import com.games.snakeandladder.exception.InvalidDiceTypeException;

public enum DiceType {
  STRAIGHT, CROOKED;

  static DiceType getDiceType(String diceType) {
    for(DiceType type : values()) {
      if(type.toString().equalsIgnoreCase(diceType)) {
        return type;
      }
    }
    throw new InvalidDiceTypeException("Entered invalid dice type,Valid types are Straight and Crooked");
  }
}
