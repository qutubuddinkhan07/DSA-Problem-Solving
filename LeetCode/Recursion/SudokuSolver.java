public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        SudokuSolverSolution obj = new SudokuSolverSolution();
        obj.solveSudoku(board);

        printSudoku(board);
    }

    private static void printSudoku(char[][] board) {
        // Print solved board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class SudokuSolverSolution {
    /*-
    Time Complexity: O(9^(n^2)), in the worst case, for each cell in the n^2 board, we have 9 possible numbers.
    Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Recursive backtracking to solve Sudoku
    private boolean solve(char[][] board) {
        // Traverse all cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If cell is empty
                if (board[i][j] == '.') {
                    // Try all digits
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;   // place ch

                            // Recurse to solve rest
                            if (solve(board))
                                return true;

                            // Backtrack to solve rest
                            board[i][j] = '.';
                        }
                    }

                    // If no number fits, backtrack
                    return false;
                }
            }
        }

        // All cells filled correctly
        return true;
    }

    // Function to check if placing char 'c' at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char ch) {
        // Check current column for duplicates
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;
        }

        // Check current row for duplicates
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == ch)
                return false;
        }

        // Find start of 3x3 sub-box
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        // Check 3x3 box for duplicates
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == ch)
                    return false;
            }
        }

        /*
        // Another way to track if there is any row/col has same character

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false;
            if (board[i][col] == ch)
                return false;

            int boardRowStart = 3 * (row / 3);
            int boardColStart = 3 * (col / 3);

            if (board[boardRowStart + (i / 3)][boardColStart + (i % 3)] == ch)
                return false;

            return true;
        }
        */

        // No conflicts, placement is valid
        return true;
    }
}