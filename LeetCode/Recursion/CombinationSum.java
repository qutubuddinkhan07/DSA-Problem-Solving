import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*-
    Problem Link: https://leetcode.com/problems/combination-sum/
    Time Complexity: O(2^t * k), here 't' is the target and 'k' is the array elements ~ O(n^(target/min(candidates)))
     */
    public static void main(String[] args) {
        CombinationSumSolution obj = new CombinationSumSolution();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(obj.combinationSum(candidates1, target1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(obj.combinationSum(candidates2, target2));

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(obj.combinationSum(candidates3, target3));
    }
}

class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinations(int index, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // pick iff arr[index] <= target
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(index, arr, target - arr[index], ds, ans);

            // while coming out remove the added element from the ds
            ds.remove(ds.size() - 1);
        }

        // not pick
        findCombinations(index + 1, arr, target, ds, ans);
    }
}