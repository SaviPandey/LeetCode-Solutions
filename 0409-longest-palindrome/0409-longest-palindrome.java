class Solution {
    public int longestPalindrome(String s) {
        if(s  == null || s.length() == 0)  return 0;
        HashSet<Character> hs = new HashSet<Character>();

        int count = 0;
        for(char c : s.toCharArray()) {
            if(hs.contains(c)) {
                hs.remove(c);
                count++;
            } else {
                hs.add(c);
            }
        }
        
        return hs.isEmpty() ? count * 2 : count * 2 + 1;
    }
}