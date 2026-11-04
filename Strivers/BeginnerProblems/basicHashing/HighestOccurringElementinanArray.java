package basicHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    TUF 296 - Highest Occurring Element in an Array
 * Link:       https://takeuforward.org/practice/dsa/highest-occurring-element-in-an-array
 * Pattern:    Hashing
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     after editorial
 * Date:       04/11/26 Wed 2026
 */
public class HighestOccurringElementinanArray {
    public static void main(String[] args) {
        // HighestOccurringElementinanArrayApproachI obj = new HighestOccurringElementinanArrayApproachI();
        // HighestOccurringElementinanArrayApproachII obj = new HighestOccurringElementinanArrayApproachII();
        HighestOccurringElementinanArrayApproachIII obj = new HighestOccurringElementinanArrayApproachIII();
        int[] arr = {4, 1, 4, 2, 1};
        int[] arr2 = {4, 4, 5, 5, 6};
        int[] arr3 = {1, 2, 2, 3, 3, 3};

        System.out.println(obj.mostFrequentElement(arr));
        System.out.println(obj.mostFrequentElement(arr2));
        System.out.println(obj.mostFrequentElement(arr3));
    }
}

class HighestOccurringElementinanArrayApproachI {
    /*
     * Time: O(N^2), where N is the size of the array. For each element, the entire array is traversed once, resulting in N × N operations.
     * Space: O(1), because only the current count and best answer are stored apart from the input.
     */
    public int mostFrequentElement(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }

        int maxFrequency = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currentFreq = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    currentFreq++;
            }

            if (currentFreq > maxFrequency || ((currentFreq == maxFrequency) && arr[i] < ans)) {
                maxFrequency = currentFreq;
                ans = arr[i];
            }
        }
        return ans;
    }
}

class HighestOccurringElementinanArrayApproachII {
    /*
     * Time: O(N log(N)), where N is the size of the array. The sorting operation takes O(N log(N)) time and dominates the overall complexity.
     * Space: O(1), because any extra space is not used.
     */
    public int mostFrequentElement(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return -1;

        int maxFrequency = 0;
        int ans = arr[0];
        int start = 0;

        // Sort the array so that duplicate values become adjacent.
        Arrays.sort(arr);

        // Process one group of equal elements at a time.
        while (start < n) {
            int end = start;

            // Extend the current group while the values remain the same.
            while (end < n && arr[start] == arr[end]) {
                end++;
            }

            // Calculate the size of the current group.
            int currentFrequency = end - start;
            int currentValue = arr[start];

            /*
                Update the answer if the current
                element has a higher frequency
                or wins the tie-break.
            */
            if (currentFrequency > maxFrequency || ((currentFrequency == maxFrequency) && currentValue < ans)) {
                maxFrequency = currentFrequency;
                ans = currentValue;
            }

            // Move to the beginning of the next group.
            start = end;
        }

        return ans;
    }
}

class HighestOccurringElementinanArrayApproachIII {
    /*
     * Time: O(N) on average, where N is the number of elements in the array, because every element is processed once and each hash-map update takes average O(1) time. In the worst-case scenario, frequent collisions can significantly slow down operations.
     * Space: O(K), where K is the number of distinct values stored in the frequency map. At the worst-case the hash-map can contain all the N elements, so worst case space complexity is O(N).
     */
    public int mostFrequentElement(int[] arr) {
        // If the array is empty, there is no answer
        if (arr.length == 0) {
            return -1;
        }

        Map<Integer, Integer> mpp = new HashMap<>();
        int ans = -1;
        int maxFrequency = 0;

        // Count the frequency of every element.
        for (int num : arr) {
            // Increase the frequency of the current element.
            int currentFreq = mpp.getOrDefault(num, 0) + 1;
            mpp.put(num, currentFreq);

             /*
                Update the answer if the current
                element has a higher frequency
                or wins the tie-break.
            */
            if (currentFreq > maxFrequency || ((currentFreq == maxFrequency) && num < ans)) {
                ans = num;
                maxFrequency = currentFreq;
            }
        }

        return ans;
    }
}