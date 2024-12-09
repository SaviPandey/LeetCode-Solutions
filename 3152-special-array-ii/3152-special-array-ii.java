class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        for(int i=1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1];
            if(nums[i - 1] % 2 == nums[i] % 2) {
                prefixSum[i]++;
            }
        }
        
        int qn = queries.length;
        boolean[] ans = new boolean[qn];
        Arrays.fill(ans, true);
        
        if(n == 1) return ans;

        for(int i=0; i < qn; i++) {
            int u = queries[i][0] , v = queries[i][1];
            int count = prefixSum[v] - prefixSum[u];

            ans[i] = (count >= 1) ? false : true;
        }
        return ans;
    }
}