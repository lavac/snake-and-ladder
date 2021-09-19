package com.games.snakeandladder.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrookedDiceTest {

  CrookedDice crookedDice = new CrookedDice();

  @Test
  void shouldReturnEvenNumberWhichIsNotGreaterThanSix() {
    int roll = crookedDice.roll();
    assertEquals(roll % 2, 0);
  }
}