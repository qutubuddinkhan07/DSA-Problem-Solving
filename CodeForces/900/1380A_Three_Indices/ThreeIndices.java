import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeIndices {
    /*-
    Problem Link: https://codeforces.com/contest/1380/problem/A
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder ans = new StringBuilder();
            while (t-- > 0)
                ans.append(solve()).append("\n");
            out.println(ans);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // ==================== BRUTE APPROACH =======================
    /*-
     private static String solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        int[] permutation = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
            permutation[i] = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for (int j = 1; j < n - 1; j++) {
            int i = -1;
            int k = -1;
            for (int left = 0; left < j; left++) {
                if (permutation[left] < permutation[j]) {
                    i = left;
                    break;
                }
            }

            for (int right = j + 1; right < n; right++) {
                if (permutation[right] < permutation[j]) {
                    k = right;
                    break;
                }
            }

            if (i != -1 && k != -1) {
                flag = true;
                return "YES\n" + (i + 1) + " " + (j + 1) + " " + (k + 1);
            }
        }
        return "NO";
    }
    */
    /*-
    TC: O(n^2)
    SC: O(1)
     */

    // ==================== OPTIMAL APPROACH =======================

    private static String solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        int[] permutation = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
            permutation[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n - 1; i++) {
            if (permutation[i - 1] < permutation[i] && permutation[i] > permutation[i + 1]) {
                return "YES\n" + i + " " + (i + 1) + " " + (i + 2);
            }
        }
        return "NO";
    }
    /*-
    TC: O(n)
    SC: O(1)
     */
}
