import java.util.Arrays;

/* 2460. Apply Operations to an Array - https://leetcode.com/problems/apply-operations-to-an-array/description/*/
public class ApplyOperationstoanArray {
    public static void main(String[] args) {
        ApplyOperationstoanArraySolution obj = new ApplyOperationstoanArraySolution();
        System.out.println(Arrays.toString(obj.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
    }
}

class ApplyOperationstoanArraySolution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

        return nums;
    }
}