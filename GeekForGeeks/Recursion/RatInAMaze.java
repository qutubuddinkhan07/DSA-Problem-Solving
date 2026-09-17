import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        // RatInAMazeSolution obj = new RatInAMazeSolution();
        RatInAMazeOptimalSolution obj = new RatInAMazeOptimalSolution();
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(obj.ratInMaze(maze));
    }
}

class RatInAMazeSolution {
    /*-
    Time Complexity: O(4^(mxn)), because of 4 directions
    Space Complexity: O(m x n), total number of cells because rat
     */
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] visited = new int[maze.length][maze[0].length];
        if (maze[0][0] == 1)
            helper(0, 0, "", visited, maze, ans);

        return ans;
    }

    private void helper(int index, int i, String moves, int[][] visited, int[][] maze, ArrayList<String> ans) {
        // Destination
        if (index == maze.length - 1 && i == maze[0].length - 1) {
            ans.add(moves);
            return;
        }

        // Boundary + blocked + already visited
        if (index >= maze.length || index < 0 || i >= maze[0].length || i < 0 || maze[index][i] == 0 || visited[index][i] == 1)
            return;

        // Mark the current call
        visited[index][i] = 1;

        // D
        if (index + 1 < maze.length) {
            helper(index + 1, i, moves + "D", visited, maze, ans);
        }

        // L
        if (i - 1 >= 0) {
            helper(index, i - 1, moves + "L", visited, maze, ans);
        }

        // R
        if (i + 1 < maze[0].length) {
            helper(index, i + 1, moves + "R", visited, maze, ans);
        }

        // U
        if (index - 1 >= 0) {
            helper(index - 1, i, moves + "U", visited, maze, ans);
        }

        // Backtrack
        visited[index][i] = 0;
    }
}

// ELIMINATING THE AGAIN & AGAIN USE OF 'if'
class RatInAMazeOptimalSolution {
    /*-
    Time Complexity: O(4^(m×n)), explore 4 directions: D, L, R, U
    Space Complexity: Auxiliary Space = O(m × n) + O(m × n) = O(m × n)
     */
    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> ans = new ArrayList<>();

        int[][] visited = new int[maze.length][maze[0].length];

        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};

        if (maze[0][0] == 1) {
            helper(0, 0, "", di, dj, visited, maze, ans);
        }

        return ans;
    }

    private void helper(int i, int j, String moves,
                        int[] di, int[] dj,
                        int[][] visited,
                        int[][] maze,
                        ArrayList<String> ans) {

        // Destination
        if (i == maze.length - 1 &&
                j == maze[0].length - 1) {

            ans.add(moves);
            return;
        }

        String dir = "DLRU";

        // Mark current cell
        visited[i][j] = 1;

        for (int ind = 0; ind < 4; ind++) {

            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if (nexti >= 0 &&
                    nextj >= 0 &&
                    nexti < maze.length &&
                    nextj < maze[0].length &&
                    visited[nexti][nextj] == 0 &&
                    maze[nexti][nextj] == 1) {

                helper(nexti, nextj, moves + dir.charAt(ind), di, dj, visited, maze, ans);
            }
        }

        // Backtrack
        visited[i][j] = 0;
    }
}
