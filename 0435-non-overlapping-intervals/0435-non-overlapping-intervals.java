class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        
        int lastEnd = intervals[0][1];
        int eraseCount = 0;

        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                // Update the last end time if there's no overlap
                lastEnd = intervals[i][1];
            } else {
                // Increment the erase count if there's an overlap
                eraseCount++;
            }
        }
        return eraseCount;
    }
}