class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1, end = maxValue(nums);
        int minPenalty = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (isPossible(nums, mid, maxOperations)) {
                minPenalty = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return minPenalty;
    }
    public int maxValue(int[] nums) {
        int maxVal = 0;
        for (int num : nums)
            maxVal = Math.max(maxVal, num);
        return maxVal;
    }
    public boolean isPossible(int[] nums, int mid, int maxOperations) {
        int totalOperations = 0;

        for (int n : nums) {
            int cnt = n / mid;
            if (n % mid == 0) cnt -= 1;

            totalOperations += cnt;
        }
        return totalOperations <= maxOperations;
    }
}