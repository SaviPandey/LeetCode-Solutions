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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry; //Take Sum
            carry = value/10;                   //Update carry i.e 16/10 -> carry = 1
            l3.next = new ListNode(value % 10);  // Store sum i.e 16%10 -> 6
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        //If Both List size not equal
        while(l1 != null) {
            int value = l1.val + carry; //Take Sum
            carry = value/10;                   //Update carry i.e 16/10 -> carry = 1
            l3.next = new ListNode(value % 10);  // Store sum i.e 16%10 -> 6
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2 != null) {
            int value = l2.val + carry; //Take Sum
            carry = value/10;                   //Update carry i.e 16/10 -> carry = 1
            l3.next = new ListNode(value % 10);  // Store sum i.e 16%10 -> 6
            l2 = l2.next;
            l3 = l3.next;
        }
        if(carry != 0) {
            l3.next = new ListNode(carry);
            l3 = l3.next;
        }
        return head.next;
    }
}