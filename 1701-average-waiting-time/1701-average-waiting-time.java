class Solution {
    public double averageWaitingTime(int[][] customers) {
        long busyUpTill = 0, n = customers.length, waitingTime = 0;

        for(int i = 0 ; i < n ; i++) {
            int arrival = customers[i][0] , time = customers[i][1];
            waitingTime += (Math.max(arrival, busyUpTill) + time) - arrival;
            busyUpTill = Math.max(arrival, busyUpTill) + time;
        }

        return (waitingTime * 1.0) / n;
    }
}