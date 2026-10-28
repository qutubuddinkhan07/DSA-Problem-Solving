public class MaximumSubarray {
    // LeetCode Link: https://leetcode.com/problems/maximum-subarray/description/
    public static void main(String[] args) {
        // BruteMaximumSubarraySolution obj = new BruteMaximumSubarraySolution();
        // BetterMaximumSubarraySolution obj = new BetterMaximumSubarraySolution();
        OptimalMaximumSubarraySolution obj = new OptimalMaximumSubarraySolution();
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(obj.maxSubArray(new int[]{1}));
        System.out.println(obj.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}

class BruteMaximumSubarraySolution {
    /**
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += nums[k];

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

class BetterMaximumSubarraySolution {
    /**
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}

class OptimalMaximumSubarraySolution { // Kadane's Algorithm
    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;
            if (sum < 0)
                sum = 0;
        }

        return (int) maxSum;
    }
}
