package com.company;

import java.util.Arrays;

import java.util.Scanner;

public class TicTacToe extends GameBoard {
    // initializing gameboard borders
    char topBorder[] = new char[17];
    char bottomBorder[] = topBorder;

    char firstRow[] = new char[17];
    char secondRow[] = new char[17];
    char thirdRow[] = new char[17];

    @Override
    public void displayGameBoard(int[] coordinates) {
        
        // determining which row we need to edit
        if (coordinates != null) {
            switch (coordinates[0]) {
                case 1:
                    firstRow = placeGamePiece(coordinates[1], firstRow);
                    break;
                case 2:
                    secondRow = placeGamePiece(coordinates[1], secondRow);
                    break;
                case 3:
                    thirdRow = placeGamePiece(coordinates[1], thirdRow);
                    break;
            }
        }
  
        System.out.println(topBorder);
        System.out.println(firstRow);
        System.out.println(secondRow);;
        System.out.println(thirdRow);;
        System.out.println(bottomBorder);
    }


    public char[] placeGamePiece(int coordinate, char[] placementRow) {

        switch (coordinate) {
            case 1:
                placementRow[1] = 'X';
                break;
            case 2:
                placementRow[8] = 'X';
                break;
            
            case 3:
            placementRow[15] = 'X';
            break;
        }

        return placementRow;
    }

    public void initializeGameBoard() {
        // filling the top and bottom borders
        Arrays.fill(topBorder, '-');

        // filling the inside rows
        Arrays.fill(firstRow, ' ');
        firstRow[0] = '|'; 
        firstRow[16] = '|';
        Arrays.fill(secondRow, ' ');
        secondRow[0] = '|'; 
        secondRow[16] = '|';
        Arrays.fill(thirdRow, ' ');
        thirdRow[0] = '|'; 
        thirdRow[16] = '|';
    }

    @Override
    public void playGame() {
        int[] coordinates;
        coordinates = null;
        Scanner scanner = Main.scanner;

        Boolean gameState = true;
        System.out.println("Welcome to Tic-Tac-Toe!");
        initializeGameBoard();
        // Running the game
        while (gameState == true) {
        
            // turn start
            displayGameBoard(coordinates);
            System.out.println("Enter the coordinates: ");
            
            // reading input from user
            String movePlacement  = scanner.nextLine();
            String[] movePlacementArray = movePlacement.split(" ");

            // converting string array to integer array
            coordinates = new int[movePlacementArray.length];
            for (int index = 0; index < coordinates.length; index++) {
                coordinates[index] = Integer.parseInt(movePlacementArray[index]);
            }

            displayGameBoard(coordinates);

        }
    }
}
