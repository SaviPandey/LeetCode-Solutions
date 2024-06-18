class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        for( int d : difficulty) {
            maxDifficulty = Math.max(maxDifficulty, d);
        }

        int[] maxProfitUptoDifficulty = new int[maxDifficulty + 1];
        for(int i = 0; i < difficulty.length; i++){
            maxProfitUptoDifficulty[difficulty[i]] = Math.max(maxProfitUptoDifficulty[difficulty[i]], profit[i]);
        }

        for(int i = 1; i<=maxDifficulty; i++){
            maxProfitUptoDifficulty[i] = Math.max(maxProfitUptoDifficulty[i], maxProfitUptoDifficulty[i - 1]);
        }

        int totalProfit = 0;
        for(int ability : worker){
            if(ability > maxDifficulty){
                totalProfit += maxProfitUptoDifficulty[maxDifficulty];
            } else {
                totalProfit += maxProfitUptoDifficulty[ability];
            }
        }
        return totalProfit;
    }
}