public class WordSearch {
    public static void main(String[] args) {
        WordSearchSolution obj = new WordSearchSolution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(obj.exist(board, "ABCCED")); // true
        System.out.println(obj.exist(board, "SEE"));    // true
        System.out.println(obj.exist(board, "ABCB"));   // false
    }
}

class WordSearchSolution {
    /*-
    Time Complexity: O(n * m * 4^L), we may start from each of the 'n*m' cells, and explore upto 4 directions for each of the 'L' letters of the word
    Space Complexity: O(L), Recursion depth equals to length of the word, we also modify board in-place, so no extra space for visited tracking.
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // Iterate over all the cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start dfs if first character matches
                if (dfs(0, i, j, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, int row, int col, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Store character and mark visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found = dfs(index + 1, row + 1, col, board, word)
                || dfs(index + 1, row - 1, col, board, word)
                || dfs(index + 1, row, col + 1, board, word)
                || dfs(index + 1, row, col - 1, board, word);

        // Restore the character
        board[row][col] = temp;
        return found;
    }
}
