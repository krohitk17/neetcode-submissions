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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode curr = head;
        for (int i = 0; i < n; i++) curr = curr.next;
        if (curr == null) return head.next;
        ListNode nth = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return head;
    }
}
