public class CheckifArrayIsSortedandRotated {
    /*
     * Problem:    LC 1752 - Check if Array Is Sorted and Rotated
     * Link:       https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
     * Pattern:    trick is check the front element
     * Key idea:   One sentence: the trick that makes it work.
     * Time:       O(n)
     * Space:      O(1)
     * Solved:     alone
     * Date:       17/11/26 Tue 2026
     */
    public static void main(String[] args) {
        CheckifArrayIsSortedandRotatedSolution obj = new CheckifArrayIsSortedandRotatedSolution();
        System.out.println(obj.check(new int[]{3, 4, 5, 1, 2}));    // true
        System.out.println(obj.check(new int[]{2, 1, 3, 4}));   // false
        System.out.println(obj.check(new int[]{1, 2, 3}));  // true
    }
}

class CheckifArrayIsSortedandRotatedSolution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                count++;
        }

        return count <= 1;
    }
}
