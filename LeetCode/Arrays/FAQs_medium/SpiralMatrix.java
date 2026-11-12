package FAQs_medium;

import java.util.List;

/*
 * Problem:    LC 54 - Spiral Matrix
 * Link:       https://leetcode.com/problems/spiral-matrix/
 * Pattern:    loops
 * Key idea:   One sentence: the trick that makes it work.
 * Time:       O(?)
 * Space:      O(?)
 * Solved:     alone / with hint / after editorial
 * Date:       12/11/26 Tue 2026
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
        return null;
    }
}