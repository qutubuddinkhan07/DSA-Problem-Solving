import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinMaxGame {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            StringBuilder ans = new StringBuilder();
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0)
                ans.append(solve()).append("\n");

            out.println(ans);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[n];
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1)
                oneCount++;
            else
                zeroCount++;
        }

        if (oneCount > zeroCount || oneCount == zeroCount)
            return "Bessie";
        else
            return "Elsie";
    }
}
