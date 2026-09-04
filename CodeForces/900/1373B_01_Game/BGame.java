import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BGame {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder ans = new StringBuilder();
            while (t-- > 0)
                ans.append(solve()).append("\n");
            out.println(ans);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve() throws IOException {
        String s = br.readLine().trim();
        int countZeros = 0, countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                countZeros++;
            else countOnes++;
        }
        int operations = Math.min(countOnes, countZeros);
        if (operations % 2 != 0)
            return "DA";
        else
            return "NET";
    }
}
