import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BadBoy {
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

    private static String solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        return 1 + " " + 1 + " " + n + " " + m;
    }
}
