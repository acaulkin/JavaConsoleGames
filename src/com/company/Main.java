package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int gameSelected  = decideGame();
        int[] coordinates;

        GameBoard firstGame;
        switch (gameSelected) {
            case 1:
                firstGame = new TicTacToe();
                firstGame.displayGameBoard(coordinates = null);
                firstGame.playGame();
        }
    }

    public static int decideGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Welcome to Java Console Games.");
        System.out.println("Please Select a game: ");
        System.out.println("1.) Tic-Tac-Toe");
        System.out.println("2.) Connect Four (still in development)");
        System.out.println("3.) Battleship (still in devlopment)");

        Integer gameSelected = Integer.parseInt(scanner.nextLine());  
        scanner.close();

        return gameSelected;
    }
}