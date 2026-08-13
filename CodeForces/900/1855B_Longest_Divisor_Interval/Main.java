import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            int i = 1;
            while (n % i == 0)  // O(60)
                i++;
            res.append(i - 1).append("\n");
        }
        out.println(res);
        out.flush();
        br.close();

        // Time complexity: O(60) ~ O(log n)
        // Space Complexity: O(1)
    }
}
