import java.util.Arrays;

public class CountAllSubsequencesWithSumK {
    /*-
    Problem Link: https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k?source=strivers-a2z-dsa-track
     */
    public static void main(String[] args) {
        CountAllSubsequencesWithSumK obj = new CountAllSubsequencesWithSumK();
        System.out.println(obj.countSubsequenceWithTargetSum(new int[]{4, 9, 2, 5, 1}, 10));
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        Arrays.sort(nums);
        return findSubsequences(0, k, nums);
    }

    private int findSubsequences(int index, int sum, int[] nums) {
        if (sum == 0)
            return 1;
        if (sum < 0 || index == nums.length)
            return 0;

        return findSubsequences(index + 1, sum - nums[index], nums) + findSubsequences(index + 1, sum, nums);
    }
}
