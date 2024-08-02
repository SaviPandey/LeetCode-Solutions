class Solution {
    public int countSeniors(String[] details) {
        int age = 0;
        int count = 0;
        for(String detail : details){
            if( ((detail.charAt(11) - '0') * 10 + (detail.charAt(12) - '0')) > 60 ) 
                count++;
        }
        return count;
    }
}