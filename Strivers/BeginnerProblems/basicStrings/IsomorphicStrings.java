package basicStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    LC 205 - Isomorphic Strings
 * Link:       https://leetcode.com/problems/isomorphic-strings/description/
 * Pattern:    Hashing
 * Key idea:   Taking two maps to track each character
 * Time:       O(n)
 * Space:      O(256) => O(1), the 256 character
 * Solved:     alone / with hint / after editorial
 * Date:       05/11/26 Thu 2026
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        String s2 = "foo";
        String t2 = "bar";
        // IsomorphicStringsApproachI obj = new IsomorphicStringsApproachI();
        IsomorphicStringsApproachII obj = new IsomorphicStringsApproachII();
        System.out.println(obj.isIsomorphic(s, t));
        System.out.println(obj.isIsomorphic(s2, t2));
    }
}

class IsomorphicStringsApproachI {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpp1 = new HashMap<>();
        Map<Character, Character> mpp2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if ((mpp1.containsKey(sch) && mpp1.get(sch) != tch)
                    || (mpp2.containsKey(tch) && mpp2.get(tch) != sch)) {
                return false;
            }
            mpp1.put(sch, tch);
            mpp2.put(tch, sch);
        }

        return true;
    }
}

class IsomorphicStringsApproachII {
    public boolean isIsomorphic(String s, String t) {
        int[] mp1 = new int[256];
        int[] mp2 = new int[256];

        Arrays.fill(mp1, -1);
        Arrays.fill(mp2, -1);

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if ((mp1[sch] != -1 && mp1[sch] != tch) ||
                    (mp2[tch] != -1 && mp2[tch] != sch)) {
                return false;
            }
            mp1[sch] = tch;
            mp2[tch] = sch;
        }
        return true;
    }
}
