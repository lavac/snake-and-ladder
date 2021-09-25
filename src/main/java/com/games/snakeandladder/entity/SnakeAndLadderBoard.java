package com.games.snakeandladder.entity;

import java.util.UUID;

public class SnakeAndLadderBoard {
  private int size;
  private Cell[] cells;

  public SnakeAndLadderBoard(int size) {
    this.size = size;
    cells = new Cell[size];

    for (int id =0; id < size; id++) {
      cells[id] = new Cell(id+1);
    }
  }

  public int getThePositionToBeMoved(int rolledNumber, int currentPosition, UUID playerId) {
    int positionToBeMoved = rolledNumber + currentPosition;
    if (positionToBeMoved > size) {
      return currentPosition;
    }
    else {
      int updatedPosition = positionToBeMoved;
      do {
        positionToBeMoved = updatedPosition;
        updatedPosition = getTheUpdatedPositionAfterGoingThroughSnakeOrLadder(positionToBeMoved, playerId);
      } while (positionToBeMoved != updatedPosition);
      return updatedPosition;
    }
  }

  private int getTheUpdatedPositionAfterGoingThroughSnakeOrLadder(int positionToBeMoved, UUID playerId) {
    Cell cellToBeMoved = getCell(positionToBeMoved);
    Obstacle obstacle = cellToBeMoved.getObstacle();
    if (obstacle != null) {
      if (!(obstacle instanceof Snake)) {
        System.out.printf("Player with Id:%s got the ladder at position %d so moving up to %d%n",
            playerId, obstacle.getStartPosition(), obstacle.getEndPosition());
      } else {
        System.out.printf("Player with Id:%s got bitten by snake at position %d so moving down to %d%n",
            playerId, obstacle.getStartPosition(), obstacle.getEndPosition());
      }
      return obstacle.getEndPosition();
    }
    return positionToBeMoved;
  }

  public void addObstacle(Obstacle obstacle) {
    int startingPosition = obstacle.getStartPosition();
    Cell cell = getCell(startingPosition);
    if (cell != null) {
      cell.setObstacle(obstacle);
    }
  }


  public Cell getCell(int id) {
    return  (id <= size) ? cells[id-1]: null;
  }
}
