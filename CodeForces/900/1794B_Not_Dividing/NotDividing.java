import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotDividing {
    /**
     * Problem Link: https://codeforces.com/problemset/problem/1794/B
     * Approach: Increment a[i] if 1, and iff a[i+1] % a[i] == 0, then increment a[i+1] by 1
     * Time Complexity:  O(n)
     * Space Complexity: O(1), because not using any extra space
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder res = new StringBuilder();
            while (t-- > 0) {
                res.append(solve()).append("\n");
            }
            out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { // O(n)
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) // O(n)
            if (a[i] == 1)
                a[i]++;

        for (int i = 0; i < n - 1; i++) { // O(n)
            if (a[i + 1] % a[i] == 0)
                a[i + 1]++;
        }

        for (int i = 0; i < n; i++) { // O(n)
            res.append(a[i]).append(" ");
        }

        return res.toString();
    }
}