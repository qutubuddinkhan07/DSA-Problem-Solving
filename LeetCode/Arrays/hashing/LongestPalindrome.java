package hashing;

/*
 * Problem:    LC 409 - Longest Palindrome
 * Link:       https://leetcode.com/problems/longest-palindrome/description/
 * Pattern:    Hashing
 * Key idea:   Tracking the even and odd frequencies & if there are odd frequencies then answer will be length + 1
 * Example:    aaabccccdd -> ccdaaadcc (9 length)
 * Time:       O(n)
 * Space:      O(128)
 * Solved:     after mistakes
 * Date:       31/10/26 Sat 2026
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindromeApproachI obj = new LongestPalindromeApproachI();
        System.out.println(obj.longestPalindrome("abccccdd"));
        System.out.println(obj.longestPalindrome("a"));
        System.out.println(obj.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(obj.longestPalindrome("bb"));
    }
}

class LongestPalindromeApproachI {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        boolean hasOddCount = false;
        int length = 0;
        for (int count : freq) {
            length += (count / 2) * 2;

            if (count % 2 == 1) {
                hasOddCount = true;
            }
        }

        return hasOddCount ? length + 1 : length;
    }
}
