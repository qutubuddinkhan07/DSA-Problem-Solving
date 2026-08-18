import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    /**
     *
     * Problem Link: https://takeuforward.org/plus/dsa/problems/generate-binary-strings-without-consecutive-1s
     * <p>
     * Time Complexity: O(n^2),since each position has two choices
     * Space Complexity: O(n), per recursive path (due to call stack)
     */
    public static void main(String[] args) {
        GenerateBinaryStringsSolution obj = new GenerateBinaryStringsSolution();
        System.out.println(obj.generateBinaryStrings(3));
    }
}

class GenerateBinaryStringsSolution {
    public List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", result);
        return result;
    }

    void generate(int n, String curr, List<String> result) {
        // Base case: if length is n, add to result
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        // Always try adding '0'
        generate(n, curr + "0", result);

        // Add '1' only if previous char is not '1'
        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1')
            generate(n, curr + "1", result);
    }
}