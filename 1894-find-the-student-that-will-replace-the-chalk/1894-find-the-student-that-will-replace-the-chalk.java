class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;

        for(int i=0; i<n; i++) {
            sum += chalk[i];
        }
        // Now find the remaining chalk by dividing k by sum and take reminder.
        long rem = k % sum;

        // Now for the last iteration check if any value > remaining chalk or not. If yes, return that index.
        for(int i=0; i < n; i++){
            if(chalk[i] > rem)
                return i;
            rem -= chalk[i];
        }
        return 0;
    }

}