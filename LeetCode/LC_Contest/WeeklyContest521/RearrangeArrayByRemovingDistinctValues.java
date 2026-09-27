import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeArrayByRemovingDistinctValues {
    public static void main(String[] args) {
//        RearrangeArrayByRemovingDistinctValuesBruteSolution obj = new RearrangeArrayByRemovingDistinctValuesBruteSolution();
        RearrangeArrayByRemovingDistinctValuesOptimalSolution obj = new RearrangeArrayByRemovingDistinctValuesOptimalSolution();
        System.out.println(Arrays.toString(obj.rearrangeArray(new int[]{3, 1, 3, 2, 1, 3})));
        System.out.println(Arrays.toString(obj.rearrangeArray(new int[]{7, 7, 4, 4, 4})));
    }
}

class RearrangeArrayByRemovingDistinctValuesBruteSolution {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[nums.length];
        int k = 0;
        for (int i = 1; i <= Collections.max(freq.values()); i++) {
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() >= i) {
                    ans[k++] = entry.getKey();
                }
            }
        }

        return ans;
    }
}

class RearrangeArrayByRemovingDistinctValuesOptimalSolution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }

        int b = 0;
        int n = nums.length;
        while (b < n) {
            for (int i = 1; i <= 100; i++) {
                if (freq[i] > 0) {
                    freq[i]--;
                    nums[b++] = i;
                }
            }
        }
        return nums;
    }
}
