package Fundamentals;

public class MaxConsecutiveOnes {
    /* Problem Link: 485. Max Consecutive Ones [https://leetcode.com/problems/max-consecutive-ones/description/] */
    public static void main(String[] args) {
        MaxConsecutiveOnesSolution obj = new MaxConsecutiveOnesSolution();
        System.out.println(obj.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(obj.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}

class MaxConsecutiveOnesSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else
                count = 0;
        }
        return maxCount;
    }
}
