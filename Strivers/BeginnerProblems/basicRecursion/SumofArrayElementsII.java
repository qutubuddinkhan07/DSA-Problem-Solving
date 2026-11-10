package basicRecursion;

/*
 * Problem:    TUF 897 - Sum of Array Elements II
 * Link:       https://takeuforward.org/practice/dsa/sum-of-array-elements-ii
 * Pattern:    recursion
 * Key idea:   One sentence: the trick that makes it work.
 * Time:       O(n)
 * Space:      O(n), recursion stack space
 * Solved:     alone
 * Date:       10/11/26 Tue 2026
 */
public class SumofArrayElementsII {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {5, 8, 1};
        SumofArrayElementsIIApproachI obj = new SumofArrayElementsIIApproachI();
        System.out.println(obj.arraySum(arr1));
        System.out.println(obj.arraySum(arr2));
    }
}

class SumofArrayElementsIIApproachI {
    public int arraySum(int[] nums) {
        return arraySum(nums, 0);
    }

    private int arraySum(int[] nums, int idx) {
        if (nums.length - 1 == idx) {
            return nums[idx];
        }

        return nums[idx] + arraySum(nums, idx + 1);
    }
}
