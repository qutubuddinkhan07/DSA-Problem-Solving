import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        // this does not work properly so don't use it, it's just reference with the CombinationSumI
        // CombinationSumIIBruteSolution obj = new CombinationSumIIBruteSolution();

        CombinationSumIIWorkingSolution obj = new CombinationSumIIWorkingSolution();
        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(obj.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(obj.combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 10));
    }
}

class CombinationSumIIWorkingSolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // mergeSort(candidates, 0, candidates.length - 1); // practice
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinations(int index, int[] arr, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    // --- MERGE SORT PRACTICE ---
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid)
            temp.add(arr[left++]);
        while (right <= high)
            temp.add(arr[right++]);

        for (int i = low; i < high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}

// --- THIS SOLUTION DOESN'T WORK FOR EVERY TEST CASES -----------
class CombinationSumIIBruteSolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        findCombination(0, candidates, target, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    private void findCombination(int index, int[] arr, int target, List<Integer> current, Set<List<Integer>> ans) {
        if (index == arr.length) {
            if (target == 0) {
                List<Integer> temp = new ArrayList<>(current);
                Collections.sort(temp);
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (arr[index] <= target) {
            current.add(arr[index]);
            findCombination(index + 1, arr, target - arr[index], current, ans);
            current.remove(current.size() - 1);
        }
        findCombination(index + 1, arr, target, current, ans);
    }
}