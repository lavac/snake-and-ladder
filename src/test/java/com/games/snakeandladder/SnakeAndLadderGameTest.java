package com.games.snakeandladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SnakeAndLadderGameTest {

  Player player = mock(Player.class);

  SnakeAndLadderGame game = new SnakeAndLadderGame(player);

  @Test
  void shouldTerminateTheGameWhenNumberOfTurnsReachesMaximumTurns() {
    when(player.getNumberOfTurns()).thenReturn(10);
    game.start();
    Assertions.assertTrue(game.isGameCompleted());
  }

  @Test
  void shouldTerminateTheGameWhenPlayerReachesTheLastPosition() {
    when(player.getNumberOfTurns()).thenReturn(5);
    when(player.getCurrentPosition()).thenReturn(99);
    game.start();
    Assertions.assertTrue(game.isGameCompleted());
  }
}