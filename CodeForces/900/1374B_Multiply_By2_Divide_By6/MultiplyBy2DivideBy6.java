import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MultiplyBy2DivideBy6 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static PrintWriter out = new PrintWriter(System.out);

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

    private static long solve() throws IOException {
        long n = Long.parseLong(br.readLine().trim());
        long countOf3 = 0;
        long countof2 = 0;

        while (n % 3 == 0) {
            countOf3++;
            n /= 3;
        }

        while (n % 2 == 0) {
            countof2++;
            n /= 2;
        }

        if (n > 1 || (countof2 > countOf3))
            return -1;
        else
            return (countOf3 - countof2) + countOf3;
    }
}
