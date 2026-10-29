import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MakeK_SubarraySumsEqual {
    public static void main(String[] args) {
        // MakeK_SubarraySumsEqualApproachI obj = new MakeK_SubarraySumsEqualApproachI();
        MakeK_SubarraySumsEqualApproachII obj = new MakeK_SubarraySumsEqualApproachII();
        int[] arr = {1, 4, 1, 3};
        int[] arr2 = {2, 5, 5, 7};
        System.out.println(obj.makeSubKSumEqual(arr, 2));
        System.out.println(obj.makeSubKSumEqual(arr2, 3));
    }
}

class MakeK_SubarraySumsEqualApproachI {
    /*
     * LeetCode 2607. Make K-Subarray Sums Equal [https://leetcode.com/problems/make-k-subarray-sums-equal/description/]
     *
     * ============================== INTUITION ==============================
     *
     * 1) From sums to equal elements:
     *    Compare two neighbouring windows of length k:
     *       sum(i .. i+k-1)   = arr[i] + arr[i+1] + ... + arr[i+k-1]
     *       sum(i+1 .. i+k)   =          arr[i+1] + ... + arr[i+k-1] + arr[i+k]
     *    The middle part is shared, so for the sums to be equal:
     *       arr[i] == arr[(i + k) % n]
     *    So "all k-subarray sums equal" is the same as
     *    "every element equals the element k steps ahead (circularly)".
     *
     * 2) Which indices are forced to be equal?
     *    Starting from index i and jumping by k around a circle of size n,
     *    we visit exactly the indices with the same remainder mod g,
     *    where g = gcd(n, k).
     *    So the array splits into g independent groups:
     *       group s = { s, s+g, s+2g, ... }   for s = 0 .. g-1
     *    All values inside one group must become equal.
     *
     * 3) Cheapest way to make a group equal (+1 / -1 per operation):
     *    Move every number to the MEDIAN of the group.
     *    Reason: if the target T moves up by 1, numbers below T cost 1 more
     *    and numbers above T cost 1 less. The cost stops decreasing when
     *    the counts on both sides are balanced, which is at the median.
     *    Cost of a group = sum of |x - median|.
     *
     *    Answer = sum of costs of all g groups.
     *
     * ============================== DRY RUN 1 ==============================
     *
     *  arr = [1, 4, 1, 3], k = 2, n = 4
     *  g = gcd(4, 2) = 2
     *
     *  start = 0 -> indices 0, 2 -> group = [1, 1]
     *      sorted = [1, 1], median = group[1] = 1
     *      cost = |1-1| + |1-1| = 0
     *
     *  start = 1 -> indices 1, 3 -> group = [4, 3]
     *      sorted = [3, 4], median = group[1] = 4
     *      cost = |3-4| + |4-4| = 1
     *
     *  ans = 0 + 1 = 1   (final array e.g. [1, 4, 1, 4], all 2-sums = 5)
     *
     * ============================== DRY RUN 2 ==============================
     *
     *  arr = [2, 5, 5, 7], k = 3, n = 4
     *  g = gcd(4, 3) = 1   -> only one group containing everything
     *
     *  start = 0 -> indices 0, 1, 2, 3 -> group = [2, 5, 5, 7]
     *      sorted = [2, 5, 5, 7], median = group[2] = 5
     *      cost = |2-5| + |5-5| + |5-5| + |7-5| = 3 + 0 + 0 + 2 = 5
     *
     *  ans = 5   (final array [5, 5, 5, 5], all 3-sums = 15)
     *
     * ============================== COMPLEXITY ==============================
     *
     *  Time  : O(n log n)  -> sorting the groups (total size n)
     *  Space : O(n)        -> temporary group arrays
     *  Note  : answer can exceed int range (n up to 1e5, values up to 1e9),
     *          so we use long.
     */
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;

        // Number of independent groups (cycles when jumping by k in a circle)
        int g = gcd(n, k);
        long ans = 0;

        for (int start = 0; start < g; start++) {
            // Collect one group: start, start+g, start+2g, ...
            int[] group = new int[n / g];
            int idx = 0;
            for (int i = start; i < n; i += g) {
                group[idx++] = arr[i];
            }

            // Median minimizes total |x - target| distance
            Arrays.sort(group);
            int median = group[group.length / 2];

            // Cost to make every element of this group equal to the median
            for (int x : group) {
                ans += Math.abs((long) x - median);
            }
        }
        return ans;
    }

    // Euclid's algorithm: gcd(a, b) = gcd(b, a % b), gcd(a, 0) = a
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

class MakeK_SubarraySumsEqualApproachII {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        long res = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            // Walk the cycle i -> i+k -> i+2k ... (mod n)
            List<Integer> cycle = new ArrayList<>();

            for (int j = i; !visited[j]; j = (j + k) % n) {
                cycle.add(arr[j]);
                visited[j] = true;
            }

            Collections.sort(cycle);
            for (int num : cycle) {
                res += Math.abs(num - cycle.get(cycle.size() / 2));
            }
        }
        return res;
    }
}