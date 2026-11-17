public class FibonacciSeries {
    public static void main(String[] args) {
        // FibonacciSeriesIterativeApproach obj = new FibonacciSeriesIterativeApproach();
        FibonacciSeriesRecursiveApproach obj = new FibonacciSeriesRecursiveApproach();
        System.out.println(obj.fib(4));
    }
}

class FibonacciSeriesIterativeApproach {
    public int fib(int n) {
        int a = 0, b = 1;
        if (n == 0)
            return a;

        if (n == 1)
            return b;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }
}

class FibonacciSeriesRecursiveApproach {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int secondLast = fib(n - 1);
        int last = fib(n - 2);
        return secondLast + last;
    }
}
