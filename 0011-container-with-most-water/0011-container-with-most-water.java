class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        int minHeight = 0;
        int width = 0;
        int currentArea = 0;
        while(left < right) {
            minHeight = Math.min(height[left], height[right]);
            width = right - left;
            currentArea = minHeight * width;
            maxArea = Math.max(currentArea, maxArea);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}