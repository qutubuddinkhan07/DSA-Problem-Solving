import java.util.Arrays;

public class SortingMain {
    public static void main(String[] args) {
        InsertionSort objIns = new InsertionSort();
        MergeSort objMerge = new MergeSort();
        int[] arr = {14, 9, 15, 12, 6, 8, 13};
        int[] arr2 = {14, 9, 15, 12, 6, 8, 8, 13};
        // System.out.println(Arrays.toString(objIns.insertionSort(arr)));
        // System.out.println(Arrays.toString(objIns.insertionSort(arr2)));
        System.out.println(Arrays.toString(objMerge.mergeSort(arr)));
        System.out.println(Arrays.toString(objMerge.mergeSort(arr2)));
    }
}
