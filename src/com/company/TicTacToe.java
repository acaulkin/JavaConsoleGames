package com.company;

import java.util.Arrays;

import java.util.Scanner;

public class TicTacToe extends GameBoard {

    @Override
    public void displayGameBoard(int[] coordinates) {
        
        // initializing gameboard borders
        char topBorder[] = new char[17];
        char bottomBorder[] = topBorder;
        // filling the top and bottom borders
        Arrays.fill(topBorder, '-');

        char firstRow[] = new char[17];
        char secondRow[] = new char[17];
        char thirdRow[] = new char[17];

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

        // determining which row we need to edit
        if (coordinates != null) {
            switch (coordinates[0]) {
                case 1:
                    firstRow = placeGamePiece(coordinates[1], firstRow);
                    break;
                case 2:
                    secondRow = placeGamePiece(coordinates[1], firstRow);
                    break;
                case 3:
                    thirdRow = placeGamePiece(coordinates[1], firstRow);
                    break;
            }
        }
  
        System.out.println(topBorder);
        System.out.println(firstRow);
        System.out.println(secondRow);;
        System.out.println(thirdRow);;
        System.out.println(bottomBorder);
    }

    @Override
    public void playGame() {
        int[] coordinates;
        coordinates = null;
        Scanner scanner = Main.scanner;

        Boolean gameState = true;
        System.out.println("Welcome to Tic-Tac-Toe!");
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

    public char[] placeGamePiece(int coordinate, char[] placementRow) {
        placementRow[coordinate] = 'X';
        return placementRow;
    }
}
