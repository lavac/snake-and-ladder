package com.games.snakeandladder.entity;

import java.util.Random;

public class CrookedDice implements Dice{

  public int roll() {
    int random = new Random().nextInt(6) + 1;
    int randomEven = (random * 2) % 6;
    return (randomEven != 0) ? randomEven : 6;
  }
}
