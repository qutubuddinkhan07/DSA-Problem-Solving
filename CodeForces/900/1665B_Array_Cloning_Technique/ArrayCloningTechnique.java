import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ArrayCloningTechnique {
    /*-
    Problem Link: https://codeforces.com/problemset/problem/1665/B

    Approach - Finding the maximum frequency element, then as the problem describes cloning
        and swapping the elements to match with the max frequency element, at last the when all the
        elements are equal return it.
     */
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();    // storing the result
        try (br; out) {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                ans.append(solve()).append("\n");
            }

            out.println(ans);   // printing the answer
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static long solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)     // initializing the array, O(n)
            arr[i] = Long.parseLong(st.nextToken());

        Map<Long, Integer> mpp = new HashMap<>();   // to store all frequencies
        for (long a : arr) {    // O(n)
            mpp.put(a, mpp.getOrDefault(a, 0) + 1);
        }

        long currentMaxFreq = 0;    // to store the current maximum frequency
        for (Map.Entry<Long, Integer> entry : mpp.entrySet()) {
            currentMaxFreq = Math.max(currentMaxFreq, entry.getValue());
        }

        long operations = 0;
        while (currentMaxFreq < n) {    // O(log2n)
            operations++;   // to clone the array
            if (currentMaxFreq * 2 <= n) {  // swap all the copies
                operations += currentMaxFreq;
                currentMaxFreq *= 2;
            } else {                        // swap only required copies
                operations += n - currentMaxFreq;
                currentMaxFreq = n;
            }
        }

        return operations;
    }

    /*-
    Time Complexity - O(n) + O(n) + O(log2n) = O(nlog2n) = O(10^5 * log2(10^5)) = O(2 * 10^6)
    Space Complexity - O(n)
     */
}
