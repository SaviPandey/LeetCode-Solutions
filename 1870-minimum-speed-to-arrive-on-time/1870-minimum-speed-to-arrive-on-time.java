class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length; // Number of trains to travel
        if (hour <= n - 1) return -1; // Not enough time to even consider the last train

        int minSpeed = 1, maxSpeed = 10000000; // MinSpeed = 1 & MaxSpeed = 10^7
        int ans = -1;

        while (minSpeed <= maxSpeed) {
            int mid = (minSpeed + maxSpeed) / 2;
            double sum = 0;

            for (int i = 0; i < n - 1; i++) {
                sum += (dist[i] + mid - 1) / mid;  // Equivalent to Math.ceil(dist[i] / mid)
            }
            sum += (double) dist[n-1] / mid; // Exact division for the last train

            if (sum > hour) { // Took more time to reach
                minSpeed = mid + 1; // Increase the minSpeed
            } else { // Arrived on or before time
                ans = mid;
                maxSpeed = mid - 1; // Reduce the maxSpeed
            }
        }
        return ans;
    }
}
