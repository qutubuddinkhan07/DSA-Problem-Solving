public class LCMofTwoNumbers {
    public static void main(String[] args) {
        LCMofTwoNumbersSolution obj = new LCMofTwoNumbersSolution();
        System.out.println(obj.LCM(4, 6));
    }
}

class LCMofTwoNumbersSolution {
    public int LCM(int n1, int n2) {
        int gcd = findGCD(n1, n2);
        return (n1 / gcd) * n2;
    }

    private int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        if (a == 0) {
            return b;
        }

        return a;
    }
}
