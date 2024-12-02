class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Approach 1 : INBUILT
        // String[] words = sentence.split(" ");
        // for(int i=0; i < words.length; i++){
        //     if(words[i].startsWith(searchWord)){
        //         return i+1;
        //     }
        // }
        // return -1;

        // Approach 2 : 2-pointer's
        int currentWordPointer = 1;
        int i = 0, n = sentence.length();

        while(i < n){
            while(i < n && sentence.charAt(i) == ' '){
                currentWordPointer++;
                i++;
            }
            int j = 0;
            while(i < n && j < searchWord.length() && sentence.charAt(i) == searchWord.charAt(j)){
                i++;
                j++;
            }
            if(j == searchWord.length()){
                return currentWordPointer;
            }
            while(i < n && sentence.charAt(i) != ' '){
                i++;
            }
        }
        return -1;
    }
}