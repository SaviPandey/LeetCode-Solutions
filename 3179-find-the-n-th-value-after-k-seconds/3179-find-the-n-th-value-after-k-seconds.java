class Solution {
    private static final int MOD = 1000000007;
    public int valueAfterKSeconds(int n, int k) {
        int a[] = new int[n];
        
        //Initialize with 1
        for(int i=0; i<n; i++){
            a[i] = 1;
        }

        //Perform k second Updates
        for(int second=0; second < k; second++){
            int runningSum = 0;;
            for(int i=0; i<n; i++){
                runningSum = (runningSum + a[i]) % MOD;
                a[i] = runningSum;
            }
        }
        return a[n-1];
    }
}