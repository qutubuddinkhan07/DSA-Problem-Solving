package FAQs_medium;

public class ArmstrongNumber {
    /*
    Problem:    Armstrong Numbers
    Link:       "https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1"
    Time:       O(d * log(d)), where d is the number of digits in n, since we compute the power for each n
    Space:      O(1)
     */
    public static void main(String[] args) {
        ArmstrongNumberSolution obj = new ArmstrongNumberSolution();
        System.out.println(obj.armstrongNumber(153));
        System.out.println(obj.armstrongNumber(372));
        System.out.println(obj.armstrongNumber(100));
    }
}

class ArmstrongNumberSolution {
    boolean armstrongNumber(int n) {
        int digits = findDigits(n);
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int rem = temp % 10;
            sum += power(rem, digits);
            temp /= 10;
        }

        return sum == n;
    }

    int findDigits(int n) {
        int digits = 0;
        while (n != 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }

    int power(int x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y % 2 == 0) {
            return power(x, y / 2) * power(x, y / 2);
        }

        return x * power(x, y / 2) * power(x, y / 2);
    }
}