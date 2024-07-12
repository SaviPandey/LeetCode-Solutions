class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];

        //Creating the Opposite index Array
        for(int i=0; i < n ; i++) {
            if(s.charAt(i) == '(') 
                opened.push(i);
            if(s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int direction = 1;
        for(int i = 0; i < n; i += direction) {
            if(s.charAt(i) == '(' || s.charAt(i) == ')') { //Jump to the opposite brace and reverse the direction
                i = pair[i];
                direction *= -1; 
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}