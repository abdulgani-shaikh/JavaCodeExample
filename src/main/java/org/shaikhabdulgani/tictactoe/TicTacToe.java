package org.shaikhabdulgani.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    static final int BOX_SIZE = 3;
    static int[][] board;
    static boolean player1Turn;
    static int moveCount = 0;

    public static void main(String[] args) {
        board = new int[BOX_SIZE][BOX_SIZE];
        player1Turn = true;
        Scanner scanner = new Scanner(System.in);
        printBoard();
        while (true) {
            System.out.print(STR."Enter coordinates (\{player1Turn ? "Player1" : "Player2"}) : ");
            String input = scanner.nextLine();
            if (input.equals("exit")) return;
            if (input.equals("restart")) {
                resetGame();
                continue;
            }
            String[] index = input.split(" ");
            int x, y;
            try {
                if (index.length != 2) {
                    throw new RuntimeException();
                }
                x = Integer.parseInt(index[0]);
                y = Integer.parseInt(index[1]);
                if (x < 0 || x > BOX_SIZE-1 || y < 0 || y > BOX_SIZE-1) {
                    throw new RuntimeException();
                }
                if (board[x][y]!=0) throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("Enter valid input!!!");
                continue;
            }
            board[x][y] = player1Turn ? -1 : 1;
            printBoard();
            Result result = checkResult();
            if (result.didPlayer1Won()){
                System.out.println("-------------PLAYER 1 WON!!!!!!-------------");
                scanner.next();
                resetGame();
            }else if (result.didPlayer2Won()){
                System.out.println("-------------PLAYER 2 WON!!!!!!-------------");
                scanner.next();
                resetGame();
            } else if (checkResult().isDraw()) {
                System.out.println("-------------It's a draw-------------");
                scanner.next();
                resetGame();
            }else player1Turn = !player1Turn;
        }
    }

    private static void resetGame() {
        player1Turn = true;
        moveCount = 0;
        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                board[i][j] = 0;
            }
        }
    }

    private static Result checkResult() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]==-1 ? Result.PLAYER1WON : Result.PLAYER2WON;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] != 0 && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j]==-1 ? Result.PLAYER1WON : Result.PLAYER2WON;
            }
        }

        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]==-1 ? Result.PLAYER1WON : Result.PLAYER2WON;
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2]==-1 ? Result.PLAYER1WON : Result.PLAYER2WON;
        }

        if (moveCount==9)
            return Result.DRAW;

        return Result.NO_WINNER;
    }

    private static void printBoard() {
        System.out.print("   ");
        for (int i = 0; i < BOX_SIZE; i++) {
            System.out.print(STR." \{i} ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            int[] number = board[i];
            System.out.print(i + ". ");
            for (int j : number) {
                if (j == 0) System.out.print("   ");
                else if (j == 1) System.out.print(" X ");
                else System.out.print(" O ");
            }
            System.out.println();
        }
    }

    enum Result{
        PLAYER1WON,
        PLAYER2WON,
        DRAW,
        NO_WINNER;

        boolean didPlayer1Won(){
            return this==PLAYER1WON;
        }

        boolean didPlayer2Won(){
            return this==PLAYER2WON;
        }

        boolean isDraw(){
            return this==DRAW;
        }

        boolean isNoWinner(){
            return this==NO_WINNER;
        }
    }
}
