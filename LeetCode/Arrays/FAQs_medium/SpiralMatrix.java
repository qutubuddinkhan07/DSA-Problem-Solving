package FAQs_medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem:    LC 54 - Spiral Matrix
 * Link:       https://leetcode.com/problems/spiral-matrix/
 * Pattern:    loops
 * Key idea:   One sentence: the trick that makes it work.
 * Time:       O(n + m)
 * Space:      O(n + m)
 * Solved:     after editorial
 * Date:       13/11/26 Tue 2026
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrixApproachI obj = new SpiralMatrixApproachI();
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(obj.spiralOrder(arr1));
        System.out.println(obj.spiralOrder(arr2));
    }
}

class SpiralMatrixApproachI {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // downwards
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // leftward
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // upwards
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}