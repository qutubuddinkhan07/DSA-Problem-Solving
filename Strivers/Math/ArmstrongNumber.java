public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumberSolution obj = new ArmstrongNumberSolution();
        System.out.println(obj.isArmstrong(153));
    }
}

class ArmstrongNumberSolution {
    public boolean isArmstrong(int n) {
        int count = 0;
        int temp = n;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;
        while (temp != 0) {
            int rem = temp % 10;
            int mul = 1;
            for (int i = 0; i < count; i++) {
                mul *= rem;
            }
            sum += mul;
            temp /= 10;
        }

        return sum == n;
    }
}