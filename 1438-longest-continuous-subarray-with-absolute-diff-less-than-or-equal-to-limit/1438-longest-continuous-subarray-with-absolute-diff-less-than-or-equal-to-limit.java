class Solution {
    class MonotonicQueue{
        LinkedList<Integer> maxq = new LinkedList<>();
        LinkedList<Integer> minq = new LinkedList<>();

        public void push(int val) {
            while (!maxq.isEmpty() && maxq.getLast() < val) {
                maxq.removeLast();
            }
            maxq.addLast(val);

            while (!minq.isEmpty() && minq.getLast() > val) {
                minq.removeLast();
            }
            minq.addLast(val);
        }

        public int max(){
            return maxq.getFirst();
        }
        public int min() {
            return minq.getFirst();
        }

        public void pop(int val) {
            if (maxq.getFirst() == val) {
                maxq.removeFirst();
            }
            if (minq.getFirst() == val) {
                minq.removeFirst();
            }
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        int i=0,j= 0;
        int len = 0, maxLen = 0;
        MonotonicQueue window = new MonotonicQueue();
        while (j<nums.length) {
            window.push(nums[j]);
            j++;
            len++;
            while (window.max()-window.min() > limit) {
                window.pop(nums[i]);
                i++;
                len--;
            }
            // len = j-i
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}

