package Fundamentals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaultyKeyboard {
    /* Problem Link: 2810. Faulty Keyboard [https://leetcode.com/problems/faulty-keyboard/description/] */
    public static void main(String[] args) {
        FaultyKeyboardSolution obj = new FaultyKeyboardSolution();
        String s1 = "string";
        String s2 = "poiinter";
        System.out.println(obj.finalString(s1));
        System.out.println(obj.finalString(s2));
    }
}

class FaultyKeyboardSolution {
    public String finalString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<Character> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (chars[i] == 'i') {
                Collections.reverse(res);
            } else {
                res.add(chars[i]);
            }
        }

        String ans = res.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

        return ans;
    }
}
