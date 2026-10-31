public class MissingNumber {
    public static void main(String[] args) {
        MissingNumberSolution obj = new MissingNumberSolution();
        System.out.println(obj.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}

class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = ((n + 1) * n) / 2;
        int currSum = 0;
        for (int num : nums)
            currSum += num;
        return total - currSum;
    }
}
