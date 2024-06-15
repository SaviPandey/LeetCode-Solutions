class Solution {
    public int numberOfChild(int n, int k) {
        // Calculate the effective number of steps within one cycle
        int cycleLength = 2 * (n - 1);
        int effectiveK = k % cycleLength;

        // Determine the final position based on the effective steps
        if (effectiveK < n) {
            // Still moving to the right
            return effectiveK;
        } else {
            // Moving to the left
            return 2 * (n - 1) - effectiveK;
        }
    }
}