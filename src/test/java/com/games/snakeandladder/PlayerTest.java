package com.games.snakeandladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

  Player player = new Player("Player1");

  @Test
  void shouldIncrementTheTurns() {
    player.setNumberOfTurns(4);
    player.incrementNumberOfTurns();
    Assertions.assertEquals(5, player.getNumberOfTurns());
  }
}