public class SingleNumber {
    public static void main(String[] args) {
        // SingleNumberBitSolution obj = new SingleNumberBitSolution();
        SingleNumberIterativeSolution obj = new SingleNumberIterativeSolution();
        System.out.println(obj.singleNumber(new int[]{2, 2, 1}));
        System.out.println(obj.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(obj.singleNumber(new int[]{1}));
    }
}

class SingleNumberBitSolution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
            ans ^= nums[i];

        return ans;
    }
}

class SingleNumberIterativeSolution {
    public int singleNumber(int[] nums) {
        int[] freq = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] + 3000]++;
        }

        int ans = 0;
        for (int num : nums) {
            if (freq[num + 3000] == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}