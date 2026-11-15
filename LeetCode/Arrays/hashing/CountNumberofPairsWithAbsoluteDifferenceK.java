package hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    LC 2006 - Count Number of Pairs With Absolute Difference K
 * Link:       https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
 * Pattern:    using hashing
 * Key idea:   Similar to Two Sum problem
 * Solved:     with hint / after editorial
 * Date:       15/11/26 Sun 2026
 */
public class CountNumberofPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        CountNumberofPairsWithAbsoluteDifferenceKApproachI obj = new CountNumberofPairsWithAbsoluteDifferenceKApproachI();
        // CountNumberofPairsWithAbsoluteDifferenceKApproachII obj =new CountNumberofPairsWithAbsoluteDifferenceKApproachII();
        // CountNumberofPairsWithAbsoluteDifferenceKApproachIII obj =new CountNumberofPairsWithAbsoluteDifferenceKApproachIII();
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {1, 3};
        int[] arr3 = {3, 2, 1, 5, 4};
        System.out.println(obj.countKDifference(arr1, 1));
        System.out.println(obj.countKDifference(arr2, 3));
        System.out.println(obj.countKDifference(arr3, 2));
    }
}

class CountNumberofPairsWithAbsoluteDifferenceKApproachI {
    /*
     * Time:    O(n^2)
     * Space:   O(1)
     */
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff == k)
                    count++;
            }
        }

        return count;
    }
}

class CountNumberofPairsWithAbsoluteDifferenceKApproachII {
    /*
     * Time:    O(n)
     * Space:   O(n)
     */
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            count += mpp.getOrDefault(num - k, 0);
            count += mpp.getOrDefault(num + k, 0);

            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}

class CountNumberofPairsWithAbsoluteDifferenceKApproachIII {
    /*
     * Time:    O(n)
     * Space:   O(1)
     */
    public int countKDifference(int[] nums, int k) {
        int[] freq = new int[101];
        int count = 0;

        for (int num : nums) {
            if (num - k >= 1)
                count += freq[num - k];

            if (num + k <= 100)
                count += freq[num + k];

            freq[num]++;
        }

        return count;
    }
}
