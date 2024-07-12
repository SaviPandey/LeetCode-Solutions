import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        String firstPattern, secondPattern;
        int firstScore, secondScore;

        // Decide which pattern to prioritize
        if (y > x) {
            firstPattern = "ba";
            firstScore = y;
            secondPattern = "ab";
            secondScore = x;
        } else {
            firstPattern = "ab";
            firstScore = x;
            secondPattern = "ba";
            secondScore = y;
        }

        // Stack for removing occurrences of the first pattern
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == firstPattern.charAt(1) && !stack.isEmpty() && stack.peek() == firstPattern.charAt(0)) {
                result += firstScore;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        // Stack for removing occurrences of the second pattern
        Stack<Character> newStack = new Stack<>();
        for (char ch : stack) {
            if (ch == secondPattern.charAt(1) && !newStack.isEmpty() && newStack.peek() == secondPattern.charAt(0)) {
                result += secondScore;
                newStack.pop();
            } else {
                newStack.push(ch);
            }
        }

        return result;
    }
}
