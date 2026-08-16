public class NearestAvailableDrone {
    /**
     *
     * Problem Link: https://leetcode.com/problems/nearest-available-drone/description/
     *
     * Input: drones = [[0,0,8],[2,2,9]], target = [3,4]
     * Output: 1
     *
     * Explanation:
     * The distance between drones[0] and target is |0 - 3| + |0 - 4| = 7, which is within its range of 8.
     * The distance between drones[1] and target is |2 - 3| + |2 - 4| = 3, which is within its range of 9.
     * Since drones[1] is the nearest drone, the answer is 1.
     */
    public static void main(String[] args) {
        NearestAvailableDroneSolution obj = new NearestAvailableDroneSolution();
        System.out.println(obj.nearestDrone(new int[][]{{0, 0, 8}, {2, 2, 9}}, new int[]{3, 4})); // 1
        System.out.println(obj.nearestDrone(new int[][]{{2, 1, 5}, {4, 4, 5}, {6, 6, 8}}, new int[]{5, 5})); // 1
        System.out.println(obj.nearestDrone(new int[][]{{4, 4, 5}}, new int[]{8, 6})); // -1
    }
}

class NearestAvailableDroneSolution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < drones.length; i++) {
            int xcord = Math.abs(drones[i][0] - target[0]);
            int ycord = Math.abs(drones[i][1] - target[1]);
            int sum = xcord + ycord;
            if (sum <= drones[i][2]) {
                if (sum < minVal) {
                    minVal = sum;
                    ans = i;
                }
            }
        }
        return ans;
    }
}