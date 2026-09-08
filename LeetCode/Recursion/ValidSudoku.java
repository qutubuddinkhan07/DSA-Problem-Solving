public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudokuSolution obj = new ValidSudokuSolution();
        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(obj.isValidSudoku(board));
    }
}

class ValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;

                if (!isValid(board, i, j, ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        // check row
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == ch)
                return false;
        }

        // check column
        for (int j = 0; j < 9; j++) {
            if (j != row && board[j][col] == ch)
                return false;
        }

        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = boxRowStart + i;
                int c = boxColStart + j;
                if ((r != row || c != col) && board[r][c] == ch)
                    return false;
            }
        }
        return true;
    }
}
