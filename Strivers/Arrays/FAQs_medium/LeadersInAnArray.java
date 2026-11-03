package FAQs_medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Problem:    TUF 512 - Leaders in an Array
 * Link:       https://takeuforward.org/practice/dsa/leaders-in-an-array
 * Pattern:    Prefix Sum
 * Key idea:   Taking the prefix sum also the prefix array length should be of 1 + matrix length & 1 + matrix[0] length
 * Solved:     after editorial
 * Date:       31/10/26 Sat 2026
 */
public class LeadersInAnArray {
    public static void main(String[] args) {
        // LeadersInAnArrayApproachIII obj = new LeadersInAnArrayApproachIII();
        // LeadersInAnArrayApproachI obj = new LeadersInAnArrayApproachI();
        LeadersInAnArrayApproachII obj = new LeadersInAnArrayApproachII();
        System.out.println(obj.leaders(new int[]{1, 2, 5, 3, 1, 2}));
        System.out.println(obj.leaders(new int[]{-3, 4, 5, 1, -4, -5}));
        System.out.println(obj.leaders(new int[]{61, 61, 17}));
    }
}

class LeadersInAnArrayApproachI {
    /*
     * Time:       O(N^2), where N represents the array size. Every candidate may require comparison with every remaining elements on its right.
     * Space:      O(1) auxiliary space, because only loop variables and a Boolean flag are required. The returned list is excluded from auxiliary-space analysis.
     */
    public List<Integer> leaders(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;

            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    isLeader = false;
                }
            }

            if (isLeader) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}

class LeadersInAnArrayApproachII {
    /*
     * Time:       O(N), where N represents the array size. One traversal builds the suffix maximum array, and another traversal collects the leaders.
     * Space:      O(N), because suffixMax stores one value for every array position. The returned list is excluded from auxiliary-space analysis.
     */
    public List<Integer> leaders(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return new ArrayList<>();
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= suffixMax[i]) {
                res.add(nums[i]);
            }
        }

        return res;
    }
}

class LeadersInAnArrayApproachIII {
    /*
     * Time:       O(N), where N represents the array size. One right-to-left traversal identifies the leaders, and reversing the collected list requires at most O(N) time.
     * Space:      O(1), the returned list is excluded from auxiliary-space analysis.
     */
    public List<Integer> leaders(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        ans.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {  // O(n)
            if (nums[i] >= ans.get(ans.size() - 1)) {
                ans.add(nums[i]);
            }
        }

        Collections.reverse(ans);   // O(n)
        return ans;
    }
}
