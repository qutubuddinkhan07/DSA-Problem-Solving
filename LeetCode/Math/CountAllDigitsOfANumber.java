public class CountAllDigitsOfANumber {
    public static void main(String[] args) {
        CountAllDigitsOfANumberOptimalSolution obj = new CountAllDigitsOfANumberOptimalSolution();
        System.out.println(obj.countDigit(77798));
    }
}

class CountAllDigitsOfANumberIterativeSolution {
    public int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }
}

class CountAllDigitsOfANumberOptimalSolution {
    /*-
    Time Complexity: O(log10 |x|) - each iteration process one digit
    Space Complexity: O(1)
    */
    public int countDigit(int n) {
        int count = (int) Math.log10(n) + 1;
        return count;
    }
}
