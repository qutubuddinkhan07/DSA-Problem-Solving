package basicHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    TUF 742 - Second Highest Occurring Element
 * Link:       https://takeuforward.org/practice/dsa/second-highest-occurring-element
 * Pattern:    Hashing
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     after editorial
 * Date:       04/11/26 Wed 2026
 */
public class SecondHighestOccurringElement {
    public static void main(String[] args) {
        // SecondHighestOccurringElementApproachI obj = new SecondHighestOccurringElementApproachI();
        // SecondHighestOccurringElementApproachII obj = new SecondHighestOccurringElementApproachII();
        SecondHighestOccurringElementApproachIII obj = new SecondHighestOccurringElementApproachIII();
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 4};
        int[] arr2 = {5, 5, 6, 6};
        int[] arr3 = {1, 2, 2, 3, 3, 3};
        int[] arr4 = {4, 4, 5, 5, 6, 7};
        System.out.println(obj.secondMostFrequentElement(arr));
        System.out.println(obj.secondMostFrequentElement(arr2));
        System.out.println(obj.secondMostFrequentElement(arr3)); // 2
        System.out.println(obj.secondMostFrequentElement(arr4)); // 6
    }
}

class SecondHighestOccurringElementApproachI {
    /*
     * Time: O(N²), where N is the number of elements in the array. For every element, the entire array is traversed.
     * Space: O(1), as only a fixed number of counters and result values are stored.
     */
    public int secondMostFrequentElement(int[] arr) {
        boolean hasHighest = false;
        boolean hasSecond = false;
        int highestFrequency = 0;
        int secondFrequency = 0;
        int highestElement = 0;
        int secondElement = 0;

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean alreadyCounted = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (alreadyCounted) {
                continue;
            }

            int currentEle = arr[i];
            int currentFreq = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == currentEle) {
                    currentFreq++;
                }
            }

            if (!hasHighest) {
                highestElement = currentEle;
                highestFrequency = currentFreq;
                hasHighest = true;
            } else if (currentFreq > highestFrequency) {
                secondFrequency = highestFrequency;
                secondElement = highestElement;
                hasSecond = true;

                highestElement = currentEle;
                highestFrequency = currentFreq;
            } else if (currentFreq == highestFrequency) {
                if (currentEle < highestElement) {
                    highestElement = currentEle;
                }
            } else {
                if (!hasSecond || (currentFreq > secondFrequency) ||
                        (currentFreq == secondFrequency && currentEle < secondElement)) {
                    secondFrequency = currentFreq;
                    secondElement = currentEle;
                    hasSecond = true;
                }
            }
        }

        if (!hasSecond) {
            return -1;
        }

        return secondElement;
    }
}

class SecondHighestOccurringElementApproachII {
    /*
     * Time: O(N log(N)), where N is the number of elements in the array. Sorting takes O(N log(N)) time, while the subsequent scan takes O(N) time.
     * Space: O(1), as only a fixed number of extra variables are stored.
     */
    public int secondMostFrequentElement(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return -1;
        }

        boolean hasHighest = false;
        boolean hasSecond = false;
        int highestFrequency = 0;
        int secondFrequency = 0;
        int highestElement = 0;
        int secondElement = 0;

        Arrays.sort(arr);

        int start = 0;
        while (start < n) {
            int end = start;

            while (end < n && arr[end] == arr[start]) {
                end++;
            }

            int currentFrequency = end - start;
            int currentEle = arr[start];

            if (!hasHighest) {
                highestElement = currentEle;
                highestFrequency = currentFrequency;
                hasHighest = true;
            } else if (currentFrequency > highestFrequency) {
                secondElement = highestElement;
                secondFrequency = highestFrequency;
                hasSecond = true;

                highestFrequency = currentFrequency;
                highestElement = currentEle;
            } else if (currentFrequency == highestFrequency) {
                if (currentEle < highestElement) {
                    highestElement = currentEle;
                }
            } else {
                if (!hasSecond ||
                        currentFrequency > secondFrequency ||
                        (currentFrequency == secondFrequency && currentEle < secondElement)) {
                    secondElement = currentEle;
                    secondFrequency = currentFrequency;
                    hasSecond = true;
                }
            }

            start = end;
        }

        if (!hasSecond) {
            return -1;
        }

        return secondElement;
    }
}

class SecondHighestOccurringElementApproachIII {
    /*
     * Time: O(N) on average, where N is the number of elements in the array. The array is scanned once to build the hash map, and each distinct value is checked once afterward
     * Space: O(K), where K is the number of distinct elements in the array stored in the hash map.
     */
    public int secondMostFrequentElement(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }

        Map<Integer, Integer> mpp = new HashMap<>();
        for (int x : arr) {
            mpp.put(x, mpp.getOrDefault(x, 0) + 1);
        }

        boolean hasHighest = false;
        boolean hasSecond = false;
        int highestFrequency = 0;
        int highestEle = 0;
        int secondFrequency = 0;
        int secondEle = 0;

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int currentEle = entry.getKey();
            int currentFreq = entry.getValue();

            if (!hasHighest) {
                highestEle = currentEle;
                highestFrequency = currentFreq;
                hasHighest = true;
            } else if (currentFreq > highestFrequency) {
                secondEle = highestEle;
                secondFrequency = highestFrequency;
                hasSecond = true;

                highestEle = currentEle;
                highestFrequency = currentFreq;
            } else if (currentFreq == highestFrequency) {
                if (currentEle < highestEle) {
                    highestEle = currentEle;
                }
            } else {
                if (!hasSecond ||
                        currentFreq > secondFrequency ||
                        (currentFreq == secondFrequency && currentEle < secondEle)) {
                    secondFrequency = currentFreq;
                    secondEle = currentEle;
                    hasSecond = true;
                }
            }
        }

        if (!hasSecond) {
            return -1;
        }

        return secondEle;
    }
}
