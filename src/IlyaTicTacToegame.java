import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 1/6/17.
 */
public class IlyaTicTacToegame {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [][] board = new char[4][];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean flag = false;
        for (int i = 0; i < board.length && !flag; i++) {
            for (int j = 0; j < board.length && !flag; j++) {
                // horizontal
                if (checkHorizontal(i, j, board)) {
                    flag = true;
                }

                if (checkVertical(i, j, board)) {
                    flag = true;
                }

                if (checkDiagonal(i, j, board)) {
                    flag = true;
                }

                if (checkReverseDiagonal(i, j, board)) {
                    flag = true;
                }
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    static boolean checkHorizontal(int i, int j, char [][] board) {
        int xs = 0;
        int os = 0;
        int cnt = 0;
        for (int c = j; c < j + 3 && c < 4; c++) {
            char ch = board[i][c];
            if (ch == 'x')
                xs ++;
            if (ch == 'o')
                os ++;
            cnt++;
        }
        return xs == 2 && os == 0 && cnt == 3;
    }

    static boolean checkVertical(int i, int j, char [][] board) {
        int xs = 0;
        int os = 0;
        int cnt = 0;
        for (int c = i; c < i + 3 && c < 4; c++) {
            char ch = board[c][j];
            if (ch == 'x')
                xs ++;
            if (ch == 'o')
                os ++;
            cnt++;
        }
        return xs == 2 && os == 0 && cnt == 3;
    }

    static boolean checkDiagonal(int i, int j, char [][] board) {
        int xs = 0;
        int os = 0;
        int cnt = 0;
        for (int c = 0; c < 3 && c + i < 4 && c + j < 4; c++) {
            char ch = board[c + i][j + c];
            if (ch == 'x')
                xs ++;
            if (ch == 'o')
                os ++;
            cnt++;
        }
        return xs == 2 && os == 0 && cnt == 3;
    }

    static boolean checkReverseDiagonal(int i, int j, char [][] board) {
        int xs = 0;
        int os = 0;
        int cnt = 0;
        for (int c = 0; c < 3 && i + c < 4 && j - c >= 0; c++) {
            char ch = board[i + c][j - c];
            if (ch == 'x')
                xs ++;
            if (ch == 'o')
                os ++;
            cnt++;
        }
        return xs == 2 && os == 0 && cnt == 3;
    }
}
