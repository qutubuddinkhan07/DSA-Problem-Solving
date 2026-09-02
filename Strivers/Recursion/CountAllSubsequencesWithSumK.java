import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountAllSubsequencesWithSumK {
    /*-
    Problem Link: https://takeuforward.org/plus/dsa/problems/count-all-subsequences-with-sum-k?source=strivers-a2z-dsa-track
     */
    public static void main(String[] args) {
        // CountAllSubsequencesWithSumKI obj = new CountAllSubsequencesWithSumKI();
        // System.out.println(obj.countSubsequenceWithTargetSum(new int[]{4, 9, 2, 5, 1}, 10));

        CheckAllSubsequencesWithSumII obj1 = new CheckAllSubsequencesWithSumII();
        System.out.println(obj1.checkSubsequenceSum(new int[]{4, 9, 2, 5, 1}, 10));
    }
}

class CountAllSubsequencesWithSumKI {
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

class CheckAllSubsequencesWithSumII {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        // Arrays.sort(nums);
        mergeSort(nums, 0, nums.length - 1);
        return checkSubsequence(0, k, nums);
    }

    private boolean checkSubsequence(int index, int sum, int[] arr) {
        if (sum == 0)
            return true;
        if (sum < 0 || index == arr.length)
            return false;
        return checkSubsequence(index + 1, sum - arr[index], arr) || checkSubsequence(index + 1, sum, arr);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low + 1, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

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

        for (int i = low; i < temp.size(); i++) {
            arr[i] = temp.get(i - low);
        }
    }
}