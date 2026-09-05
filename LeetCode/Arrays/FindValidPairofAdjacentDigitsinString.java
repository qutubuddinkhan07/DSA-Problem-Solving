import java.util.HashMap;
import java.util.Map;

public class FindValidPairofAdjacentDigitsinString {
    /*-
    Problem Link: https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
     */
    public static void main(String[] args) {
        FindValidPairofAdjacentDigitsinStringSolution obj = new FindValidPairofAdjacentDigitsinStringSolution();
        System.out.println(obj.findValidPair("2523533"));
        System.out.println(obj.findValidPair("221"));
        System.out.println(obj.findValidPair("22"));
    }
}

class FindValidPairofAdjacentDigitsinStringSolution {
    public String findValidPair(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
        if (mpp.size() == 1)
            return "";

        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (first != second && (mpp.get(first) == first - '0' && mpp.get(second) == second - '0')) {
                return "" + first + second;
            }
        }
        return "";
    }
}
