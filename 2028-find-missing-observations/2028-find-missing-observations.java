class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length ;

        int sumOfAllDiceRolled = mean * (n + m);
        int sumOfObservedRolls = 0;
        for(int roll : rolls){
            sumOfObservedRolls += roll;
        }
        int sumOfMissingRolls = sumOfAllDiceRolled - sumOfObservedRolls;

        if(sumOfMissingRolls < n || sumOfMissingRolls > 6 * n ){
            return new int[0];
        } 

        int base = sumOfMissingRolls/n;
        int remainder = sumOfMissingRolls % n;

        int result[] = new int[n];
        for(int i=0; i < n; i++){
            result[i] = base + (i < remainder ? 1 : 0);
        }

        return result;
    }
}