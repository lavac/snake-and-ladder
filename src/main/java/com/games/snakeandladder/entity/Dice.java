package com.games.snakeandladder.entity;

import java.util.Random;

public class Dice {
  public int roll() {
    return new Random().nextInt(6) + 1;
  }
}
