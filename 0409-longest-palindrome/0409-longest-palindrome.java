class Solution {
    public int longestPalindrome(String s) {
        int[] chs = new int[58]; // Array to store frequency of each character
        for (char c : s.toCharArray()) {
            chs[c - 'A']++;
        }

        int res = 0;
        boolean hasOdd = false;

        for (int count : chs) {
            if (count % 2 == 0) {
                res += count; // Add even counts directly
            } else {
                res += count - 1; // Add the largest even part of the odd count
                hasOdd = true; // Mark that there is an odd count
            }
        }

        return hasOdd ? res + 1 : res; // If there's an odd count, add 1 for the center character
    }
}
