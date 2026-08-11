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
            // taking inputs
            st = new StringTokenizer(br.readLine().trim());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            // populating the array
            long[] x = new long[n];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < n; i++) // O(n)
                x[i] = Long.parseLong(st.nextToken());

            // initializing the maximum time by initial timer 'b'
            long maxTime = b;
            for (long xi : x) // O(n)
                // calculating the maximum time by adding the minimum of each tool's increment and (a-1)
                maxTime += Math.min(xi, a - 1);

            // storing the maximum time until the bomb explodes
            res.append(maxTime).append("\n");
        }

        out.println(res);
        out.flush();
        br.close();
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}
