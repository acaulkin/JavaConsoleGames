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

    Boolean gameState;

    char currentPlayerSymbol;

    @Override
    public void playGame() {
        int[] coordinates;
        coordinates = null;
        Scanner scanner = Main.scanner;

        gameState = true;
        System.out.println("Welcome to Tic-Tac-Toe!");
        initializeGameBoard();
        displayGameBoard(coordinates);

        // Running the game
        currentPlayerSymbol = 'X';
        while (gameState == true) {
        
            // turn start
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

            if (currentPlayerSymbol == 'X') {
                currentPlayerSymbol = 'O';  
            }
            else {
                currentPlayerSymbol = 'X';
            }
        }

        System.out.println("Game Win!!!");
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

        // checking which column we want to edit, and replacing that value with 
        // a current temp value of 'X'. 
        char[] placementColumn = new char[3];
        switch (coordinate) {
            case 1:
                placementRow[1] = currentPlayerSymbol;
                placementColumn[0] = firstRow[1];
                placementColumn[1] = secondRow[1];
                placementColumn[2] = thirdRow[1];
                break;
            case 2:
                placementRow[8] = currentPlayerSymbol;
                placementColumn[0] = firstRow[8];
                placementColumn[1] = secondRow[8];
                placementColumn[2] = thirdRow[8];
                break;
            case 3:
                placementRow[15] = currentPlayerSymbol;
                placementColumn[0] = firstRow[15];
                placementColumn[1] = secondRow[15];
                placementColumn[2] = thirdRow[15];
                break;
        }

        return checkForGameWin(placementRow, placementColumn);
    }

    public char[] checkForGameWin(char[] placementRow, char[] placementColumn) {
        // initializing the left and right diaganols
        char leftDiag[] = {firstRow[1], secondRow[8], thirdRow[15]};
        char rightDiag[] = {firstRow[15], secondRow[8], thirdRow[1]};

        // checking row
        char rowCheck = placementRow[1];
        Boolean rowWin = true;
        for (int index = 1; index < placementRow.length; index = index + 7) {
            if (placementRow[index] != rowCheck) {
                rowWin = false;
                break;
            }
        }

        // checking column
        char columnCheck = placementColumn[0];
        Boolean columnWin = true;
        for (int index = 0; index < placementColumn.length; index++) {
            if (placementColumn[index] != columnCheck) {
                columnWin = false;
                break;
            }
        }

        // checking diaganols
        char leftDiagCheck = leftDiag[0];
        Boolean leftDiagWin = true;
        for (int index = 0; index < leftDiag.length; index++) {
            if (leftDiag[index] == ' ') {
                leftDiagWin = false;
                break;
            }
            if (leftDiag[index] != leftDiagCheck) {
                leftDiagWin = false;
                break;
            }
        }
        char rightDiagCheck = rightDiag[0];
        Boolean rightDiagWin = true;
        for (int index = 0; index < rightDiag.length; index++) {
            if (rightDiag[index] == ' ') {
                rightDiagWin = false;
                break;
            }
            if (rightDiag[index] != rightDiagCheck) {
                rightDiagWin = false;
                break;
            }
        }

        // checking if there are any win conditions, if there are, set the game's
        // state to false to end the game.
        if (rowWin == true || columnWin == true || leftDiagWin == true || rightDiagWin == true ) {
            gameState = false;
            return placementRow;
        }
        else {
            return placementRow;
        }
    }
}
