import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MochaAndMath {
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
            System.out.println(e.getMessage());
        }
    }

    private static long solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());
        long totalAnd = arr[0];
        for (int i = 1; i < n; i++)
            totalAnd &= arr[i];

        return totalAnd;
    }
}
