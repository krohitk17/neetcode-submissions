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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), ptr = head;

        while (list1 != null && list2 != null) {
            ListNode node = new ListNode();
            if (list1.val < list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            } else {
                node.val = list2.val;
                list2 = list2.next;
            }
            ptr.next = node;
            ptr = ptr.next;

        }

        if (list1 != null) {
            ptr.next = list1;
        }

        if (list2 != null) {
            ptr.next = list2;
        }

        return head.next;
    }
}