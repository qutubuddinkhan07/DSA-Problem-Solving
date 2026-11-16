package hashing;

import java.util.*;

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

        // SortArraybyIncreasingFrequencyApproachI obj = new SortArraybyIncreasingFrequencyApproachI();
        // SortArraybyIncreasingFrequencyApproachII obj = new SortArraybyIncreasingFrequencyApproachII();
        // SortArraybyIncreasingFrequencyApproachIII obj = new SortArraybyIncreasingFrequencyApproachIII();
        SortArraybyIncreasingFrequencyApproachIV obj = new SortArraybyIncreasingFrequencyApproachIV();
        System.out.println(Arrays.toString(obj.frequencySort(arr1)));
        System.out.println(Arrays.toString(obj.frequencySort(arr2)));
        System.out.println(Arrays.toString(obj.frequencySort(arr3)));
    }
}

class SortArraybyIncreasingFrequencyApproachI {
    /*
     * Approach: Frequency Map + Pair Array + Custom Comparator Sort
     *
     * Let n be the array length and k the number of distinct elements.
     * - Build frequency map: O(n) average.
     * - Create a Pair (value, frequency) for each distinct value: O(k).
     * - Sort the Pair array with a comparator: O(k log k).
     * - Reconstruct the array by writing each value freq times: O(n).
     *
     * Ordering (comparator):
     * - Lower frequency comes first.
     * - For equal frequency, larger value comes first.
     *
     * Time:  O(n + k log k) average
     * Space: O(k) for the map and the Pair array (output is written into nums)
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

    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}

class SortArraybyIncreasingFrequencyApproachII {
    /*
     * Approach: Frequency Map + Min-Heap (PriorityQueue)
     *
     * Let n be the array length and k the number of distinct elements.
     * - Build frequency map: O(n) average.
     * - Insert k Pairs into the heap: O(k log k).
     * - Poll all k Pairs (each poll is O(log k)): O(k log k).
     * - Reconstruct the array by writing each element freq times: O(n).
     *
     * Ordering (Pair.compareTo):
     * - Lower frequency comes first.
     * - For equal frequency, larger value comes first.
     *
     * Time:  O(n + k log k) average
     * Space: O(k) for the map and the heap (output is written into nums)
     */

    class Pair implements Comparable<Pair> {
        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.freq != p.freq)
                return this.freq - p.freq;

            return p.ele - this.ele;
        }
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums)
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int ele : mpp.keySet()) {
            int freq = mpp.get(ele);
            pq.add(new Pair(ele, freq));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            while (p.freq-- > 0) {
                nums[idx++] = p.ele;
            }
        }

        return nums;
    }
}

class SortArraybyIncreasingFrequencyApproachIII {
    /*
     * Approach: Frequency Map + Sort All Elements with a Comparator
     *
     * Let n be the array length and k the number of distinct elements.
     * - Build frequency map: O(n) average.
     * - Copy nums into a List<Integer> (boxing): O(n).
     * - Sort the list; the comparator looks up each value's frequency
     *   in the map in O(1) average: O(n log n).
     * - Copy the sorted list back into nums: O(n).
     *
     * Ordering (comparator):
     * - Lower frequency comes first.
     * - For equal frequency, larger value comes first.
     *
     * Time:  O(n log n)
     * Space: O(n) for the boxed list, plus O(k) for the map
     *
     * Note: Integer objects are compared with .equals(), not !=, because
     * != compares references and fails for values outside the -128..127 cache.
     */

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);

        list.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b)))
                return freq.get(a) - freq.get(b); // lower frequency first
            return b - a; // equal frequency larger value first
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }
}

class SortArraybyIncreasingFrequencyApproachIV {
    /*
     * Approach: Frequency Map + Min-Heap of int[] {value, frequency}
     *
     * Let n be the array length and k the number of distinct elements.
     * - Build frequency map: O(n) average.
     * - Insert k entries into the heap: O(k log k).
     * - Poll all k entries (each poll is O(log k)): O(k log k).
     * - Reconstruct the array by writing each value freq times: O(n).
     *
     * Ordering (comparator on int[] {value, frequency}):
     * - Lower frequency (index 1) comes first.
     * - For equal frequency, larger value (index 0) comes first.
     *
     * Time:  O(n + k log k) average
     * Space: O(k) for the map and the heap (output is written into nums)
     *
     * Note: always use poll() to read the heap in sorted order. A for-each
     * loop over a PriorityQueue follows the internal heap array, not sorted order.
     */

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];   // a[1] is the frequency

            return b[0] - a[0]; // a[0] is the element
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();  // must poll, not for-each
            for (int i = 0; i < cur[1]; i++)
                nums[idx++] = cur[0];
        }

        return nums;
    }
}