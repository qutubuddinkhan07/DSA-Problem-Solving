import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DeletiveEditing {
    /**
     * Problem Link: https://codeforces.com/problemset/problem/1666/D
     *
     * <p>
     * Approach - first counting all the letters frequency in 't' string
     * then, traversing from right on the string 's' and subtracting from the frequency map
     * and adding the present character to the final_string as soon as the freq[char] becomes 0
     * then marking them as '.', finally matching the final_string with the 't' string
     * <p>
     *
     * <p>
     * Per test case:
     * Reading input & tokenizing: O(n+m)
     * Building frequency map from 't': O(m), with O(26) = O(1) extra space
     * Scanning 's' backwards and building 'finalString': O(n)
     * "finalString.reverse()": O(n)
     * "finalString.toString().equals(t)": O(n) in the worst case (converting to String is
     * O(n), plus comparision).
     *
     * <p>
     * Time Complexity: O(n+m) = O(30)
     * Space Complexity: O(n+m+26+m) = O(n+m) = O(30)
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        try (br; out) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0)
                res.append(solve()).append("\n");

            out.println(res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        String s = st.nextToken();

        String t = st.nextToken();
        int m = t.length();

        int[] freq = new int[26];
        for (int i = 0; i < m; i++)
            freq[t.charAt(i) - 'A']++;

        char[] charsS = s.toCharArray();
        int n = charsS.length;
        StringBuilder finalString = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int x = charsS[i] - 'A';
            if (freq[x] > 0) {
                freq[x]--;
                finalString.append(charsS[i]);
            } else
                charsS[i] = '.';
        }
        finalString.reverse();

        return finalString.toString().equals(t) ? "YES" : "NO";
    }
}
