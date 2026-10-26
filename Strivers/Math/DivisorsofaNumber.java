import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorsofaNumber {
    public static void main(String[] args) {
        // DivisorsofaNumberBrute obj = new DivisorsofaNumberBrute();
        DivisorsofaNumberOptimal obj = new DivisorsofaNumberOptimal();
        System.out.println(Arrays.toString(obj.divisors(7)));
        System.out.println(Arrays.toString(obj.divisors(36)));
    }
}

class DivisorsofaNumberBrute {
    public int[] divisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        int[] ans = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                ans[idx++] = i;
        }

        return ans;
    }
}

class DivisorsofaNumberOptimal {
    /*-
    Time Complexity: O(log(min(a,b)))
     */
    public int[] divisors(int n) {
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (i != n / i) {
                    arr.add(n / i);
                }
            }
        }

        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            ans[i] = arr.get(i);

        return ans;
    }
}