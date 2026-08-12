public class CountGoodNumbers {
    /**
     * Solution for LeetCode 1922 - Count Good Numbers
     * https://leetcode.com/problems/count-good-numbers/
     * <p>
     * Full explanation, dry runs, bug analysis, and complexity notes:
     * https://github.com/qutubuddinkhan07/DSA-Problem-Solving/blob/517dc6ab57690c7ca07118f10e9b5e80e326f969/LeetCode/Reading%20Materials/CountGoodNumbers.md
     */
    public static void main(String[] args) {
        // MathematicalCountSolution obj = new MathematicalCountSolution();
        RecursiveCountNumbers obj = new RecursiveCountNumbers();
        System.out.println(obj.countGoodNumbers(1));
        System.out.println(obj.countGoodNumbers(4));
        System.out.println(obj.countGoodNumbers(50));
    }
}

class MathematicalCountSolution {
    private static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long result = (modPow(5, evenCount) * modPow(4, oddCount)) % MOD;

        return (int) result;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}

class RecursiveCountNumbers {
    final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        return (int) helper(0, n);
    }

    private long helper(long index, long n) {
        if (index == n)
            return 1;

        long remaining = helper(index + 1, n);

        long result;
        if (index % 2 == 0) {
            result = (remaining * 5) % MOD; // 5 even-digit choices: {0,2,4,6,8}
        } else {
            result = (remaining * 4) % MOD; // 4 prime-digit choices: {2,3,5,7}
        }

        return result;
    }
}