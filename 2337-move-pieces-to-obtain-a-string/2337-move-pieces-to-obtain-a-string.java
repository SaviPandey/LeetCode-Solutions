class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();

        int sId = 0, tId = 0;
        while(sId < n || tId < n) {
            while(sId < n && start.charAt(sId) == '_') sId++;
            while(tId < n && target.charAt(tId) == '_') tId++;

            if(sId == n && tId == n) return true;
            if(sId == n || tId == n) return false;

            if(start.charAt(sId) != target.charAt(tId) || start.charAt(sId) == 'L' && sId < tId || start.charAt(sId) == 'R' && sId > tId) return false;
            sId++;
            tId++;
        }
        return true;
    }
}