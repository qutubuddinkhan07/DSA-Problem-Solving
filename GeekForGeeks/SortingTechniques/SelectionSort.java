import java.util.Arrays;

public class SelectionSort {
    /**
     * Problem Link: <a href="https://www.geeksforgeeks.org/problems/selection-sort/1">Selection sort GFG</a>
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        SelectionSortSolution obj = new SelectionSortSolution();
        int[] arr1 = {4, 1, 3, 9, 7};
        int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr3 = {38, 31, 20, 14, 30};
        obj.selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        obj.selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        obj.selectionSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}

class SelectionSortSolution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i)
                swap(arr, i, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
