class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> ind = new ArrayList<>();
        for(int i=0; i<n; i++) {
            ind.add(i);
        }
        //Sort All robots index based on their positions first
        ind.sort((a,b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i: ind) {
            if(directions.charAt(i) == 'R') {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && healths[i] > 0) {
                if (healths[stack.peek()] < healths[i]) {
                    healths[stack.pop()] = 0;
                    healths[i] -= 1;
                } else if (healths[stack.peek()] > healths[i]) {
                    healths[stack.peek()] -= 1;
                    healths[i] = 0;
                } else {
                    healths[stack.pop()] = 0;
                    healths[i] = 0;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int v : healths) {
            if(v > 0){
                res.add(v);
            }
        }
        return res;
    }
}