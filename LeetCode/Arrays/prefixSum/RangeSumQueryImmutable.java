package prefixSum;

/*
 * Problem:    LC 303 - Range Sum Query - Immutable
 * Link:       https://leetcode.com/problems/range-sum-query-immutable/description/
 * Pattern:    Prefix Sum
 * Key idea:   Taking the prefix sum also the prefix array length should be of 1 + nums length
 * Time:       O(1), query time
 * Space:      O(n)
 * Solved:     after editorial
 * Date:       31/10/26 Sat 2026
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        // Create the NumArray object
        NumArrayImmutable obj = new NumArrayImmutable(nums);

        // Test range sum queries
        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}

class NumArrayImmutable {
    private int[] prefix;

    public NumArrayImmutable(int[] nums) {
        int n = nums.length;
        prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
