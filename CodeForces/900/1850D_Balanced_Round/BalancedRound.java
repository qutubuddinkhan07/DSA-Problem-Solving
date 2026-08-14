import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BalancedRound {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder res = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            mergeSort(arr, 0, n - 1);   // O(n log n)
            int count = 1;
            int largestLength = 1;
            for (int i = 1; i < n; i++) {
                int diff = arr[i] - arr[i - 1];
                if (diff <= k) {
                    count++;
                } else {
                    count = 1;
                }
                largestLength = Math.max(largestLength, count);
            }
            res.append(n - largestLength).append("\n");
        }

        out.println(res);
        out.flush();
        br.close();
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                list.add(arr[left++]);
            else
                list.add(arr[right++]);
        }

        while (left <= mid)
            list.add(arr[left++]);
        while (right <= high)
            list.add(arr[right++]);

        for (int i = low; i <= high; i++)
            arr[i] = list.get(i - low);
    }
}
