import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumEqualsTarget {
    /*-
    Lecture 7 (YOUTUBE: L7. All Kind of Patterns in Recursion | Print All | Print one | Count)

    Contains -
        Case 1: Print parameter wise
        Case 2: How to print only 1 answer
        Case 3: How to calculate the count

    Time Complexity: O(2^n), because for everytime we do 2 recursion calls
    Space Complexity: O(n), and here it depends on whether a datastructure is taken or not
     */
    public static void main(String[] args) {
        SubsequenceSumEqualsTarget1 obj1 = new SubsequenceSumEqualsTarget1();
        System.out.println("Subsequences: " + obj1.findSumEqualsTarget(new int[]{1, 2, 1}, 2));

        SubsequenceSumEqualsTarget2 obj2 = new SubsequenceSumEqualsTarget2();
        System.out.println("Count without using datastructures: " + obj2.findSumEqualsTargetCount(new int[]{1, 2, 1}, 2));

        SubsequenceSumEqualsTarget3 obj3 = new SubsequenceSumEqualsTarget3();
        System.out.println("Count using datastructures: " + obj3.findSumEqualsTargetCount(new int[]{1, 2, 1}, 2));
    }


}

class SubsequenceSumEqualsTarget1 {
    // ------------------------------------- PRINT SEQUENCE ------------------------------------

    public List<List<Integer>> findSumEqualsTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSumTargetSequence(0, nums, 0, target, current, result);
        return result;
    }

    public void findSumTargetSequence(int index, int[] nums, int sum, int target, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            if (sum == target) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // pick the element and add to sum
        current.add(nums[index]);
        int currSum = sum + nums[index];
        findSumTargetSequence(index + 1, nums, currSum, target, current, result);

        // not pick also not add to sum
        current.remove(current.size() - 1);
        currSum -= nums[index];
        findSumTargetSequence(index + 1, nums, currSum, target, current, result);
    }

}

class SubsequenceSumEqualsTarget2 {
    // -------------------------------------PRINT COUNT (WITHOUT DATASTRUCTURES) ---------------------------------
    public int findSumEqualsTargetCount(int[] arr, int target) {
        return findSumEqualsTargetCount(0, arr, 0, target);
    }

    public int findSumEqualsTargetCount(int index, int[] arr, int sum, int target) {
        // if sum grows larger than can never satisfy
        if (sum > target)
            return 0;

        if (index == arr.length) {
            if (sum == target)
                return 1;
            else
                return 0;
        }

        sum += arr[index];
        int left = findSumEqualsTargetCount(index + 1, arr, sum, target);

        sum -= arr[index];
        int right = findSumEqualsTargetCount(index + 1, arr, sum, target);

        return left + right;
    }
}

class SubsequenceSumEqualsTarget3 {
    // ------------------------------------- PRINT COUNT (USING DATASTRUCTURES) -----------------------------------

    public int findSumEqualsTargetCount(int[] nums, int target) {
        int result = 0;
        List<Integer> current = new ArrayList<>();
        return findSumTargetCount(0, nums, 0, target, current, result);
    }

    public int findSumTargetCount(int index, int[] nums, int sum, int target, List<Integer> current, int result) {
        if (index == nums.length) {
            if (sum == target) {
                result++;
            }
            return result;
        }

        // pick the element and add to sum
        current.add(nums[index]);
        result = findSumTargetCount(index + 1, nums, sum + nums[index], target, current, result);

        // not pick also not add to sum
        current.remove(current.size() - 1);
        return findSumTargetCount(index + 1, nums, sum, target, current, result);
    }

}