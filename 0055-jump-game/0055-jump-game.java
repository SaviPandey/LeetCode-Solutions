class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i< nums.length && (reachable < nums.length - 1); i++){
            if(i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + i);
        }
        return true;
    }
}