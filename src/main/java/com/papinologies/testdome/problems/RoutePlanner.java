package com.papinologies.testdome.problems;

public class RoutePlanner {

    public static int[][] dir = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 }
    };

    public static boolean walk(boolean[][] map, int currRow, int currColumn, int endRow, int endColumn,
            boolean[][] seen) {

        // base cases

        // if out of bounds
        if (currRow < 0 || currRow >= map.length || currColumn < 0 || currColumn >= map[0].length) {
            return false;
        }

        // if wall
        if (map[currRow][currColumn] == false) {
            return false;
        }

        // if reached destination
        if (currRow == endRow && currColumn == endColumn) {
            return true;
        }

        // if already visited
        if (seen[currRow][currColumn]) {
            return false;
        }

        // recurse steps
        // pre
        seen[currRow][currColumn] = true;
        // recurse
        for (int i = 0; i < dir.length; i++) {
            int newRow = currRow + dir[i][0];
            int newColumn = currColumn + dir[i][1];
            if (walk(map, newRow, newColumn, endRow, endColumn, seen)) {
                return true;
            }
        }

        return false;
    }

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
            boolean[][] mapMatrix) {
        boolean[][] seen = new boolean[mapMatrix.length][mapMatrix[0].length];
        return walk(mapMatrix, fromRow, fromColumn, toRow, toColumn, seen);
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                { true, false, false },
                { true, true, false },
                { false, true, true }
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}