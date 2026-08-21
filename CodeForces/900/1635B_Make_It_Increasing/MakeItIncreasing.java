import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItIncreasing {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
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

        long ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            while (arr[i] >= arr[i + 1]) {
                ans++;
                arr[i] /= 2;
                if (arr[i] == 0)
                    break;
            }
            if (arr[i] == 0 && arr[i + 1] == 0) {
                ans = -1;
                break;
            }
        }

        return ans;
    }
}
