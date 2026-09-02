import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumOfMedians {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder ans = new StringBuilder();
            while (t-- > 0) {
                ans.append(solve()).append("\n");
            }
            out.println(ans);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        long[] arr = new long[(int) (n * k)];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n * k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long pointer = n * k;
        long sum = 0;

        while (k-- > 0) {
            pointer -= (n / 2 + 1);
            sum += arr[(int) pointer];
        }

        return sum;
    }
    /*-
    Time Complexity: O(n*k) - O(2*10^5)
    Space Complexity: O(n*k) - O(2*10^5)
     */
}
