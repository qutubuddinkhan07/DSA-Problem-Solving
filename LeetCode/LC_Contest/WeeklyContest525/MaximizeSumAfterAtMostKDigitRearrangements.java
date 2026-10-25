package WeeklyContest525;

import java.util.Arrays;

public class MaximizeSumAfterAtMostKDigitRearrangements {
    public static void main(String[] args) {
        MaximizeSumAfterAtMostKDigitRearrangementsSolu obj = new MaximizeSumAfterAtMostKDigitRearrangementsSolu();
        System.out.println(obj.maximizeSum(new int[]{102, 90, 14}, 2));
    }
}

class MaximizeSumAfterAtMostKDigitRearrangementsSolu {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;

        int[] gains = new int[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int number = nums[i];
            sum += number;

            int[] digitsCount = new int[10];
            int temp = number;
            while (temp > 0) {
                int digit = temp % 10;
                digitsCount[digit]++;
                temp /= 10;
            }

            int maxNumber = 0;
            for (int digit = 9; digit >= 0; digit--) {
                while (digitsCount[digit] > 0) {
                    maxNumber = maxNumber * 10 + digit;
                    digitsCount[digit]--;
                }
            }

            gains[i] = maxNumber - number;
        }

        Arrays.sort(gains);
        for (int i = n - 1; i >= n - k; i--) {
            sum += gains[i];
        }

        return sum;
    }
}
