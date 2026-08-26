import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ABBalance {
    /*-
    Problem Link: https://codeforces.com/problemset/problem/1606/A
    Approach: For every String "ab" == "ba"
    ex: "ab" = "ba" = 0 => "a" || "b" || "aaaaaaaaaaaaa" || "bbbbbbbbb"
        "ab" = "ba" = 1 => "aba" || "bab" || "aaaaaabaaaaaa" || "bbbbabbbb"
        "ab" = "ba" = 2 => "ababa" || "babab" || "aaabaaabaaaaaa" || "bbabbabbbb"
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0)
                result.append(solve()).append("\n");
            out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve() throws IOException {
        char[] chars = br.readLine().trim().toCharArray();
        if (chars[0] == chars[chars.length - 1])
            return new String(chars);
        else {
            chars[0] = chars[chars.length - 1];
            return new String(chars);
        }
    }
}
