import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        // NQueenBruteSolution obj = new NQueenBruteSolution();
        NQueenOptimalSolution obj = new NQueenOptimalSolution();
        System.out.println(obj.solveNQueens(4));
        System.out.println(obj.solveNQueens(1));
    }
}

class NQueenBruteSolution {
    /*-
    Time Complexity: O(N! * N), we try all possible permutations of placing the queens and check for safety
    Space Complexity: O(N^2 + N), additional space used for storing distinct boards and stack space
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board, ans, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++)
                temp.add(new String(board[i]));

            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // Check left in the same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check Lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Return true if it's safe place
        return true;
    }
}

class NQueenOptimalSolution {
    /*-
    Time Complexity: O(N!), we try all possible permutations of placing the queens
    Space Complexity: O(N), three boolean arrays are stored to check for array
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        solve(0, board, n, leftRow, lowerDiagonal, upperDiagonal, ans);
        return ans;
    }

    private void solve(int col, char[][] board, int n, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, List<List<String>> ans) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            // check safety
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                // Place queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                // Recurse
                solve(col + 1, board, n, leftRow, lowerDiagonal, upperDiagonal, ans);

                // Backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}