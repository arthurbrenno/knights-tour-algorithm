package com.brc.knights_tour.resources;

public class Heuristic {
    private static int[][] acessibility = {
        {2, 3, 4, 4, 4, 4, 3, 2},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {4, 6, 8, 8, 8, 8, 6, 4}, 
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {2, 3, 4, 4, 4, 4, 3, 2},
    };

    private static int currentAcessibilityRow;
    private static int currentAcessibilityCol;
    private static final int[] horizontalMovements = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] verticalMovements = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] allPossibleMovements = new int[8]; //stores the acessibility value at movement[0], movement[1]...

	// ************************************************
	// 
	// Getters and Setters
	// 
	// ************************************************

    public static int[][] getAcessibility() {
        return acessibility;
    }

    public static int getAcessibilityAtPosition(int row, int col) {
        return acessibility[row][col];
    }

    public static void setValueAtPosition(int value, int row, int col) {
        acessibility[row][col] = value;
    }

    public static void setCurrentAcessibilityRow(int row) {
        currentAcessibilityRow = row;
    }

    public static void setCurrentAcessibilityCol(int col) {
        currentAcessibilityCol = col;
    }

    // ************************************************
	// 
	// Class methods
	// 
	// ************************************************
    
    public static int findBestMove(Knight knight, ChessBoard chessBoard) {
        currentAcessibilityRow = knight.getCurrentRow();
        currentAcessibilityCol = knight.getCurrentCol();
        int bestMovement = 0;
        int smallestNumber = Integer.MAX_VALUE;
        int smallestNumberIndex = 0;
        
        //Fill allPossibleMovement array
        for (int movement = 0; movement < 8; movement++) {
            if (knight.isPossibleMovement(movement, chessBoard)) {
                if (!(chessBoard.wasVisited(currentAcessibilityRow + verticalMovements[movement], currentAcessibilityCol + horizontalMovements[movement]))) {
                    allPossibleMovements[movement] = getAcessibilityAtPosition(currentAcessibilityRow + verticalMovements[movement], currentAcessibilityCol + horizontalMovements[movement]);
                }
            }
        }

        //find the smallest number and index;
        for (int i = 0; i < allPossibleMovements.length; i++) {
            if (allPossibleMovements[i] < smallestNumber && allPossibleMovements[i] != 0) {
                smallestNumber = allPossibleMovements[i];
                smallestNumberIndex = i;
                bestMovement = smallestNumberIndex;
                allPossibleMovements[i] = 0;
            }
        }
        resetAllPossibleNumbers();
        return bestMovement;
    }

    private static void resetAllPossibleNumbers() {
        for(int i = 0; i < allPossibleMovements.length; i++) {
            allPossibleMovements[i] = 0;
        }
    }
} 
