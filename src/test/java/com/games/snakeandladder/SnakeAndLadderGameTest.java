package com.games.snakeandladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class SnakeAndLadderGameTest {

  Player player = mock(Player.class);

  SnakeAndLadderGame game = new SnakeAndLadderGame(player);

  @Test
  void shouldTerminateTheGameWhenNumberOfTurnsReachesMaximumTurns() {
    game.start();
    Assertions.assertTrue(game.isGameCompleted());
  }

}