import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PermutationSwap {
    /**
     * Time Complexity: O(n log n) = O(10^5 * 20) = O(2 * 10^6)
     * Space Complexity: O(n) = O(10^5)
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder res = new StringBuilder();
            StringTokenizer st;
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                int[] a = new int[n + 1];
                st = new StringTokenizer(br.readLine().trim());
                for (int i = 1; i <= n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }

                int k = Math.abs(a[1] - 1);
                for (int i = 2; i <= n; i++) {
                    int diff = Math.abs(a[i] - i);
                    k = findgcd(k, diff);
                }

                res.append(k).append("\n");
            }

            out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findgcd(int a, int b) {
        if (b == 0)
            return a;
        return findgcd(b, a % b);
    }
}
