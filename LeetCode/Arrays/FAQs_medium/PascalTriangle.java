package FAQs_medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem:    LC 118 - Pascal's Triangle
 * Link:       https://leetcode.com/problems/pascals-triangle/description/
 * Pattern:    e.g. Sliding window
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
     * Key idea:   Generating the each element by recursion and adding them to the each triangle index e.g [0,0]..
     * Time:       O(n) + O(r) + O(n-r) = O(n^3)
     * Space:      O(1)
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
     * Key idea:   Generating the rows and adding them to the triangle
     * Time:       O(n * m), where n is numRows and m is columns
     * Space:      O(1), auxiliary space is used by the recursion depth, and the returned triangle itself stores O
     * (n²) values.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            triangle.add(generateRow(i));
        }
        return triangle;
    }

    private List<Integer> generateRow(int row) {
        int ans = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(ans);

        for (int col = 1; col < row; col++) {   // O(m)
            ans = ans * (row - col);
            ans = ans / col;
            temp.add(ans);
        }
        return temp;
    }
}

class PascalTriangleApproachIII {
    /*
     * Optimal Approach
     * Key idea:   While creating rows, generating the current row with 1 then setting the column value
     * Time:       O(n²) , where n is numRows, because every value in the returned triangle is created once.
     * Space:      O(1) auxiliary space is used beyond the returned triangle, and the returned triangle stores O(numRows²) values.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> current = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                current.add(1);
            }

            for (int col = 1; col < row; col++) {
                int value =
                        triangle.get(row - 1).get(col - 1) + triangle.get(row - 1).get(col);
                current.set(col, value);
            }
            triangle.add(current);
        }
        return triangle;
    }
}
