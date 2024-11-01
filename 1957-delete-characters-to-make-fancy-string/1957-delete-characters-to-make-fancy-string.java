class Solution {
    public String makeFancyString(String s) {
        int freq = 1;
        char prev = s.charAt(0);
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));

        for(int i=1; i < s.length(); i++) {
            if(s.charAt(i) == prev)
                freq++;
            else {
                prev = s.charAt(i);
                freq = 1;
            }
            if(freq < 3)
                res.append(s.charAt(i));
        }
        return res.toString();
    }
}