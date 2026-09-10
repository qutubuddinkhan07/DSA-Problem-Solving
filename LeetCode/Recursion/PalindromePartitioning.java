import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioningSolution obj = new PalindromePartitioningSolution();
        System.out.println(obj.partition("aab"));
        System.out.println(obj.partition("a"));
    }
}

class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int index, String s, List<String> ds, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (checkPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));  // add string
                solve(i + 1, s, ds, ans);
                ds.remove(ds.size() - 1); // Backtrack remove last string
            }
        }
    }

    private boolean checkPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
