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

    @Override
    public void displayGameBoard(int[] coordinates) {
    /*
        This function makes a call to edit the game board with the correct 
        coordinates, and prints out the current state of the board.
    */

        // editing the board with our current coordinates
        editGameBoard(coordinates);

        // printing current state
        System.out.println(topBorder);
        System.out.println(firstRow);
        System.out.println(secondRow);;
        System.out.println(thirdRow);;
        System.out.println(bottomBorder);
    }

    public void initializeGameBoard() {
    /*
        This method initializes the game board on start of game play.
    */

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

    public void editGameBoard(int[] coordinates) {
    /*
        This method edits the game board to place a game piece at our specified
        location.
    */

        // determining which row we need to edit, and passing that row to our
        // method that edits a particular row and places a game piece on it.
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
    }

    public char[] placeGamePiece(int coordinate, char[] placementRow) {
    /*
        This method places a game piece on the board given a coordinate value 
        and placement row.
    */

        // TODO: Have below take a character that is defined as either 'X' or as
        // 'O'.
        
        // checking which column we want to edit, and replacing that value with 
        // a current temp value of 'X'. 
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
}
