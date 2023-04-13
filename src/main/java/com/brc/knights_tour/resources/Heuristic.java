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

    public static int findBestMove(int currentKnightRow) {
        int move = -1;


        return move;
    }

} 
