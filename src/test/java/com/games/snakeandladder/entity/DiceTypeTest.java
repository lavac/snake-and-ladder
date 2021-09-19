package com.games.snakeandladder.entity;

import com.games.snakeandladder.exception.InvalidDiceTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiceTypeTest {

  @Test
  void shouldReturnStraightDiceWhenInputStringIsStraight() {
    DiceType straight = DiceType.getDiceType("Straight");
    Assertions.assertEquals(DiceType.STRAIGHT, straight);
  }

  @Test
  void shouldReturnCrookedDiceWhenInputStringIsCrooked() {
    DiceType crooked = DiceType.getDiceType("Crooked");
    Assertions.assertEquals(DiceType.CROOKED, crooked);
  }

  @Test
  void shouldThrowExceptionWhenInputStringIsInvalid() {
    InvalidDiceTypeException exception = Assertions.assertThrows(InvalidDiceTypeException.class,
        () -> DiceType.getDiceType("InvalidType"));
    Assertions.assertEquals("Error :- Invalid dice type, valid types are Straight and Crooked",
        exception.getMessage());
  }
}