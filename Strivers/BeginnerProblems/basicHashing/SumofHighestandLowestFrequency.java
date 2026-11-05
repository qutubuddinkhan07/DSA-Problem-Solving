package basicHashing;

public class SumofHighestandLowestFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        int[] arr2 = {4, 4, 5, 5, 6};
        SumofHighestandLowestFrequencySolution obj = new SumofHighestandLowestFrequencySolution();
        System.out.println(obj.sumHighestAndLowestFrequency(arr));
//        System.out.println(obj.sumHighestAndLowestFrequency(arr2));
    }
}

class SumofHighestandLowestFrequencySolution {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int[] freq = new int[100001];
        for (int num : nums) {
            freq[num]++;
        }

        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int x : freq) {
            if (x == 0) continue;
            
            int val = freq[x];
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }

        return min + max;
    }
}