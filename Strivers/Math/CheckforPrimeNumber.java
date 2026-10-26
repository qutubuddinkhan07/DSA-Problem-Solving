public class CheckforPrimeNumber {
    /*    https://takeuforward.org/practice/dsa/check-for-prime-number     */
    public static void main(String[] args) {
//        CheckforPrimeNumberExtreamBrute obj = new CheckforPrimeNumberExtreamBrute();
        CheckforPrimeNumberOptimal obj = new CheckforPrimeNumberOptimal();
        System.out.println(obj.isPrime(7));
        System.out.println(obj.isPrime(7));
        System.out.println(obj.isPrime(6));
    }
}

class CheckforPrimeNumberExtreamBrute {
    /*-
    Time Complexity: O(n)
     */
    public boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count == 2;
    }
}

class CheckforPrimeNumberOptimal {
    /*-
    Time Complexity: O(sqrt (n))
     */
    public boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) {
                    count++;
                }

            }
        }

        return count == 2;
    }
}
