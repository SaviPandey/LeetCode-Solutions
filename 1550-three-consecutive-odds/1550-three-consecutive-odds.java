class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int e : arr) {
            if(e % 2 != 0 && count < 2) {
                count++;
            } else if(e % 2 != 0 && count == 2) {
                return true;
            } else {
                count = 0;  //reset count
            }
        }
        return false;
    }
}