class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        int count = 0;
        for(int num : banned) {
            bannedSet.add(num);
        }

        for(int i = 1; i <= n; i++) {
            if(bannedSet.contains(i)){
                continue;
            }
            if(i <= maxSum) {
                count++;
                maxSum -= i;
            } else {
                break;
            }
        }
        return count;
    }
}