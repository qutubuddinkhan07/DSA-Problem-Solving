public class CountofPrimeNumberstillN {
    /*  https://takeuforward.org/practice/dsa/count-of-prime-numbers-till-n */
    public static void main(String[] args) {
        CountofPrimeNumberstillNSolution obj = new CountofPrimeNumberstillNSolution();
        System.out.println(obj.primeUptoN(6));
    }
}

class CountofPrimeNumberstillNSolution {
    public int primeUptoN(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}