class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        for(int i=1; i < sentence.length() - 1; i++) {
            if(sentence.charAt(i) == ' ') {
                // char prev = sentence.charAt(i - 1);
                // char next = sentence.charAt(i + 1);

                if(sentence.charAt(i - 1) != sentence.charAt(i + 1))
                    return false;
            }
        }
        return true;
    }
}