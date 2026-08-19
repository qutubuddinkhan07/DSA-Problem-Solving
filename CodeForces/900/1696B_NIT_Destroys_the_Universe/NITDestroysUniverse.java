import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NITDestroysUniverse {
    /**
     * Problem Link: https://codeforces.com/problemset/problem/1696/B
     * Time Complexity (TC): O(n) = O(2*10^5)
     * Space Complexity (SC): O(n) = O(2*10^5)
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try (br; out) {
            StringBuilder res = new StringBuilder();
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                res.append(solve()).append("\n");
            }
            out.print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int countZeros = 0;
        for (int a : arr)
            if (a == 0)
                countZeros++;

        // Flag to check if there is any zero between non-zero elements
        boolean foundZero = false;

        int left = 0, right = n - 1;

        // Find the first non-zero element from the left
        while (left < n && arr[left] == 0)
            left++;
        // Find the first non-zero element from the right
        while (right >= 0 && arr[right] == 0)
            right--;

        // Check if there is any zero between the first and last non-zero elements
        for (int i = left; i <= right; i++) {
            if (arr[i] == 0)
                foundZero = true;
        }

        // Determine the minimum number of operations needed
        if (countZeros == n)
            return 0;
        else if (foundZero == false)
            return 1;
        else
            return 2;
    }
}
