import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainakAndArray {
    /**
     * Problem Link: https://codeforces.com/problemset/problem/1726/A
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            StringBuilder ans = new StringBuilder();
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                ans.append(solve()).append("\n");
            }
            out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int ans = a[n - 1] - a[0];

        for (int i = 0; i < n; i++)
            ans = Math.max(ans, a[i] - a[0]);

        for (int i = 0; i < n - 1; i++)
            ans = Math.max(ans, a[n - 1] - a[i]);

        for (int i = 0; i < n - 1; i++)
            ans = Math.max(ans, a[i] - a[i + 1]);

        return ans;
    }
}
