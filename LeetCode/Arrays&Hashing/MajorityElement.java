import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        // BruteMajorityElementSolution obj = new BruteMajorityElementSolution();
        // BetterMajorityElementSolution obj = new BetterMajorityElementSolution();
        OptimalMajorityElementSolution obj = new OptimalMajorityElementSolution();
        System.out.println(obj.majorityElement(new int[]{3, 2, 3})); // 3
        System.out.println(obj.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }
}

class BruteMajorityElementSolution {
    /**
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }

            if (count > n / 2)
                return nums[i];
        }
        return -1;
    }
}

class BetterMajorityElementSolution {
    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() > n / 2)
                return entry.getKey();
        }
        return -1;
    }
}

class OptimalMajorityElementSolution {
    /**
     *
     * Time Complexity: O(2n) ~ O(n)
     * Space Complexity: O(1)
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        int n = nums.length;

        // find the candidate or element
        for (int num : nums) {
            if (count == 0) {
                count++;
                ele = num;
            } else if (ele == num) {
                count++;
            } else
                count--;
        }

        // verify the candidate or element
        int count1 = 0;
        for (int num : nums)
            if (num == ele)
                count1++;

        if (count1 > n / 2)
            return ele;

        return -1;
    }
}
