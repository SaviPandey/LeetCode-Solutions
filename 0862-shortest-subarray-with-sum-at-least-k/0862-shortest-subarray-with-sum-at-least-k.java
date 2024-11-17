class Pair {
    long sumValue;
    int index;
    Pair(long sumValue, int index) {
        this.sumValue = sumValue;
        this.index = index;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int minAns = Integer.MAX_VALUE;
        long prefixSum = 0;

        PriorityQueue<Pair> prefixSumHeap = new PriorityQueue<>((a, b) -> Long.compare(a.sumValue , b.sumValue));

        for(int j = 0; j < n ; j++) {
            prefixSum += nums[j];

            if(prefixSum >= k)
                minAns = Math.min(minAns, j + 1);
            
            while(!prefixSumHeap.isEmpty() && prefixSum - prefixSumHeap.peek().sumValue >= k){
                minAns = Math.min(minAns, j - prefixSumHeap.poll().index);
            }

            prefixSumHeap.offer(new Pair(prefixSum, j));
        }

        return minAns == Integer.MAX_VALUE ? -1 : minAns;
    
    }
}