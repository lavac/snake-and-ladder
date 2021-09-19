package com.games.snakeandladder;

import com.games.snakeandladder.entity.CrookedDice;
import com.games.snakeandladder.entity.Dice;
import com.games.snakeandladder.entity.DiceType;
import com.games.snakeandladder.entity.StraightDice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiceFactoryTest {

  @Test
  void shouldReturnStraightDiceIfRequestedDiceTypeIsStraightDice() {
    Dice dice = DiceFactory.get(DiceType.STRAIGHT);
    Assertions.assertTrue(dice instanceof StraightDice);
  }

  @Test
  void shouldReturnCrookedDiceIfRequestedDiceTypeIsCrookedDice() {
    Dice dice = DiceFactory.get(DiceType.CROOKED);
    Assertions.assertTrue(dice instanceof CrookedDice);
  }
}