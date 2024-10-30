
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] upLenAtIndex = populateLenAtIndexArr(nums, true);
        int[] downLenAtIndex = populateLenAtIndexArr(nums, false);
        
        int minElemToRemove = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int upCount = upLenAtIndex[i], downCount = downLenAtIndex[i];
            if (upCount == 1 || downCount == 1) continue;
            minElemToRemove = Math.min(minElemToRemove, n - (upCount + downCount - 1));
        }
        
        return minElemToRemove;
        // time - O(NlogN)
        // space - O(N)
    }
    
    private int[] populateLenAtIndexArr(int[] nums, boolean up) {
        int n = nums.length;
        int[] lenAtIndexArr = new int[n];
        int[] LIS = new int[n];
        int pos = 0;
        if (up) {
            for (int i = 0; i < n; i++) {
                int val = binarySearch(LIS, 0, pos, nums[i]);
                LIS[val] = nums[i];
                if (val == pos) {
                    pos++;
                    lenAtIndexArr[i] = pos;
                } else
                    lenAtIndexArr[i] = lenAtIndexArr[val];
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                int val = binarySearch(LIS, 0, pos, nums[i]);
                LIS[val] = nums[i];
                if (val == pos) {
                    pos++;
                    lenAtIndexArr[i] = pos;
                } else
                    lenAtIndexArr[i] = lenAtIndexArr[val];
            }
        }
        return lenAtIndexArr;
    }
    
    private int binarySearch(int[] LIS, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (LIS[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}