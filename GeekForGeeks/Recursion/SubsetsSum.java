import java.util.ArrayList;

public class SubsetsSum {
    public static void main(String[] args) {
        // SubsetsSumRecursive obj = new SubsetsSumRecursive();
        SubsetsSumBitWise obj = new SubsetsSumBitWise();
        System.out.println(obj.subsetSums(new int[]{2, 3}));
        System.out.println(obj.subsetSums(new int[]{1, 2, 1}));
        System.out.println(obj.subsetSums(new int[]{5, 6, 7}));
    }
}

class SubsetsSumRecursive {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> sums = new ArrayList<>();
        generateSubsetsSums(0, arr, 0, sums);
        return sums;
    }

    private void generateSubsetsSums(int index, int[] arr, int sum, ArrayList<Integer> sums) {
        if (index == arr.length) {
            sums.add(sum);
            return;
        }

        sum += arr[index]; // take sum
        generateSubsetsSums(index + 1, arr, sum, sums);

        sum -= arr[index];
        generateSubsetsSums(index + 1, arr, sum, sums);
    }
}

class SubsetsSumBitWise {
    public ArrayList<Integer> subsetSums(int[] arr) {
        int n = arr.length;
        ;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num = 0; num < (1 << n); num++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0)
                    sum += arr[i];
            }
            ans.add(sum);
        }

        return ans;
    }
}