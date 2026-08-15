public class Consecutive_1_s {
    public static void main(String[] args) {
        // Consecutive_1s_Solution obj = new Consecutive_1s_Solution();
        Consecutive_1s_ImprovedSolution obj = new Consecutive_1s_ImprovedSolution();
        System.out.println(obj.countStrings(0)); // 2
        System.out.println(obj.countStrings(1)); // 2
        System.out.println(obj.countStrings(2)); // 3
        System.out.println(obj.countStrings(3)); // 5
        System.out.println(obj.countStrings(4)); // 8
    }
}

class Consecutive_1s_Solution {
    int countStrings(int n) {
        if (n == 0)
            return 0;

        int zeroEnd = 1;
        int oneEnd = 1;
        int sum = zeroEnd + oneEnd;
        if (n == 1)
            return sum; // 2

        int i = 2;
        while (i <= n) {
            oneEnd = zeroEnd;
            zeroEnd = sum;
            sum = zeroEnd + oneEnd;
            i++;
        }

        return sum;
    }
}

class Consecutive_1s_ImprovedSolution {
    int countStrings(int n) {
        final int MOD = 1_000_000_007;

        long endsInZero = 1; // strings of current length ending in 0
        long endsInOne = 1;  // strings of current length ending in 1

        for (int i = 2; i <= n; i++) {
            long newZero = (endsInZero + endsInOne) % MOD;
            long newOne = endsInZero;
            endsInZero = newZero;
            endsInOne = newOne;
        }

        return (int) ((endsInZero + endsInOne) % MOD);
    }
}
