package basicStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem:    LC 451 - Sort Characters By Frequency
 * Link:       https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Pattern:    Hashing
 * Key idea:   Need to track both the character along with it's frequency
 * Solved:     after editorial
 * Date:       07/11/26 Wed 2026
 */

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequencyApproachI obj = new SortCharactersByFrequencyApproachI();
        System.out.println(obj.frequencySort("tree"));
        System.out.println(obj.frequencySort("cccaaa"));
        System.out.println(obj.frequencySort("Aabb"));
    }
}

class SortCharactersByFrequencyApproachI {
    /*
     * Time:       O(n)
     * Space:      O(n), where is the number of unique character or simply n = 26
     */
    public String frequencySort(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }

        Pair[] freq = new Pair[mpp.size()];
        int idx = 0;
        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            freq[idx++] = new Pair(entry.getKey(), entry.getValue());
        }

        Arrays.sort(freq, (i, j) -> {
            if (i.freq != j.freq) {
                return j.freq - i.freq;
            }
            return j.alphabet - i.alphabet;
        });

        StringBuilder res = new StringBuilder();
        for (Pair p : freq) {
            while (p.freq != 0) {
                res.append(p.alphabet);
                p.freq--;
            }
        }

        return res.toString();
    }

    static class Pair {
        char alphabet;
        int freq;

        Pair(char alphabet, int freq) {
            this.alphabet = alphabet;
            this.freq = freq;
        }
    }
}
