
import com.company.SafeInput;

import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isPlaying = true;
        clearBoard();
        System.out.println("Welcome to TicTacToe! The first player will be the X's. Please enter the row:col separately as follows:");

        do {
            display();
            System.out.println("The first player will be the X's. Please enter the row:col separately as follows:");

            int xRow = SafeInput.getRangedInt(in, "Enter a row within the range: ", 1, 3) - 1;
            int xCol = SafeInput.getRangedInt(in, "Enter a column within the range: ", 1, 3) - 1;
            if (isValidMove(xRow, xCol)) {
                board[xRow][xCol] = "X";

            } else {
                System.out.println("Invalid move.");
            }

            if (isWin("X")) {
                System.out.println("Player X wins!");
                display();
                isPlaying = false;

            }

            System.out.println("THE BOARD: \n");
            display();
            boolean valid0 = false;
            System.out.println("The second player will be the O's. Please enter the row:col separately as follows:");
            int oRow = SafeInput.getRangedInt(in, "Enter a row within the range: ", 1, 3) - 1;
            int oCol = SafeInput.getRangedInt(in, "Enter a column within the range: ", 1, 3) - 1;
            if (isValidMove(oRow, oCol)) {
                board[oRow][oCol] = "O";

            } else {
                System.out.println("Invalid move.");
            }

            if (isWin("O")) {
                System.out.println("Player O wins!");
                display();
                isPlaying = false;
            }

            display();
//            isPlaying = SafeInput.getYNConfirm(in, "Would you like to continue? Type y/yes or n/no: ");
        } while (isPlaying);
    }

    private static void clearBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c] = " "; // make this cell a space
            }
        }
    }

    private static void display() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                System.out.print("[" + board[r][c] + "]");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for(int col=0; col < COL; col++) {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false; // no col win

    }
    private static boolean isRowWin(String player) {
        for(int row=0; row < ROW; row++) {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isDiagonalWin(String player) {
        if((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))) {
            return true;
        }
        return false;
    }
    private static boolean isTie() {
        if(isWin("O") || isWin("X"))
        {
            return false;
        }
        return true;
    }
}