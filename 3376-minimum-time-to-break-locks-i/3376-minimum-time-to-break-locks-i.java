class Solution {
    private int minTime = Integer.MAX_VALUE;
    private void calculateMinimumTime(List<Integer> strength, int currentMask, int currentFactor, int K, int elapsedTime) {
        int lockCount = strength.size();
        // If all locks have been opened (all bits in the mask are set)
        if (currentMask == (1 << lockCount) - 1) {
            minTime = Math.min(minTime, elapsedTime);
            return;
        }
        for (int i = 0; i < lockCount; i++) {
            // Skip if the lock is already processed
            if ((currentMask & (1 << i)) != 0) continue;

            // Calculate the time to open the current lock
            int additionalTime = (strength.get(i) + currentFactor - 1) / currentFactor;

            // Recurse with updated mask, factor, and elapsed time
            calculateMinimumTime(strength, currentMask | (1 << i), currentFactor + K, K, elapsedTime + additionalTime);
        }
    }
    public int findMinimumTime(List<Integer> strength, int K) {
        calculateMinimumTime(strength, 0, 1, K, 0);
        return minTime;
    }
}