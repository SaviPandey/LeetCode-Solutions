class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumedBottles = 0;

        while(numBottles >= numExchange) {
            //Consume numExchange Bottles
            consumedBottles += numExchange;
            numBottles -= numExchange;
            numBottles++;   //Add one bottle for each 4 consumption
        }
        //Consume remaining bottles
        return consumedBottles + numBottles;
    }
}