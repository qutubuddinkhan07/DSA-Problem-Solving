package FAQs_medium;

import java.util.ArrayList;

/*
 * Problem:    GFG Array Leaders
 * Link:       https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
 * Pattern:    checking the largest number from the right
 * Key idea:   One sentence: the trick that makes it work.
 * Time:       O(n)
 * Space:      O(n), for storing the ans/auxilary space is O(n)
 * Solved:     alone
 * Date:       17/11/26 Tue 2026
 */
public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr1 = new int[]{16, 17, 4, 3, 5, 2}; // [17, 5, 2]
        int[] arr2 = new int[]{10, 4, 2, 4, 1}; // [10, 4, 4, 1]
        int[] arr3 = new int[]{5, 10, 20, 40};  // [40]

        // ArrayLeadersApproachI obj = new ArrayLeadersApproachI();
        ArrayLeadersApproachII obj = new ArrayLeadersApproachII();
        System.out.println(obj.leaders(arr1));
        System.out.println(obj.leaders(arr2));
        System.out.println(obj.leaders(arr3));
    }
}

class ArrayLeadersApproachI {
    ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i], suffix[i + 1]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= suffix[i])
                ans.add(arr[i]);
        }

        return ans;
    }
}

class ArrayLeadersApproachII {
    ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i], suffix[i + 1]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= suffix[i])
                ans.add(arr[i]);
        }

        return ans;
    }
}
