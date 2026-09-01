import java.util.ArrayList;
import java.util.List;

public class Permutation {
    /*-
    Problem Link: https://leetcode.com/problems/permutations/description/
     */
    public static void main(String[] args) {
        PermutationSolution obj = new PermutationSolution();
        System.out.println(obj.permute(new int[]{1, 2, 3}));
    }
}

class PermutationSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recursivePermutations(nums, freq, new ArrayList<>(), ans);
        return ans;
    }

    private void recursivePermutations(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recursivePermutations(nums, freq, ds, ans);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
    /*-
    Time Complexity: O(n! * n), n! - permutations and n - number of choices
    Space Complexity: O(n) - storing the answer, O(n) auxiliary space for recursion stack
     */
}
