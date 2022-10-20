package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static String[] board;
    static String turn;

    static String winner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int i = 0; i < 13; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 12) {
                return "Draw";
            }
        }
        System.out.println(turn + "'s turn. Enter a slot number: " + turn);
        return null;
    }

    static void printTheBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
        System.out.println("Welcome to TicTacToe!");
        printTheBoard();
        System.out.println("X will play first. Enter a slot number to play.");
        while (winner == null) {
            int numberInput = 0;
            try {
                String numberInputtxt = in.nextLine();
                numberInput = Integer.parseInt(numberInputtxt);
                if (!(numberInput > 0 && numberInput <= 9)) {
                    System.out.println("You have entered and invalid number, please try again.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("You have entered and invalid input. Please enter a valid slot number.");
                continue;
            }
            if (board[numberInput - 1].equals(String.valueOf(numberInput))) {
                board[numberInput - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printTheBoard();
                winner = winner();
            } else {
                System.out.println("This slot is already taken. Please try again.");
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thank You for Playing!");
        } else {
            System.out.println("Congratulations!" + winner + "'s WON! Thank you for playing.");
        }
    }
}
