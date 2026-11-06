package basicStrings;

public class RotateString {
    public static void main(String[] args) {
        RotateStringSolution obj = new RotateStringSolution();
        System.out.println(obj.rotateString("abcde", "cdeab"));
        System.out.println(obj.rotateString("abcde", "abced"));
    }
}

class RotateStringSolution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            String str2 = s.substring(0, i);

            String ans = str + str2;
            if (ans.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}