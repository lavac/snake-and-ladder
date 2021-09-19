package com.games.snakeandladder;

import com.games.snakeandladder.entity.CrookedDice;
import com.games.snakeandladder.entity.Dice;
import com.games.snakeandladder.entity.StraightDice;

public class DiceFactory {
  static Dice get(DiceType diceType) {
      if(diceType == DiceType.STRAIGHT)
        return new StraightDice();
      else return new CrookedDice();
  }
}
