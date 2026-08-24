import java.util.ArrayList;
import java.util.List;

public class FindAnyOneSubsequenceSumEqualsTarget {
    /*-
    Lecture 7 (YOUTUBE: L7. All Kind of Patterns in Recursion | Print All | Print one | Count)
    Goal is to find any one subsequence whose sum == target.
    For that we can use a global boolean flag to track if any match is found or not.
    ----------------------------
    static boolean flag = false;
    if (!flag) {
        flag = true;
        result.add(new ArrayList<>(current));
    }

    Keep in mind the Functional Methods
     */

    public static void main(String[] args) {
        System.out.println(findSumEqualsTarget(new int[]{1, 2, 1}, 2));
    }

    private static List<List<Integer>> findSumEqualsTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSumTargetSequence(0, nums, 0, target, current, result);
        return result;
    }

    private static boolean findSumTargetSequence(int index, int[] nums, int sum, int target, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(current));
                return true;
            }
            return false;
        }

        // pick element and add to sum
        current.add(nums[index]);
        int currSum = sum + nums[index];

        // to stop recursive calls always check for 'true'
        if (findSumTargetSequence(index + 1, nums, currSum, target, current, result)) {
            return true;
        }

        // not pick element also not add to sum
        current.remove(current.size() - 1);
        currSum -= nums[index];

        // to stop recursive calls always check whether it returns 'true'
        if (findSumTargetSequence(index + 1, nums, currSum, target, current, result) == true) {
            return true;
        }

        // if none cases return true
        return false;
    }
}
