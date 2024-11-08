class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWaterStored = Integer.MIN_VALUE;
        
        while(left != right){
            int waterStored = Math.min(height[left], height[right]) * (right - left );
            if(waterStored > maxWaterStored){
                maxWaterStored = waterStored;
            }
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxWaterStored;
    }
}