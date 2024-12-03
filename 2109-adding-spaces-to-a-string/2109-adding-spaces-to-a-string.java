class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int j = 0;

        for(int i=0; i < n; i++) {
            if(j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}