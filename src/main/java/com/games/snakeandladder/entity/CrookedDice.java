package com.games.snakeandladder.entity;

import java.util.Random;

public class CrookedDice implements Dice{

  public int roll() {
    int random = new Random().nextInt(6) + 1;
    return  (random * 2) % 8;
  }
}
