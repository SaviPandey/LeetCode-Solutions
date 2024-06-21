class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int zeroSum = 0, windowSum = 0, maxWindowSum = 0, n = customers.length;
        //Make a window of size minutes

        for(int i = 0; i < n ; i++) { 
          if(grumpy[i] == 0) zeroSum += customers[i]; //For Non-Grumpy Minutes

          if(i < minutes) { //Sliding Window
            windowSum += (grumpy[i] == 1 ? customers[i] : 0);
          } else {
            windowSum += (grumpy[i] == 1 ? customers[i] : 0)
                        - (grumpy[i - minutes] == 1 ? customers[i - minutes] : 0);
          }
          maxWindowSum = Math.max(maxWindowSum, windowSum);
        }
        return zeroSum + maxWindowSum;
    }
}