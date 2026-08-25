import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        MergeSortSolution obj = new MergeSortSolution();
        int[] arr1 = {3, 452, 6, 17, 3};
        int[] arr2 = {4, 1, 3, 9, 7};
        int[] arr3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        obj.mergeSort(arr1, 0, arr1.length - 1);
        obj.mergeSort(arr2, 0, arr2.length - 1);
        obj.mergeSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}

class MergeSortSolution {
    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

    private void merge(int[] arr, int low, int high, int mid) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }
}
