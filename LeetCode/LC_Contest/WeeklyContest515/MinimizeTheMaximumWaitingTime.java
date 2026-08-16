import java.util.Arrays;

public class MinimizeTheMaximumWaitingTime {
    /**
     *
     * Problem Link: https://leetcode.com/problems/minimize-the-maximum-waiting-time-at-synchronized-traffic-lights/description/
     *
     * Formula:
     * wait(r) = 0            if r < M
     *         = period - r    if r >= M
     *
     * Compute M = max(lights).
     * For each arrival time, compute r = arrivalTime[j] % period, then apply the formula above.
     * Return the maximum wait across all cars.
     */
    public static void main(String[] args) {
        MinimizeTheMaximumWaitingTimeSolution obj = new MinimizeTheMaximumWaitingTimeSolution();
        int period = 8;
        int[] lights = {2, 3}, arrivalTime = {2, 5, 8, 11};
        System.out.println(obj.minPenalty(period, lights, arrivalTime));

        int period2 = 10;
        int[] lights2 = {3, 6, 8}, arrivalTime2 = {4, 9, 15};
        System.out.println(obj.minPenalty(period2, lights2, arrivalTime2));

        int period3 = 5;
        int[] lights3 = {2}, arrivalTime3 = {2, 3, 4, 5, 6};
        System.out.println(obj.minPenalty(period3, lights3, arrivalTime3));
    }
}

class MinimizeTheMaximumWaitingTimeSolution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int M = Arrays.stream(lights).max().getAsInt();
        int ans = Integer.MIN_VALUE;
        for (int arrival : arrivalTime) {
            int r = arrival % period;
            int wait = r < M ? 0 : period - r;
            ans = Math.max(ans, wait);
        }
        return ans;
    }
}