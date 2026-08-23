import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        PowerSetSolution obj = new PowerSetSolution();
        System.out.println(obj.powerSet(new int[]{3, 1, 2}));
    }
}

class PowerSetSolution {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateAllSubsequences(0, nums, current, ans);
        return ans;
    }

    private void generateAllSubsequences(int index, int[] nums, List<Integer> current, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        // take element
        current.add(nums[index]);
        generateAllSubsequences(index + 1, nums, current, res);

        // not take element
        current.remove(current.size() - 1);
        generateAllSubsequences(index + 1, nums, current, res);
    }
}
