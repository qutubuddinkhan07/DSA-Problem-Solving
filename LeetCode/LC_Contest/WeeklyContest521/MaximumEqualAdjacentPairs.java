import java.util.HashMap;
import java.util.Map;

/**
 * 4066. Maximum Equal Adjacent Pairs After at Most One Replacement
 * Problem Link: <a href="https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/description/">...</a>
 */
public class MaximumEqualAdjacentPairs {
    public static void main(String[] args) {
        MaximumEqualAdjacentPairsSolution obj = new MaximumEqualAdjacentPairsSolution();
        System.out.println(obj.maxEqualAdjacentPairs(new int[]{1, 2, 3, 2}));
        System.out.println(obj.maxEqualAdjacentPairs(new int[]{1, 2, 1, 2, 1}));
        System.out.println(obj.maxEqualAdjacentPairs(new int[]{1, 1, 1}));
        System.out.println(obj.maxEqualAdjacentPairs(new int[]{2, 3}));
    }
}

class MaximumEqualAdjacentPairsSolution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int best = 0;
        Map<Long, Integer> mpp = new HashMap<>();

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                cnt++;
            else {
                long x = Math.min(nums[i], nums[i - 1]);
                long y = Math.max(nums[i], nums[i - 1]);
                long key = (x << 32) | y;
                int c = mpp.merge(key, 1, Integer::sum);
                best = Math.max(best, c);
            }
        }
        return cnt + best;
    }
}

/**
 * merge(key, value, function) does this:
 * <p>
 * If key is not in the map: it stores 1 and returns 1.
 * If key is already in the map: it computes Integer.sum(oldCount, 1), stores that, and returns the new count.
 * <p>
 * So it is a compact version of:
 * <p>
 * java
 * int c = mpp.getOrDefault(key, 0) + 1;
 * mpp.put(key, c);
 */