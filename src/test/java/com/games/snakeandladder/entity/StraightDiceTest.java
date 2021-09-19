package com.games.snakeandladder.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StraightDiceTest {

  StraightDice straightDice = new StraightDice();

  @Test
  void shouldGetTheRolledNumberBelowOrEqualToSix() {
    int rolledNumber = straightDice.roll();
    Assertions.assertTrue(rolledNumber <= 6);
  }

  @Test
  void shouldGetTheRolledNumberGreaterThanZero() {
    int rolledNumber = straightDice.roll();
    Assertions.assertTrue(rolledNumber > 0);
  }
}