import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SwapAndDelete {
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

    private static int solve() throws IOException {
        String s = br.readLine().trim();
        int countOfOne = 0, countOfZero = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                countOfZero++;
            else
                countOfOne++;
        }

        int ts = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && countOfOne > 0) {
                ts++;
                countOfOne--;
            } else if (s.charAt(i) == '1' && countOfZero > 0) {
                ts++;
                countOfZero--;
            } else
                break;
        }

        return n - ts;
    }
}
