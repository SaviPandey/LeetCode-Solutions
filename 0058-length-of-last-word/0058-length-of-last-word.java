class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        //Start traversal from last
        for(int i = s.length() - 1; i>= 0; i--){
            if(s.charAt(i) != ' '){
                length++;
            } else {
                if(length > 0){ //we have already started count
                    return length;
                }
            }
        }
        return length;
    }
}