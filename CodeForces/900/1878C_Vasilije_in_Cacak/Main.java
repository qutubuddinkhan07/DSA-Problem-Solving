import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine().trim());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long minSum = (k * (k + 1)) / 2;
            long totalSum = (n * (n + 1)) / 2;
            long maxSum = totalSum - ((n - k) * ((n - k) + 1)) / 2;

            res.append((x >= minSum) && (x <= maxSum) ? "Yes" : "No").append("\n");
        }

        out.println(res);
        out.flush();
        br.close();
    }
}
