public class CheckifAllAsAppearsBeforeAllBs {
    /*
     * Problem:    LC 2124 - Check if All A's Appears Before All B's
     * Link:       https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description/
     * Pattern:    checking the front element
     * Key idea:   One sentence: the trick that makes it work.
     * Time:       O(n)
     * Space:      O(1)
     * Solved:     alone
     * Date:       17/11/26 Tue 2026
     */
    public static void main(String[] args) {
        // CheckifAllAsAppearsBeforeAllBsApproachI obj = new CheckifAllAsAppearsBeforeAllBsApproachI();
        CheckifAllAsAppearsBeforeAllBsApproachII obj = new CheckifAllAsAppearsBeforeAllBsApproachII();
        System.out.println(obj.checkString("aaabbb"));  // true
        System.out.println(obj.checkString("abab"));    // false
        System.out.println(obj.checkString("bbb"));    // true
    }
}

class CheckifAllAsAppearsBeforeAllBsApproachI {
    public boolean checkString(String s) {
        int n = s.length();
        int k = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != 'a') {
                k = i;
                break;
            }
        }

        if (k == -1)
            return true;

        for (int i = k; i < n; i++) {
            if (s.charAt(i) == 'a')
                return false;
        }

        return true;
    }
}

class CheckifAllAsAppearsBeforeAllBsApproachII {
    public boolean checkString(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            char sf = s.charAt(i);
            char ss = s.charAt(i + 1);
            if (sf != ss) {
                if (sf == 'b' && ss == 'a')
                    return false;
            }
        }

        return true;
    }
}
