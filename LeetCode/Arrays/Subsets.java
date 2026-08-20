import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // SubsetsRecursiveSolution obj = new SubsetsRecursiveSolution();
        SubsetsIterativeBitMaskSolution obj = new SubsetsIterativeBitMaskSolution();
        System.out.println(obj.subsets(new int[]{1, 2, 3}));
    }
}

class SubsetsIterativeBitMaskSolution {
    /**
     *
     * Time Complexity: O(n * 2^n), for each subsequence, we may check up to n bits to decide inclusion.
     * Space Complexity: O(n * 2^n), space used to store all possible subsequences.
     */
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n;

        // List to store all subsequences
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subseq = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    subseq.add(nums[i]);
            }
            result.add(subseq);
        }
        return result;
    }
}

class SubsetsRecursiveSolution {
    /**
     *
     * Time Complexity: O(n * 2^n), for each subsequence, we construct and print the entire subsequence.
     * Space Complexity: O(n * 2^n), space used to store all possible subsequences.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(nums, 0, current, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude current character and recurse
        helper(nums, index + 1, current, result);

        // Include current character and recurse
        current.add(nums[index]);
        helper(nums, index + 1, current, result);

        // backtrack by removing last character
        current.remove(current.size() - 1);
    }
}
