import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RequiredRemainder {
    /*-
    Problem Link: https://codeforces.com/contest/1374/problem/A
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

    private static long solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        if (n - n % x + y <= n)
            return n - n % x + y;
        else
            return n - n % x - (x - y);
    }
}
