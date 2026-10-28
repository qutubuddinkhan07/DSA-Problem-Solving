public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = i;
            while (pos > 0 && nums[pos - 1] > nums[pos]) {
                int temp = nums[pos];
                nums[pos] = nums[pos - 1];
                nums[pos - 1] = temp;
                pos--;
            }
        }
        return nums;
    }
}
