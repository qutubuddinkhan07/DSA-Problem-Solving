import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LuntikAndSubsequence {
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
            arr[i] = Integer.parseInt(st.nextToken());

        long countZeros = 0;
        long countOnes = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] == 0)
                countZeros++;
            else if (arr[i] == 1)
                countOnes++;

        long ways = (long) (Math.pow(2, countZeros) * countOnes);
        return ways;
    }
}
