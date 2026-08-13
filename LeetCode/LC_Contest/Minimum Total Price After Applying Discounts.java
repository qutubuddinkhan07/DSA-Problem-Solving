import java.util.Arrays;

class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int idxp = prices.length - 1, idxd = discounts.length - 1;
        double sum = 0;
        while (idxp >= 0 && idxd >= 0) {
            double amount = (double) (prices[idxp--] * (100 - discounts[idxd--])) / 100;
            sum += amount;
        }

        while (idxp >= 0) {
            sum += prices[idxp--];
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices = {10,30,21};
        int[] discount = {50,60};
        System.out.println(sol.minPrice(prices, discount)); // 32.5
    }
}