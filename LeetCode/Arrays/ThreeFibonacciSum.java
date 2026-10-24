public class ThreeFibonacciSum {
    /* 4078. Three Fibonacci Sum - https://leetcode.com/problems/three-fibonacci-sum/ */
    public static void main(String[] args) {
        ThreeFibonacciSumSolution obj = new ThreeFibonacciSumSolution();
        System.out.println(obj.threeFibonacciSum(16));
        System.out.println(obj.threeFibonacciSum(8));
        System.out.println(obj.threeFibonacciSum(2));
    }
}

class ThreeFibonacciSumSolution {
    /**
     *
     * Let three consecutive Fibonacci numbers be F(k), F(k+1), and F(k+2)
     * By definition, the next term is the sum of the previous two:
     * F(k+2) = F(k) + F(k+1)
     * <p>
     * S = F(k) + F(k+1) + F(k+2)
     * S = 2 \times F(k+2)
     * <p>
     * n must be an even number (because n = 2 \times F(k+2)).
     * n / 2 must be a Fibonacci number!
     */
    public boolean threeFibonacciSum(int n) {
        if (n % 2 != 0)
            return false;

        int a = 0, b = 1;
        int target = n / 2;
        while (a < target) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return a == target;
    }
}
