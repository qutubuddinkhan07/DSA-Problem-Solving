package fundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem:    TUF 713 - Union of two sorted arrays
 * Link:       https://takeuforward.org/practice/dsa/union-of-two-sorted-arrays
 * Pattern:    basics
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     with hint
 * Date:       12/11/26 Tue 2026
 */
public class UnionofTwoSsortedArrays {
    public static void main(String[] args) {
        UnionofTwoSsortedArraysApproachIII obj = new UnionofTwoSsortedArraysApproachIII();
        int[] nums1 = {1, 1, 2, 3, 4};
        int[] nums2 = {2, 3, 5, 6};
        System.out.println(Arrays.toString(obj.unionArray(nums1, nums2)));
    }
}

class UnionofTwoSsortedArraysApproachIII {
    /*
     * Time:    O(N + M), because each pointer moves through its corresponding array at most once.
     * Space:   O(1) auxiliary space when the returned union array is excluded.
     */
    public int[] unionArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;

        List<Integer> temp = new ArrayList<>();
        while (i < n && j < m) {
            int currEle;
            if (nums1[i] < nums2[j]) {
                currEle = nums1[i++];
            } else if (nums2[j] < nums1[i]) {
                currEle = nums2[j++];
            } else {
                currEle = nums1[i];
                i++;
                j++;
            }

            if (temp.isEmpty() || temp.get(temp.size() - 1) != currEle) {
                temp.add(currEle);
            }
        }

        while (i < n) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) != nums1[i]) {
                temp.add(nums1[i++]);
            }
        }
        while (j < m) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) != nums2[j]) {
                temp.add(nums2[j++]);
            }
        }

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
