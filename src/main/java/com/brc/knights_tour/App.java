package com.brc.knights_tour;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.brc.knights_tour.resources.*;

public class App {
    /*Controls */
    private static final int BOARD_SIZE = 8; //You should not change this.
    private static final int START_KNIGHT_ROW = 0;
    private static final int START_KNIGHT_COL = 0;
    private static final int NUMBER_OF_MOVEMENTS = 64;
    private static final int NUMBER_OF_TOURS = 1;
    private static final boolean CHECK_FOR_VISITED_PLACES = true;

    /*Objects */
    private static final Scanner scanner = new Scanner(System.in);
    private static ChessBoard chessBoard = new ChessBoard(BOARD_SIZE);
    private static Knight knight = new Knight(START_KNIGHT_ROW, START_KNIGHT_COL);
    
    /*Class variables */
    private static int knightMovementType;

    // ************************************************
	// 
	// Main Aplication
	// 
	// ************************************************

    public static void main(String[] args) {
        prepareTour();
        for (int tour = 0; tour < NUMBER_OF_TOURS; tour++) {
            for (int movement = 0; movement < NUMBER_OF_MOVEMENTS; movement++) {
                clearConsole();
                displayMovements();
                chessBoard.display();
                showCommands();
                knightMovementType = Heuristic.findBestMove(knight, chessBoard);
                moveTheKnight();
            }
        }
    }

    // ************************************************
	// 
	// App methods
	// 
	// ************************************************

    public static void displayMovements() {
        System.out.printf("[MOVEMENTS: %d]%n", knight.getHouseCount());
    }

    public static void prepareTour() {
        chessBoard.placePiece(knight, START_KNIGHT_ROW, START_KNIGHT_COL);
        Heuristic.setCurrentAcessibilityRow(START_KNIGHT_ROW);
        Heuristic.setCurrentAcessibilityCol(START_KNIGHT_COL);
    }

    public static void showCommands() {
        System.out.println();
        System.out.printf("  %s     %s  %n", (knight.isPossibleMovement(2, chessBoard)) ? "2" : "", (knight.isPossibleMovement(1, chessBoard)) ? "1" : "");
        System.out.printf("%s         %s%n", (knight.isPossibleMovement(3, chessBoard)) ? "3" : "", (knight.isPossibleMovement(0, chessBoard)) ? "0" : "");
        System.out.printf("     K     %n");
        System.out.printf("%s         %s%n", (knight.isPossibleMovement(4, chessBoard)) ? "4" : "", (knight.isPossibleMovement(7, chessBoard)) ? "7" : "");
        System.out.printf("  %s     %s  %n", knight.isPossibleMovement(5, chessBoard) ? "5" : "", (knight.isPossibleMovement(6, chessBoard)) ? "6" : "");
        System.out.println();
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: Different implementation
    public static void moveTheKnight() {
        knight.moveCheckingVisitedPlaces(knightMovementType, chessBoard);
    }

}
