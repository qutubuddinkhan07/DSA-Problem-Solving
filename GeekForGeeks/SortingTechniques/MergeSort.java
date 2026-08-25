import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        /*-
        Time complexity: O(n log n) — always, in every case (best, average, worst).

        Why:
        - The array is split in half each time → log n levels of recursion
        (like a balanced binary tree of depth log n).
        - At each level, merging all the sub-arrays back together takes O(n) total work
        (every element gets looked at once during the merge).
        - Total = (work per level) × (number of levels) = O(n) × O(log n) = O(n log n).

        This is true regardless of input order — unlike quicksort, merge sort doesn't have
        a bad O(n²) worst case, because it doesn't depend on picking good pivots. That predictability
        is merge sort's main selling point.

        Space complexity: O(n)

        Why:
        - Your merge method creates a new ArrayList<Integer> temp every single call, and
        across one full level of merging, these temp lists collectively hold all n elements.
        - This auxiliary space is the dominant cost — merge sort is not in-place
        (unlike quicksort or heapsort).
        - There's also O(log n) space from the recursion call stack, but that's dwarfed by
        the O(n) auxiliary array space, so we just say O(n) overall.

        One note on your specific code: using ArrayList<Integer> instead of a plain
        int[] for temp adds autoboxing overhead (each int gets wrapped as an
        Integer object) — same big-O complexity, but slower in practice than an
        array-based merge. If you ever want to optimize constant factors, that's the place to look.
         */
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
