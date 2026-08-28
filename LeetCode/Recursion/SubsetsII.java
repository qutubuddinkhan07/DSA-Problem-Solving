import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsIISolution obj = new SubsetsIISolution();
        System.out.println(obj.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(obj.subsetsWithDup(new int[]{0}));
    }
}

class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // mergeSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void generateSubsets(int index, int[] arr, List<Integer> ds, List<List<Integer>> ans) {
        // add the current subset
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;

            ds.add(arr[i]); // pick element
            generateSubsets(i + 1, arr, ds, ans);
            ds.remove(ds.size() - 1); // remove the inserted element
        }
    }
    // Time Complexity: O(2^n * m), 2^n - recursion tree, m - putting elements into datastructure
    // Space Complexity: O(2^n * k), k - average length of generated lists everytime

    // ------------ PRACTICE ------------------
    private void mergeSort(int[] arr, int low, int high) {
        // TC: O(n log n), SC: O(n)
        // O(log n) dept of tree but to merge two sorted subarrays safely without
        // overwriting data, it must copy elements into a temporary auxiliary array
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }

        while (left <= mid)
            temp.add(arr[left++]);
        while (right <= high)
            temp.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }
}
