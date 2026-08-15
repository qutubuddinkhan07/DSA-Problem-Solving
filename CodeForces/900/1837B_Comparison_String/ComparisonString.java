import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ComparisonString {
    /**
     * Here the intuition was to find the longest common substring
     * ex:  <<<<<<
     * here longest common substring is '<' which is of 5, so answer is 5 + 1
     * <p>
     * ex2: <><><><
     * here longest common substring is none only 1, so answer is 1+1
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        try (br; out) {
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String str = br.readLine().trim();

                int ans = 1;
                int count = 1;
                for (int i = 1; i < n; i++) {
                    if (str.charAt(i) != str.charAt(i - 1))
                        count = 1;
                    else {
                        count++;
                        ans = Math.max(ans, count);
                    }
                }
                res.append(ans + 1).append("\n");
            }

            out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        br.close();
    }
}
