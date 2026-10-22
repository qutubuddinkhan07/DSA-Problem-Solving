import java.util.Arrays;

public class RotateArray {
    /* 189. Rotate Array - https://leetcode.com/problems/rotate-array/description/*/
    public static void main(String[] args) {
        RotateArraySolI obj = new RotateArraySolI();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = new int[]{-1, -100, 3, 99};
        obj.rotate(arr, 3);
        obj.rotate(arr2, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}

class RotateArraySolI {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++)
            temp[i] = nums[n - k + i];

        for (int i = n - 1; i >= k; i--)
            nums[i] = nums[i - k];

        for (int i = 0; i < k; i++)
            nums[i] = temp[i];
    }
}

class RotateArraySolII {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
