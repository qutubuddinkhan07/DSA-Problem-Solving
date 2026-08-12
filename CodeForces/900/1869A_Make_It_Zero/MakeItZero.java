import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItZero {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            if (n % 2 == 0) {
                res.append(2).append("\n");
                res.append("1 ").append(n).append("\n");
                res.append("1 ").append(n).append("\n");
            } else {
                res.append(4).append("\n");
                res.append("1 ").append(n - 1).append("\n");
                res.append("1 ").append(n - 1).append("\n");
                res.append(n - 1).append(" ").append(n).append("\n");
                res.append(n - 1).append(" ").append(n).append("\n");
            }
        }

        out.println(res);
        out.flush();
        br.close();
    }
    // Time Complexity (TC): O(n) = O(100)
    // Space Complexity (SC): O(n) = O(100)
}
