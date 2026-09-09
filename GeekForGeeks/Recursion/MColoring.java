public class MColoring {
    public static void main(String[] args) {
        MColoringSolution obj = new MColoringSolution();
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3}
        };

        System.out.println(obj.graphColoring(4, edges, 3));
    }
}

class MColoringSolution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] color = new int[v];

        if (solve(0, color, m, v, edges))
            return true;

        return false;
    }

    private boolean solve(int node, int[] color, int m, int N, int[][] edges) {
        if (node == N) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, color, edges, N, i)) {
                color[node] = i;

                // Recursive check for the next node
                if (solve(node + 1, color, m, N, edges))
                    return true;

                color[node] = 0; // Backtrack if the color assignment fails
            }
        }

        return false;
    }

    private boolean isSafe(int node, int[] color, int[][] edges, int n, int col) {
		/*
		for (int k = 0; k<n; k++) {
			// check if the adjacent node have the same color
			if (k != node && graph[k][node] == 1 && color [k] == col) {
				return false;
			}
		}
		return true;
		*/

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (u == node && color[v] == col) {
                return false;
            }

            if (v == node && color[u] == col) {
                return false;
            }
        }
        return true;
    }
}
