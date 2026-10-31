package prefixSum;

public class RangeSumQueryMutable {
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
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        // Create the NumArray object
        NumArrayMutableApproachI obj = new NumArrayMutableApproachI(nums);

        // Test range sum queries
        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}

/* Direct summation will fail TLE */
class NumArrayMutableApproachI {
    private int[] nums;

    public NumArrayMutableApproachI(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/* Using Prefix Sum will fail TLE */
class NumArrayMutableApproachII {
    private int[] nums;
    private int[] prefix;

    public NumArrayMutableApproachII(int[] nums) {
        this.nums = nums;
        calcPrefixSum(nums);
    }

    public void update(int index, int val) {
        nums[index] = val;
        calcPrefixSum(nums);
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    private void calcPrefixSum(int[] nums) {
        int n = nums.length;
        prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

}

/**
 * ====== Fenwick Tree =====
 * Constructor  -   O(n log n)
 * update()     -   O(log n)
 * sumRange()   -   O(log n)
 * Extra space  -   O(n)
 */
class NumArrayMutableApproachIII {
    private int[] nums;
    private int[] bit;
    private int n;

    public NumArrayMutableApproachIII(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.bit = new int[n + 1];

        // Build the Fenwick Tree
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];

        nums[index] = val;
        add(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    // Add delta to the Fenwick Tree at a 1-based index
    private void add(int index, int delta) {
        while (index <= n) {
            bit[index] += delta;
            index += index & -index;
        }
    }

    // Sum of the first index elements
    private int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}
