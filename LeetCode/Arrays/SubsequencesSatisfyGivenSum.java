import java.util.Arrays;

public class SubsequencesSatisfyGivenSum {
    /*-
    Problem - Number of Subsequences That Satisfy the Given Sum Condition
    Problem Link - https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
     */
    public static void main(String[] args) {
        SubsequencesSatisfyGivenSum obj = new SubsequencesSatisfyGivenSum();
        System.out.println(obj.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(obj.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(obj.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(obj.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int MOD = 1_000_000_007;

        // pow2[k] = 2^k mod (1e9+7), precomputed once
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        long count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // nums[left] is the min; every element strictly between
                // left and right is free to be included or excluded
                count = (count + pow2[right - left]) % MOD;
                left++;
            } else {
                // nums[right] is too big to ever pair with any left as a max —
                // discard it permanently
                right--;
            }
        }
        return (int) count;
    }

    /*-
    Intuition

    1. Sort first, so "min" and "max" become positional. Once nums is sorted, the min and max of any subsequence you pick are simply its leftmost and rightmost chosen elements. You no longer need to scan a subsequence to find its min/max — position tells you.

    2. Two pointers, converging inward, decide which pairs are even possible. left is a candidate min, right is a candidate max.

    If nums[left] + nums[right] <= target, this pairing works.
    If it doesn't, nums[right] is too large to ever work as a max — not just for this left, but for every later left too, since nums[left] only grows as left advances (sorted order), which only makes the sum bigger. So right can be safely and permanently discarded by decrementing it. This can cut off several trailing values in a row before a valid pairing is found, not just one at a time.

    3. Once a pairing is valid, counting becomes pure combinatorics — no enumeration needed. With nums[left] locked in as the min and nums[right] as the largest valid max, every element strictly between them is free to be included or excluded — it can't affect the min or max either way. k free elements have exactly 2^k subsets, so the number of valid subsequences for this left is 2^(right-left), no recursion or generation required.

    4. Precompute the powers of 2 once. Since right-left can be up to n-1 (~10^5), and the counts must be taken mod 1e9+7 per the problem, powers are precomputed top-down in O(n) so each lookup during the sweep is O(1) instead of recomputing a modular power on the fly.

    Put together: sorting removes the need to search for min/max, the two-pointer shrink removes the need to check validity per subsequence (the window guarantees it), and pow2 removes the need to enumerate subsequences to count them.

    Complexity

    Time: O(n log n)

    Sorting: O(n log n).
    Building pow2: O(n).
    Two-pointer sweep: O(n) — left and right each move at most n times total across the whole loop.
    Overall dominated by the sort.

    Space: O(n)

    pow2 array: O(n).
    No recursion, no storage of subsequences — a few pointers/counters only.
    (Sorting a primitive array in Java uses O(log n) auxiliary stack space internally, which doesn't change the overall bound.)
     */
}
