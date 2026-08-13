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
            int n = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            int[] p = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = Integer.parseInt(st.nextToken());

            int fixed = 0;
            for (int i = 0; i < n; i++)
                if (p[i] == i + 1)
                    fixed++;

            int ans = (fixed + 1) / 2;
            res.append(ans).append("\n");
        }

        out.println(res);
        out.flush();
        br.close();
    }
}
