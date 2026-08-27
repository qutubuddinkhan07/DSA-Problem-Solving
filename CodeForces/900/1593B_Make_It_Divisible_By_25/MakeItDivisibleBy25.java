import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class MakeItDivisibleBy25 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String n = br.readLine().trim();
                List<String> possibleValues = List.of("00", "25", "50", "75");
                int ans = Integer.MAX_VALUE;
                for (String possibleValue : possibleValues) {
                    ans = Math.min(ans, minOperations(n, possibleValue));
                }
                result.append(ans).append("\n");
            }
            out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int minOperations(String n, String possibleValue) {
        int operations = 0;
        int checkerIdx = possibleValue.length() - 1;

        // traverse on the number from last to begin
        for (int i = n.length() - 1; i >= 0; i--) {
            // check if the current digit matches the current character in possible values
            if (possibleValue.charAt(checkerIdx) == n.charAt(i)) {
                checkerIdx--;
                // if all the characters matched in possible values then break out of the loop
                if (checkerIdx < 0)
                    break;
            } else {
                operations++;
            }

        }
        if (checkerIdx >= 0)
            operations = Integer.MAX_VALUE;

        return operations;
    }

    /*-
    Time Complexity: O(4*20) = O(80)
    Space Complexity: O(20)
     */
}
