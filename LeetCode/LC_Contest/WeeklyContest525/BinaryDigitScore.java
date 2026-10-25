package WeeklyContest525;

public class BinaryDigitScore {
    public static void main(String[] args) {
        BinaryDigitScoreSolu obj = new BinaryDigitScoreSolu();
        System.out.println(obj.calculateScore(10, 12));
        System.out.println(obj.calculateScore(3, 4));
    }
}

class BinaryDigitScoreSolu {
    public int calculateScore(int a, int b) {
        int countSetA = 0;
        int countSetB = 0;
        boolean checkAbigger = a > b;

        while (a > 0) {
            int rem = a & 1;
            if (rem == 1)
                countSetA++;
            a = a >>> 1;
        }

        while (b > 0) {
            int rem = b & 1;
            if (rem == 1)
                countSetB++;
            b = b >>> 1;
        }

        return countSetA >= countSetB ? countSetA * countSetB : countSetB / countSetA;
    }
}