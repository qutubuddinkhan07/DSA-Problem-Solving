import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddGrasshopper {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            StringBuilder result = new StringBuilder();
            while (t-- > 0)
                result.append(solve()).append("\n");
            out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long start = Long.parseLong(st.nextToken());
        long jumps = Long.parseLong(st.nextToken());
        long finalPosition = 0;

        if (jumps % 4 == 1)
            finalPosition = jumps * -1;
        else if (jumps % 4 == 2)
            finalPosition = 1;
        else if (jumps % 4 == 3)
            finalPosition = jumps + 1;
        else if (jumps % 4 == 0)
            finalPosition = 0;

        if (start % 2 == 0)
            finalPosition = start + finalPosition;
        else
            finalPosition = start - finalPosition;

        return finalPosition;
    }
}
