package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    LC 1636 - Sort Array by Increasing Frequency
 * Link:       https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
 * Pattern:    hashing
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     with hint
 * Date:       09/11/26 Mon 2026
 */
public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {2, 3, 1, 3, 2};
        int[] arr3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        SortArraybyIncreasingFrequencyApproachI obj = new SortArraybyIncreasingFrequencyApproachI();
        System.out.println(Arrays.toString(obj.frequencySort(arr1)));
        System.out.println(Arrays.toString(obj.frequencySort(arr2)));
        System.out.println(Arrays.toString(obj.frequencySort(arr3)));
    }
}

class SortArraybyIncreasingFrequencyApproachI {
    /*
     * Let n be the array length and k the number of distinct elements.
     * - Frequency map: (O(n)) average.
     * - Pair array creation: (O(k)).
     * - Sorting: (O(k log k)).
     * - Reconstructing: (O(n)).
     *
     * Time: (O(n+k log k)) average time
     * Space: O(k)
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        Pair[] freq = new Pair[mpp.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            freq[idx++] = new Pair(entry.getKey(), entry.getValue());
        }

        Arrays.sort(freq, (a, b) -> {
            if (a.freq != b.freq)
                return a.freq - b.freq;
            return Integer.compare(b.num, a.num);
        });

        int idx2 = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i].freq > 0) {
                nums[idx2++] = freq[i].num;
                freq[i].freq--;
            }
        }

        return nums;
    }

    static class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}