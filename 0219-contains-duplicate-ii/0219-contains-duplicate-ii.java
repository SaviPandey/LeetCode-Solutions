class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(nums[i])) {
                if(i - numMap.get(nums[i]) <= k ) return true;
            }
            numMap.put(nums[i], i);
        }
        return false;
    }
}