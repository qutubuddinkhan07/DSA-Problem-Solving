import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeAP {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();
            while (t-- > 0) {
                result.append(solve()).append("\n");
            }
            out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        boolean answer = false; // Initialize answer as false

        // Check if multiplying 'a' by some positive integer can make the sequence an AP
        long new_a = 2 * b - c; // Calculate the potential new value for 'a'
        if (new_a / a > 0 && new_a % a == 0) { // Check if new_a is a positive multiple of 'a'
            answer = true;
        }

        // Check if multiplying 'b' by some positive integer can make the sequence an AP
        long new_b = (a + c) / 2; // Calculate the potential new value for 'b'
        if (new_b / b > 0 && new_b % b == 0 && (c - a) % 2 == 0) { // Check if new_b is a positive multiple of 'b' and (c-a) is even
            answer = true;
        }

        // Check if multiplying 'c' by some positive integer can make the sequence an AP
        long new_c = 2 * b - a; // Calculate the potential new value for 'c'
        if (new_c / c > 0 && new_c % c == 0) { // Check if new_c is a positive multiple of 'c'
            answer = true;
        }

        return answer ? "YES" : "NO";
    }
    // Time Complexity (TC): O(1)
    // Space Complexity (SC): O(1)
}
