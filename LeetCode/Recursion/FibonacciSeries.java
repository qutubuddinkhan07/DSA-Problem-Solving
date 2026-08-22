public class FibonacciSeries {
    public static void main(String[] args) {
        FibonacciSeries obj = new FibonacciSeries();
        System.out.println(obj.fib(4));
    }

    public int fib(int n) {
        if (n <= 1)
            return n;

        int secondLast = fib(n - 1);
        int last = fib(n - 2);
        return secondLast + last;
    }
}
