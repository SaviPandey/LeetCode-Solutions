class Solution {
    private static boolean isPrime(int num) {
        int limit = (int)Math.sqrt(num);
        for(int i = 2; i <= limit ; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] getPrimeList() {
        int[] primeList = new int[1001];
        primeList[3] = 2;
        for(int i = 4; i <= 1000; i++) {
            if(isPrime(i)) {
                primeList[i+1] = i;
            }
            if(primeList[i] == 0)
                primeList[i] = primeList[i-1];
        }
        return primeList;
    }

    private static int[] primeList = getPrimeList();

    public boolean primeSubOperation(int[] nums) {
        nums[0] = nums[0] - primeList[nums[0]];

        for(int i = 1; i < nums.length; i++) {
            int target = nums[i] - nums[i-1];
            if(target < 1) return false; 
            nums[i] = nums[i] - primeList[target]; 
            if(nums[i] <= nums[i-1]) return false; 
        }
        return true;
    }
}