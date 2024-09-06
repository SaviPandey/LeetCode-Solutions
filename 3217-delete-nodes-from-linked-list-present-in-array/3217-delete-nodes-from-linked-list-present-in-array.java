/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        Set<Integer> s = new HashSet<>();
        
        //Add elements from array to set
        for(int i : nums){
            s.add(i);
        }
        while (head != null) {
            if (!s.contains(head.val)) {
                t.next = head;
                t = t.next;
            }
            head = head.next;
        }
        
        t.next = null;
        return dummy.next;
    }
}