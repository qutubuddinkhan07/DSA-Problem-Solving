package hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    LC 2404 - Most Frequent Even Element
 * Link:       https://leetcode.com/problems/most-frequent-even-element/description/
 * Pattern:    Hashing
 * Key idea:   Tracking the frequency of an element based on that deciding which will be answer
 * Solved:     own
 * Date:       03/11/26 Tue 2026
 */
public class MostFrequentEvenElement {
    public static void main(String[] args) {
        // MostFrequentEvenElementApproachI obj = new MostFrequentEvenElementApproachI();
        MostFrequentEvenElementApproachII obj = new MostFrequentEvenElementApproachII();
        System.out.println(obj.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(obj.mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));
        System.out.println(obj.mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }
}

class MostFrequentEvenElementApproachI {
    /*
     * Time:       O(n)
     * Space:      O(n)
     */
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            }
        }

        int count = 0;
        int ele = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() >= count) {
                if (entry.getValue() == count) {
                    ele = Math.min(ele, entry.getKey());
                } else {
                    ele = entry.getKey();
                }
                count = entry.getValue();
            }
        }

        return ele != Integer.MAX_VALUE ? ele : -1;
    }
}

class MostFrequentEvenElementApproachII {
    /*
     * Time:       O(n)
     * Space:      O(100001)
     */
    public int mostFrequentEven(int[] nums) {
        int[] freq = new int[100001];
        int max = -1;
        int n = nums.length;

        for (int num : nums) {
            freq[num]++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && freq[nums[i]] > max) {
                max = freq[nums[i]];
                ans = nums[i];
            } else if (nums[i] % 2 == 0 && freq[nums[i]] == max) {
                ans = Math.min(ans, nums[i]);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
