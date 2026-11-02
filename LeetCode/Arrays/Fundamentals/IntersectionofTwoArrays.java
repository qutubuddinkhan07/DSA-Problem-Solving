package fundamentals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Problem:    LC 349 - Intersection of Two Arrays
 * Link:       https://leetcode.com/problems/intersection-of-two-arrays/description/
 * Pattern:    Comparing and adding common elements
 * Key idea:   like union of two arrays
 * Solved:     after editorial
 * Date:       2/11/26 Mon 2026
 */
public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        // IntersectionofTwoArraysApproachI obj = new IntersectionofTwoArraysApproachI();
        IntersectionofTwoArraysApproachII obj = new IntersectionofTwoArraysApproachII();
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {1, 2, 7};
        int[] arr3 = {1, 2, 2, 3, 3, 3};
        int[] arr4 = {2, 3, 3, 4, 5, 7};
        System.out.println(Arrays.toString(obj.intersection(arr1, arr2)));
        System.out.println(Arrays.toString(obj.intersection(arr3, arr4)));
    }
}

class IntersectionofTwoArraysApproachI {
    /*
     * Time:       O(n log n + m log m), building the prefix array
     * Space:      O(min(n, m))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // O(n log n)
        Arrays.sort(nums2); // O(m log m)

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int idx1 = 0;
        int idx2 = 0;
        int k = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) { // O(n + m)
            if (nums1[idx1] == nums2[idx2]) {
                if (k == 0 || result[k - 1] != nums1[idx1]) {
                    result[k] = nums1[idx1];
                    k++;
                }
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return Arrays.copyOf(result, k);
    }
}

class IntersectionofTwoArraysApproachII {
    /*
     * Time:       O(n + m)
     * Space:      O(min(n, m))
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();

        for (int num : nums1) {
            st.add(num);
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        for (int x : nums2) {
            if (st.contains(x)) {
                result[i++] = x;
                st.remove(x); // removing so that it won't get added again
            }
        }

        return Arrays.copyOf(result, i);
    }
}