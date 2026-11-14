package FAQs_medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem:    LC 118 - Pascal's Triangle
 * Link:       https://leetcode.com/problems/pascals-triangle/description/
 * Pattern:    e.g. Sliding window
 * Key idea:   One sentence: the trick that makes it work.
 * Solved:     alone / with hint / after editorial
 * Date:       12/11/26 Tue 2026
 */
public class PascalTriangle {
    public static void main(String[] args) {
        // PascalTriangleApproachI obj = new PascalTriangleApproachI();
        // PascalTriangleApproachII obj = new PascalTriangleApproachII();
        PascalTriangleApproachIII obj = new PascalTriangleApproachIII();
        System.out.println(obj.generate(5));
        System.out.println(obj.generate(1));
        System.out.println(obj.generate(30));
    }
}

class PascalTriangleApproachI {
    /*
     * Extreme Brute Force
     * Time:       O(n) + O(r) + O(n-r)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                current.add((int) findNCR(row, col));
            }
            triangle.add(current);
        }
        return triangle;
    }

    /**
     * finding single - single element by using factorial (n! / (r! * (n-r)!))
     * n C r = 10 C 3
     */
    long findNCR(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }
}

class PascalTriangleApproachII {
    /*
     * Brute Force
     * Time:       O(2ⁿ), where n is numRows, because recursive cell evaluation recomputes many smaller cells while generating the triangle.
     * Space:      O(n), auxiliary space is used by the recursion depth, and the returned triangle itself stores O(n²) values.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                current.add(valueAt(row, col));
            }
            triangle.add(current);
        }
        return triangle;
    }

    private int valueAt(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }

        return valueAt(row - 1, col - 1) + valueAt(row - 1, col);
    }
}

class PascalTriangleApproachIII {
    /*
     * Brute Force
     * Time:       O(2ⁿ), where n is numRows, because recursive cell evaluation recomputes many smaller cells while generating the triangle.
     * Space:      O(n), auxiliary space is used by the recursion depth, and the returned triangle itself stores O(n²) values.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                current.add(valueAt(row, col));
            }
            triangle.add(current);
        }
        return triangle;
    }

    private int valueAt(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }

        return valueAt(row - 1, col - 1) + valueAt(row - 1, col);
    }
}
