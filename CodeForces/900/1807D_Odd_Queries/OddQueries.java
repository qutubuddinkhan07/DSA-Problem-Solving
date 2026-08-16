import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddQueries {
    /**
     * Problem Link: https://codeforces.com/problemset/problem/1807/D
     * <p>
     * Time Complexity (TC): O(n + q) = O(2*10^5)
     * Space Complexity (SC): O(n) = O(2*10^5)
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            StringBuilder res = new StringBuilder();
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                StringTokenizer st;
                st = new StringTokenizer(br.readLine().trim());
                int n = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                // initializing the prefix sum array
                long[] a = new long[n];
                st = new StringTokenizer(br.readLine().trim());
                a[0] = Long.parseLong(st.nextToken());
                for (int i = 1; i < n; i++) {
                    a[i] = a[i - 1] + Long.parseLong(st.nextToken());
                }

                // taking input for 'q' queries
                while (q-- > 0) {
                    st = new StringTokenizer(br.readLine().trim());
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    long k = Long.parseLong(st.nextToken());

                    long segmentSum = (l == 1) ? a[r - 1] : a[r - 1] - a[l - 2];
                    /**
                     * The problem: when l = 1, there is nothing before position 1. You'd need a[-1],
                     * which doesn't exist — hence your ArrayIndexOutOfBoundsException. In that case, "everything before l" is
                     * just zero, and the sum of the range is simply the full prefix sum up to r, i.e., a[r-1]
                     *
                     * If l == 1: there's nothing to subtract, so segmentSum is just a[r-1] (the whole prefix sum up to r).
                     * Otherwise: subtract off a[l-2] (everything strictly before l) from a[r-1] (everything up to r), leaving
                     * exactly the sum of positions l through r.
                     */

                    long oldSum = a[n - 1];
                    long temp = (r - l + 1) * k;

                    long totalSum = oldSum - segmentSum + temp;
                    res.append(totalSum % 2 == 1 ? "YES" : "NO").append("\n");
                }
            }
            out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
