package com.games.snakeandladder;

import com.games.snakeandladder.entity.Dice;
import com.games.snakeandladder.entity.Player;
import com.games.snakeandladder.entity.SnakeAndLadderBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class SnakeAndLadderGameTest {

  Player player = mock(Player.class);
  SnakeAndLadderBoard snakeAndLadderBoard = mock(SnakeAndLadderBoard.class);
  Dice dice = mock(Dice.class);

  SnakeAndLadderGame game = new SnakeAndLadderGame(snakeAndLadderBoard, dice, player);

  @Test
  void shouldTerminateTheGameWhenNumberOfTurnsReachesMaximumTurns() {
    when(player.getNumberOfTurns()).thenReturn(10);
    game.start();
    Assertions.assertTrue(game.isGameOver());
  }

  @Test
  void shouldTerminateTheGameWhenPlayerReachesTheLastPosition() {
    when(player.getNumberOfTurns()).thenReturn(5);
    when(player.getCurrentPosition()).thenReturn(99);
    game.start();
    Assertions.assertTrue(game.isGameOver());
  }

    @Test
  void shouldUpdatePlayersPositionAfterRollingTheDice() {
    when(player.getNumberOfTurns()).thenReturn(9).thenReturn(10);
    when(player.getCurrentPosition()).thenReturn(26);
    when(dice.roll()).thenReturn(4);
    when(player.getCurrentPosition()).thenReturn(20);
    when(snakeAndLadderBoard.getNewPosition(eq(4), eq(20))).thenReturn(24);

    game.start();

    verify(snakeAndLadderBoard).getNewPosition(4, 20);
    verify(player).setCurrentPosition(24);
    }
}