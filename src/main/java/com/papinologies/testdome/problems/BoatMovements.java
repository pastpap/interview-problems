package com.papinologies.testdome.problems;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // Check if destination is out of bounds
        if (toRow < 0 || toRow >= gameMatrix.length || toColumn < 0 || toColumn >= gameMatrix[0].length) {
            return false;
        }

        // Calculate the relative movement
        int deltaRow = toRow - fromRow;
        int deltaColumn = toColumn - fromColumn;

        // Validate movement to the right (2 columns)
        if (deltaRow == 0 && deltaColumn == 2) {
            if (fromColumn + 2 < gameMatrix[0].length) {
                // Ensure all positions passed through are water
                return gameMatrix[fromRow][fromColumn + 1] && gameMatrix[fromRow][fromColumn + 2];
            }
            return false;
        }

        // Validate movement to the left (1 column)
        if (deltaRow == 0 && deltaColumn == -1) {
            return gameMatrix[toRow][toColumn];
        }

        // Validate vertical movements (1 row up or down)
        if (deltaColumn == 0) {
            if (Math.abs(deltaRow) == 1) {
                return gameMatrix[toRow][toColumn];
            }
        }

        // If no valid movement pattern matches
        return false;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                { false, true, true, false, false, false },
                { true, true, true, false, false, false },
                { true, true, true, true, true, true },
                { false, true, true, false, true, true },
                { false, true, true, true, false, true },
                { false, false, false, false, false, false },
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds

        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Valid move to the right (must check
                                                                 // intermediate position)
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 1)); // true, Valid move to the left
        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move up
        System.out.println(canTravelTo(gameMatrix, 3, 2, 4, 2)); // true, Valid move down
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}
