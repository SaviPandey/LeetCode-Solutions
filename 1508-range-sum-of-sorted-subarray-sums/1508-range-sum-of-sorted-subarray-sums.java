import java.util.*;

class Solution {
    int mod = (int)1e9 + 7;

    //[elements, index]
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });

        for(int i=0; i<n ; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int sum = 0;
        for(int index=0; index < right ; index++) {
            int curr[] = pq.poll();

            if(index >= left-1) {
                sum = (sum + curr[0]) % mod;
            }
            //[3, 2]  => then 2+1 < n ? true then add in pq
            if(curr[1] + 1 < n) {
                curr[1]++;
                curr[0] = curr[0] + nums[curr[1]];
                pq.offer(curr);
            }
        }
        return sum;
    }
}