class Solution {
    public int majorityElement(int[] nums) {
        int candidate = findCandidate(nums);
        return candidate;
    }

    private int findCandidate(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
