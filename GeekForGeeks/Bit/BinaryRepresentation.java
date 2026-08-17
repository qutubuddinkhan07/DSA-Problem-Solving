public class BinaryRepresentation {
    public static void main(String[] args) {
//        BinaryRepresentationSolution obj = new BinaryRepresentationSolution();
        BinaryRepresentationSolution2 obj = new BinaryRepresentationSolution2();
        System.out.println(obj.getBinaryRep(5));
        System.out.println(obj.getBinaryRep(32));
    }
}

class BinaryRepresentationSolution {
    // this gives the output in 32-bits format
    public String getBinaryRep(int n) {
        char[] ans = new char[32];
        for (int i = 0; i < 32; i++) ans[i] = '0';

        for (int i = 0; i < 32; i++) {
            if (n % 2 == 1) ans[31 - i] = '1';
            n /= 2;
        }
        return new String(ans);
    }
}

class BinaryRepresentationSolution2 {
    // this gives the output in %4 bits format
    public String getBinaryRep(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            ans.append(rem);
            n /= 2;
        }

        while (ans.length() % 4 != 0) {
            ans.append('0');
        }

        return ans.reverse().toString();
    }
}
