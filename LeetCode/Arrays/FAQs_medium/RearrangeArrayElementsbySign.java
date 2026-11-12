package FAQs_medium;

import java.util.Arrays;

/*
 * Problem:    LC 2149 - Rearrange Array Elements by Sign
 * Link:       https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 * Pattern:    e.g. Sliding window
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     alone / with hint / after editorial
 * Date:       12/11/26 Tue 2026
 */
public class RearrangeArrayElementsbySign {
    public static void main(String[] args) {
        RearrangeArrayElementsbySignApproachI obj = new RearrangeArrayElementsbySignApproachI();
        //RearrangeArrayElementsbySignApproachII obj = new RearrangeArrayElementsbySignApproachII();
        int[] arr1 = {3, 1, -2, -5, 2, -4};
        int[] arr2 = {-1, 1};
        System.out.println(Arrays.toString(obj.rearrangeArray(arr1)));
        System.out.println(Arrays.toString(obj.rearrangeArray(arr2)));
    }
}

class RearrangeArrayElementsbySignApproachI {
    /*
     * Time:       O(n)
     * Space:      O(n)
     */
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        int pos = 0;
        int neg = 1;
        for (int num : nums) { // O(n)
            if (num > 0) {
                temp[pos] = num;
                pos += 2;
            } else {
                temp[neg] = num;
                neg += 2;
            }
        }

        return temp;
    }
}

class RearrangeArrayElementsbySignApproachII {
    /*
     * Time:       O(n+n)
     * Space:      O(n/2 + n/2) = O(n)
     */
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos[] = new int[n / 2];
        int neg[] = new int[n / 2];

        int p = 0, q = 0;
        for (int num : nums) {
            if (num > 0) {
                pos[p++] = num;
            } else {
                neg[q++] = num;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        return nums;
    }
}
