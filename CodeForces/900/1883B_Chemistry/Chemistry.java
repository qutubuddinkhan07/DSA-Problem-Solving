import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Chemistry {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        StringBuilder res = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        while(t-- >0){
            st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] chs = br.readLine().trim().toCharArray();

            Map<Character, Integer> mpp = new HashMap<>();
            for(char ch:chs){
                mpp.put(ch, mpp.getOrDefault(ch,0)+1);
            }

            Iterator<Integer> iterator = mpp.values().iterator();
            int countOdd = 0;
            while(iterator.hasNext()){
                int freq = iterator.next();
                if(freq % 2 == 1)
                    countOdd++;
            }

            res.append(countOdd <= k+1 ? "Yes": "No").append("\n");
        }

        out.println(res);
        out.flush();
        br.close();
    }
}
