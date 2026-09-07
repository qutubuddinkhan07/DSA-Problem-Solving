import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Raspberries {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0)
                ans.append(solve()).append("\n");
            out.println(ans);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        long ans = Integer.MAX_VALUE;
        long evenCount = 0;
        for (long a : arr) {
            if (a % 2 == 0)
                evenCount++;
            if (a % k == 0)
                ans = 0;
            ans = Math.min(ans, (k - a % k));
        }

        if (k == 4) {
            if (evenCount >= 2)
                ans = Math.min(ans, 0L);
            else if (evenCount == 1)
                ans = Math.min(ans, 1L);
            else if (evenCount == 0)
                ans = Math.min(ans, 2L);
        }

        return ans;
    }
}
