package fundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoSortedArrays {
    /*
     * Problem:    TUF 706 - Intersection of two sorted arrays
     * Link:       https://takeuforward.org/practice/dsa/intersection-of-two-sorted-arrays
     * Pattern:    Just comparing
     * Key idea:   Taking the intersected elements from two sorted arrays
     * Solved:     after editorial
     * Date:       2/11/26 Mon 2026
     */
    public static void main(String[] args) {
        // IntersectionofTwoSortedArraysApproachI obj = new IntersectionofTwoSortedArraysApproachI();
        IntersectionofTwoSortedArraysApproachII obj = new IntersectionofTwoSortedArraysApproachII();
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {1, 2, 7};
        int[] arr3 = {1, 2, 2, 3, 3, 3};
        int[] arr4 = {2, 3, 3, 4, 5, 7};
        System.out.println(Arrays.toString(obj.intersectionArray(arr1, arr2)));
        System.out.println(Arrays.toString(obj.intersectionArray(arr3, arr4)));
    }
}

class IntersectionofTwoSortedArraysApproachI {
    /*
     * Time:       O(n1 + n2)
     * Space:      O(n)
     */
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                temp.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}

class IntersectionofTwoSortedArraysApproachII {
    /*
     * Time:       O(n1 + n2)
     * Space:      O(min(n1, n2))
     */
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int k = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                result[k] = nums1[idx1];
                idx1++;
                idx2++;
                k++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2--;
            }
        }

        return Arrays.copyOf(result, k);
    }
}
