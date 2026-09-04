import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIIISolution obj = new CombinationSumIIISolution();
        System.out.println(obj.combinationSum3(3, 7));
    }
}

class CombinationSumIIISolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        find(n, 1, k, new ArrayList<>(), ans);
        return ans;
    }

    private void find(int sum, int last, int k, List<Integer> ds, List<List<Integer>> ans) {
        // If the sum is zero and the number of elements is k
        if (sum == 0 && ds.size() == k) {
            // Add the current combination to the answer
            ans.add(new ArrayList<>(ds));
            return;
        }

        // If the sum is less than zero or the number of elements exceeds k
        if (sum <= 0 || ds.size() > k) {
            return;
        }

        for (int i = last; i <= 9; i++) {
            // if the current number is less than or equal to the sum
            if (i <= sum) {
                // Add the number to the current combination
                ds.add(i);

                // Recursive call with updated sum and next number
                find(sum - i, i + 1, k, ds, ans);

                // Remove the last number and backtrack
                ds.remove(ds.size() - 1);
            } else {
                // If the number is greater than sum, break the loop
                break;
            }
        }
    }
    /*_
    Time Complexity: O(2^9 * k), due to exploration of all subsets of the set {1, 2, 3, ..., 9}
    Space Complexity: O(k), where k is the number of elements in the combination. This is due to
        the space used by the recursive call stack and the storage of valid combinations.
     */
}
