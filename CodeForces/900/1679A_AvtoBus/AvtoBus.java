import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AvtoBus {
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
        long n = Long.parseLong(br.readLine().trim());
        if (n < 4 || n % 2 == 1)
            return "-1";
        else {
            long minBuses = (n + 5) / 6;
            long maxBuses = n / 4;
            return minBuses + " " + maxBuses;
        }
    }

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
}
