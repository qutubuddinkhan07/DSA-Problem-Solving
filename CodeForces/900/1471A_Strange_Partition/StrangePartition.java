import java.util.Scanner;

public class StrangePartition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Read the number of test cases
        while (t-- > 0) {
            long n = scanner.nextLong(); // Read the size of the array
            long x = scanner.nextLong(); // Read the integer x
            long[] a = new long[(int) n]; // Declare an array to store the elements
            long min = 0, max = 0; // Initialize variables to store min and max beauty
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong(); // Read each element of the array
            }

            for (int i = 0; i < n; i++) {
                // Add the ceiling of each element divided by x to max
                max += Math.ceil(a[i] * 1.0 / x);
                // Sum up all elements to calculate min later
                min += a[i];
            }

            // Calculate min beauty by taking the ceiling of the total sum divided by x
            min = (long) Math.ceil(min * 1.0 / x);
            // Output the min and max beauty for the current test case
            System.out.println(min + " " + max);
        }
        scanner.close();
    }
}
