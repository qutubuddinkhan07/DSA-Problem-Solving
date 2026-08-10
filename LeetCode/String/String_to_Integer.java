class Main extends Solution {
    /*
     * ============================================================
     * Problem: String to Integer (atoi)
     * ============================================================
     * Parse a string into a 32-bit signed integer, replicating the
     * behavior of the C/C++ atoi function:
     *   1. Skip leading whitespace.
     *   2. Read an optional '+' or '-' sign (at most one).
     *   3. Read digits until a non-digit character or end of string.
     *   4. Clamp the result to [Integer.MIN_VALUE, Integer.MAX_VALUE]
     *      if it overflows a 32-bit signed int.
     *   5. Return 0 if no digits were read.
     *
     * Two implementations are given below: one iterative (a while
     * loop walks the characters one at a time), and one recursive
     * (a helper function consumes one digit per call).
     * ============================================================
     */
    public static void main(String[] args) {
        Main m = new Main();
        String s1 = "42";
        String s2 = " -042";
        String s3 = "1337c0d3";
        String s4 = "0-1";
        String s5 = "words and 987";
        System.out.println(m.myAtoi(s1)); // 42
        System.out.println(m.myAtoi(s2)); // -42
        System.out.println(m.myAtoi(s3)); // 1337
        System.out.println(m.myAtoi(s4)); // 0
        System.out.println(m.myAtoi(s5)); // 0
    }
}

// ---------------------------------------------------------------
// Iterative approach
// ---------------------------------------------------------------
// Description:
//   A single while loop scans left to right. Each iteration reads
//   one digit, folds it into the running total, and immediately
//   checks for overflow so it can return early once the value
//   goes out of 32-bit signed range.
//
// Time Complexity:  O(n) — each character is visited at most once
//                    across the whitespace skip, sign check, and
//                    digit loop.
// Space Complexity: O(n) — only for s.toCharArray(); no extra
//                    space grows with input size beyond that
//                    (the loop itself uses O(1) auxiliary space).
class IterativeSolution {
    final int max = 2147483647;
    final int min = -2147483648;

    public int myAtoi(String s) {
        char[] chs = s.toCharArray();
        int sign = 1;
        long num = 0;
        int i = 0;

        while (i < chs.length && chs[i] == ' ')
            i++;
        if (i < chs.length && (chs[i] == '-' || chs[i] == '+')) {
            sign = chs[i] == '-' ? -1 : 1;
            i++;
        }

        for (; i < chs.length; i++) {
            if (!Character.isDigit(chs[i]))
                return (int) num * sign;
            num = num * 10 + (chs[i] - '0');
            if (num * sign >= max)
                return max;
            else if (num * sign <= min)
                return (int) min;
        }
        return (int) num * sign;
    }
}

// ---------------------------------------------------------------
// Recursive approach
// ---------------------------------------------------------------
// Description:
//   The prefix (whitespace + sign) is still handled iteratively,
//   but digit consumption is delegated to a recursive helper that
//   processes exactly one digit per call and passes the running
//   total (and sign) down through the call stack until it hits a
//   non-digit character, the end of the string, or an overflow.
//
// Time Complexity:  O(n) — the helper makes at most one recursive
//                    call per remaining character.
// Space Complexity: O(n) — O(n) for s.toCharArray() plus O(n) for
//                    the recursion call stack in the worst case
//                    (a string of all digits recurses once per
//                    character before returning); the iterative
//                    version avoids this extra stack space.
class Solution {
    private static final int INT_MAX = 2147483647;
    private static final int INT_MIN = -2147483648;

    private int helper(char[] chs, int i, int sign, long num) {
        if (i >= chs.length || (!Character.isDigit(chs[i])))
            return (int) num * sign;

        num = num * 10 + (chs[i] - '0');
        if (sign * num <= INT_MIN)
            return INT_MIN;
        if (sign * num >= INT_MAX)
            return INT_MAX;

        return helper(chs, ++i, sign, num);
    }

    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        char[] chs = s.toCharArray();

        while (i < chs.length && chs[i] == ' ')
            i++;

        if (i < chs.length && (chs[i] == '-' || chs[i] == '+')) {
            sign = chs[i] == '-' ? -1 : 1;
            i++;
        }

        return helper(chs, i, sign, 0);
    }
}

