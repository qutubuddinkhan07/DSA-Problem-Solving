package prefixSum;

public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        RangeSumQuery2DImmutableApproachI obj = new RangeSumQuery2DImmutableApproachI(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2,
                1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}

class RangeSumQuery2DImmutableApproachI {
    private int[][] prefix;
    private int rows;
    private int cols;

    public RangeSumQuery2DImmutableApproachI(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        prefix = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i + 1][j + 1] =
                        matrix[i][j]
                                + prefix[i][j + 1]
                                + prefix[i + 1][j]
                                - prefix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];
    }
}