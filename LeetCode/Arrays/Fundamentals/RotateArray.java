package Fundamentals;

import java.util.Arrays;

public class RotateArray {
    /* 189. Rotate Array - https://leetcode.com/problems/rotate-array/description/*/

    public static void main(String[] args) {
        // RotateArrayApproachI obj = new RotateArrayApproachI();
        RotateArrayApproachII obj = new RotateArrayApproachII();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        obj.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

class RotateArrayApproachI {
    /*
    Time Complexity: O(n + k + (n-k)) => O(2n) => O(n)
    Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1); // O(n)
        reverse(nums, 0, k - 1); // O(k)
        reverse(nums, k, n - 1); // O(n-k)
    }

    private void reverse(int[] arr, int left, int right) {
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

class RotateArrayApproachII {
    /*
    Time Complexity: O(n + k + (n-k)) => O(2n) => O(n)
    Space Complexity: O(k)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}