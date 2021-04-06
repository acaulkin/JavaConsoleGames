package com.company;

import java.util.Arrays;

public class TicTacToe extends GameBoard {

    @Override
    public void displayGameBoard() {
        
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

        System.out.println(topBorder);
        System.out.println(firstRow);
        System.out.println(secondRow);;
        System.out.println(thirdRow);;
        System.out.println(bottomBorder);

    }

}
