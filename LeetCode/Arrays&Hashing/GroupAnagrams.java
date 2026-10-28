import java.math.BigInteger;
import java.util.*;

public class GroupAnagrams {
    /* Problem Link: Group Anagrams [https://leetcode.com/problems/group-anagrams/description/] */
    
    public static void main(String[] args) {
        // GroupAnagramsSortedApproach obj = new GroupAnagramsSortedApproach();
        // GroupAnagramApproach2 obj = new GroupAnagramApproach2();
        GroupAnagramApproach3 obj = new GroupAnagramApproach3();
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

class GroupAnagramsSortedApproach {
    /*
    Time Complexity: O(n * k log(k))
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mpp = new HashMap<>();

        // O(n)
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // O(k log(k))
            String sortedStr = new String(chars);

            if (!mpp.containsKey(sortedStr)) {
                mpp.put(sortedStr, new ArrayList<>());
            }

            mpp.get(sortedStr).add(str);
        }

        List<List<String>> ans = new ArrayList<>(mpp.values());
        return ans;
    }
}

class GroupAnagramApproach2 {
    /*
    Time Complexity: O(n * k)
    Space Complexity: O(n)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mpp = new HashMap<>();

        // O(n)
        for (String str : strs) {
            int[] freq = new int[26];

            for (char ch : str.toCharArray()) { // O(k)
                freq[ch - 'a']++;
            }

            StringBuilder sortedStr = new StringBuilder();
            for (int i = 0; i < 26; i++) {  // O(26)
                if (freq[i] > 0) {
                    while (freq[i] > 0) {   // O(100)
                        sortedStr.append((char) (i + 'a'));
                        freq[i]--;
                    }
                }
            }

            if (!mpp.containsKey(sortedStr.toString())) {
                mpp.put(sortedStr.toString(), new ArrayList<>());
            }

            mpp.get(sortedStr.toString()).add(str);
        }

        List<List<String>> ans = new ArrayList<>(mpp.values());
        return ans;
    }
}

class GroupAnagramApproach3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<BigInteger, List<String>> mpp = new HashMap<>();

        for (String str : strs) {
            BigInteger key = BigInteger.ONE;

            for (char ch : str.toCharArray()) {
                int index = ch - 'a';
                key = key.multiply(BigInteger.valueOf(primes[index]));
            }

            mpp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(mpp.values());
    }
}