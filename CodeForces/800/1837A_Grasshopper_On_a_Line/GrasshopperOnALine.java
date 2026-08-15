import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GrasshopperOnALine {
    /**
     * When 'x' is not divisible by 'k', the grasshopper can reach 'x' in just one jump.
     * Otherwise, you can show that two jumps are always enough. For example, jumps 1
     * and x−1.
     * 1 is not divisible by any k>1. Also, x and x−1
     * can't be divisible by any k>1 at the same time.
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder res = new StringBuilder();
            StringTokenizer st;
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                if (x % k != 0) {
                    res.append(1).append("\n");
                    res.append(x).append("\n");
                } else {
                    res.append(2).append("\n");
                    res.append(1).append(" ").append(x - 1).append("\n");
                }
            }
            out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
